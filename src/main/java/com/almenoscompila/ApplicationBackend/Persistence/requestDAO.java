package com.almenoscompila.ApplicationBackend.Persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class requestDAO {

    private final JdbcTemplate jdbcTemplate;

    public requestDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_REQUEST = "insert into request (title, description, location, demand, user_mail) values (?, ?, ?, ?, ?)";
    private final String INSERT_CATEGORY = "insert into request_category (request_id, request_mail, category_name) values (?, ?, ?)";
    private final String INACTIVE_REQUEST = "update request set active = '0'";


}
