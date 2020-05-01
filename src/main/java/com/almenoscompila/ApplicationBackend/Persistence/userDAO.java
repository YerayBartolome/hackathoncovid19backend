package com.almenoscompila.ApplicationBackend.Persistence;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class userDAO {

    private final JdbcTemplate jdbcTemplate;

    public userDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_USER = "insert into user (mail, username, password, phonenumber, photo) values (?, ?, ?, ?, ?)";
    private final String FIND_USER = "select * from registered_user where mail = ?";
    private final String UPDATE_USERNAME = "update user set username = ?";
    private final String UPDATE_PASSWORD = "update user set password = ?";
    private final String UPDATE_PHONENUMBER = "update user set phonenumber = ?";
    private final String UPDATE_PHOTO = "update user set photo = ?";







}
