package com.almenoscompila.ApplicationBackend.Persistence;

import com.almenoscompila.ApplicationBackend.Domain.Request;
import com.almenoscompila.ApplicationBackend.Domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestDAO {

    private final JdbcTemplate jdbcTemplate;

    public RequestDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_REQUEST = "insert into request (title, description, location, demand, user_mail) values (?, ?, ?, ?, ?)";
    private final String INSERT_CATEGORY = "insert into request_category (request_id, request_username, category_name) values (?, ?, ?)";
    private final String INACTIVE_REQUEST = "update request set active = '0'";
    private final String FIND_LAST_REQUEST = "select max(to_number(regexp_substr(recipe_id, '\\d+'))) id from request where username = ?";

    private final RowMapper<Request> mapperRequest = (resultSet, i) -> {
        return new Request.RequestBuilder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .description(resultSet.getString("description"))
                .location(resultSet.getString("location"))
                .demand(resultSet.getBoolean("demand"))
                .build();
    };

    private final RowMapper<Request> lastRequest = (resultSet, i) -> {
        return new Request.RequestBuilder()
                .id(resultSet.getInt("id"))
                .build();
    };

    public int insertRequest(Request request, String user) {
        return jdbcTemplate.update(INSERT_REQUEST, request.getTitle(), request.getDescription(),
                request.getLocation(), request.isDemand(), user);
    }

    public int insertCategory (int id, String username, String category) {
            return jdbcTemplate.update(INSERT_CATEGORY, id, username, category);
        }

    public List<Request> findLastRequest(String user) {
        return jdbcTemplate.query(FIND_LAST_REQUEST, new Object[] {user}, lastRequest);
    }

}