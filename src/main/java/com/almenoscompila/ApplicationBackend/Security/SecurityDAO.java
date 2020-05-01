package com.almenoscompila.ApplicationBackend.Security;

import com.almenoscompila.ApplicationBackend.Domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SecurityDAO {
    JdbcTemplate jdbcTemplate;

    private final String INSERT_ROLE = "INSERT INTO authorities (username, role) values(?, ?)";

    public SecurityDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createRole(User user) {
        jdbcTemplate.update(INSERT_ROLE, user.getUsername(), "ROLE_USER");
    }
}