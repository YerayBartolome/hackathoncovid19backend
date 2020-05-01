package com.almenoscompila.ApplicationBackend.Persistence;


import com.almenoscompila.ApplicationBackend.Domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import com.almenoscompila.ApplicationBackend.Domain.User;

@Repository
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String INSERT_USER = "insert into user (mail, username, password, description, photo, nivel, xp) " +
            "values (?, ?, ?, ?, ?, ?)";
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
                .level(resultSet.getInt("nivel"))
                .experience(resultSet.getInt("xp"))
                .build();
    };


    public int insertUser(User user) {
        return jdbcTemplate.update(INSERT_USER, user.getEmail(), user.getUsername(), user.getPassword(),
                user.getDescription(), user.getProfilePic(), user.getLevel(), user.getExperience());
    }

    public List<User> retrieveUser(String username) {
        return jdbcTemplate.query(FIND_USER, mapperUser);
    }





}
