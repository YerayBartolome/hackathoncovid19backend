package com.almenoscompila.ApplicationBackend.Persistence;

import com.almenoscompila.ApplicationBackend.Domain.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDAO {

    private final JdbcTemplate jdbcTemplate;

    public RequestDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_REQUEST = "insert into request (title, description, location, demand, user_mail) values (?, ?, ?, ?, ?)";
    private final String INSERT_CATEGORY = "insert into request_category (request_id, request_mail, category_name) values (?, ?, ?)";
    private final String INACTIVE_REQUEST = "update request set active = '0'";

    private final RowMapper<Request> mapperRequest = (resultSet, i) -> {
        return new Request.RequestBuilder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .description(resultSet.getString("description"))
                .location(resultSet.getString("location"))
                .demand(resultSet.getBoolean("demand"))
                .build();
    };

    public int insertRequest(Request request) {
        return jdbcTemplate.update(INSERT_REQUEST, request.getId());
    }

}