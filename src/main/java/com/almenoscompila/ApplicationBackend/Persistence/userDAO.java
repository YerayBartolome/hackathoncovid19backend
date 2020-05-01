package com.almenoscompila.ApplicationBackend.Persistence;


import com.almenoscompila.ApplicationBackend.Domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

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


    public int insertUser(User user) {
        Blob photoConverted = imageToBlob(user.getProfilePic());
        return jdbcTemplate.update(INSERT_USER, user.getUsername(), user.getPassword(), user.getPhonenumber(), user.getProfilePic());
    }




    public static Blob imageToBlob (Image imagen ) {

        Blob imagenBlob = null;
        BufferedImage bi = new BufferedImage ( imagen.getWidth ( null ), imagen.getHeight ( null ), BufferedImage.TYPE_INT_ARGB );
        Graphics bg = bi.getGraphics ();
        bg.drawImage ( imagen, 0, 0, null );
        bg.dispose ();

        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
        try {
            ImageIO.write (
                    bi,
                    imagen.getDescription ().substring (
                            imagen.getDescription ().length () - 3 ), baos );
            baos.flush ();
            baos.close ();
        } catch ( IOException e ) {
            e.printStackTrace ();
        }

        byte [] imagenByte = baos.toByteArray ();

        try {
            imagenBlob = new SerialBlob( imagenByte );
        } catch ( SerialException se ) {
            se.printStackTrace ();
        } catch ( SQLException sqle ) {
            sqle.printStackTrace ();
        }
        return imagenBlob;
    }
}
