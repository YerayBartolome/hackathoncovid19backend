package com.almenoscompila.ApplicationBackend.Controller;

public class ApplicationController implements InterfaceAPI {
    
    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String signUp(String username, String email, String password, String description, String profilePic) {
        return null;
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
