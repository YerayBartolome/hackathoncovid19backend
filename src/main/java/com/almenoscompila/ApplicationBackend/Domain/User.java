package com.almenoscompila.ApplicationBackend.Domain;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class User {

    private String username;
    private String email;
    private String password;
    private String phonenumber;
    private Image profilePic;

    public User(String username, String email, String password, String phonenumber, Image profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        if (profilePic == null) {
            File file = new File("resources/static/DefaultProfilePic.jpg");
            BufferedImage pic = null;
            try {
                pic = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.profilePic = profilePic;
    }

    public User(UserBuilder userBuilder) {
        this.email = userBuilder.email;
        this.username = userBuilder.username;
        this.password = userBuilder.password;
        this.phonenumber = userBuilder.phonenumber;
        this.profilePic = userBuilder.profilePic;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Image getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Image profilePic) {
        this.profilePic = profilePic;
    }

    public static class UserBuilder {

        public String username, password, email, phonenumber;
        public Image profilePic;

        public UserBuilder() {
        }

        public UserBuilder email(String email){
            this.email= email;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder phonenumber(String phonenumber){
            this.phonenumber = phonenumber;
            return this;
        }

        public UserBuilder profilePic(Image profilePic){
            this.profilePic = profilePic;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
