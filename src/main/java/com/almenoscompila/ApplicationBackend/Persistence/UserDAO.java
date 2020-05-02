package com.almenoscompila.ApplicationBackend.Persistence;


import com.almenoscompila.ApplicationBackend.Domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_USER = "insert into user (username, password) " + "values (?, ?)";
    private final String FIND_USER = "select * from registered_user where mail = ?";
    private final String UPDATE_USERNAME = "update user set username = ?";
    private final String UPDATE_PASSWORD = "update user set password = ?";
    private final String UPDATE_XP = "update user set xp = ?";
    private final String UPDATE_LEVEL = "update user set nivel = ?";
    private final String UPDATE_PHOTO = "update user set photo = ?";


    private final RowMapper<User> mapperUser = (resultSet, i) -> {
        return new User.UserBuilder()
                .email(resultSet.getString("email"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .profilePic(resultSet.getString("photo"))
                .description(resultSet.getString("description"))
                .level(resultSet.getInt("nivel"))
                .experience(resultSet.getInt("xp"))
                .build();
    };


    public int insertUser(User user) {
        return jdbcTemplate.update(INSERT_USER, user.getUsername(), user.getPassword());
    }

    public List<User> retrieveUser(String username) {
        return jdbcTemplate.query(FIND_USER, mapperUser);
    }



}
