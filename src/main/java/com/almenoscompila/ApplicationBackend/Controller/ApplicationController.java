package com.almenoscompila.ApplicationBackend.Controller;

import com.almenoscompila.ApplicationBackend.Domain.User;
import com.almenoscompila.ApplicationBackend.Persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationController implements InterfaceAPI {

    private UserDAO userDAO;

    @Autowired
    public ApplicationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String signUp(String username, String email, String password, String description, String profilePic) {
        try {
            User newUser = new User(username, email, password, description, profilePic, 0, 0);
            this.userDAO.insertUser(newUser);

            return "todo genial chico";

        } catch (Exception e) {
            
            return "sa jodio chacho";
        }
    }

    @Override
    public String getXp(String username, int amount) {
        return null;
    }

    @Override
    public String getLevel(String username) {
        return null;
    }

    @Override
    public String updateChat(String username) {
        return null;
    }

    @Override
    public String getChat(String user1, String user2) {
        return null;
    }

    @Override
    public String sendMessage(String sender, String receiver, String messageContent) {
        return null;
    }

    @Override
    public String updateMap(String location) {
        return null;
    }

    @Override
    public String getNearRequests(String location, int radius) {
        return null;
    }

    @Override
    public String getRequest(String requestId) {
        return null;
    }

    @Override
    public String postRequest(String title, String description, String location, boolean demand, String userMail, String requestId, String requestMail, String category) {
        return null;
    }

    @Override
    public String completeRequest(String requestId, String location, String requestCreator, String[] participants) {
        return null;
    }
}
