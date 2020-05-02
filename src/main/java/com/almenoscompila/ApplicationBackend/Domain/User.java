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
    private String description;
    private String profilePic;
    private int experience, level;

    public User(String username, String email, String password, String description, String profilePic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.profilePic = profilePic;
    }

    public User(UserBuilder userBuilder) {
        this.email = userBuilder.email;
        this.username = userBuilder.username;
        this.password = userBuilder.password;
        this.description = userBuilder.description;
        this.profilePic = userBuilder.profilePic;
        this.experience = userBuilder.experience;
        this.level = userBuilder.level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public static class UserBuilder {

        public String username, password, email, description, profilePic;
        public int experience, level;

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

        public UserBuilder description(String description){
            this.description = description;
            return this;
        }

        public UserBuilder profilePic(String profilePic){
            this.profilePic = profilePic;
            return this;
        }

        public UserBuilder experience(int experience){
            this.experience = experience;
            return this;
        }

        public UserBuilder level(int level){
            this.level = level;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
