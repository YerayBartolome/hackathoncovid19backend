package com.almenoscompila.ApplicationBackend.Persistence;

import com.almenoscompila.ApplicationBackend.Domain.User;
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

    private final RowMapper<User> mapperUser = (resultSet, i) -> {
        return new User.UserBuilder()
                .email(resultSet.getString("email"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .build();
    };

}
