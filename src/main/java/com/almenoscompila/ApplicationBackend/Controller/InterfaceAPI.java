package com.almenoscompila.ApplicationBackend.Controller;

import com.almenoscompila.ApplicationBackend.Domain.User;

public interface InterfaceAPI {

    String login(String username, String password);

    String signUp(String username, String email, String password, String description, String profilePic);

    String getXp(String username, int amount);

    String getLevel(String username);

    String updateChat(String username);

    String getChat(String user1, String user2);

    String sendMessage(String sender, String receiver, String messageContent);

    String updateMap(String location);

    String getNearRequests(String location, int radius);

    String getRequest(String requestId);

    String postRequest(String title, String description, String location, boolean demand, String userMail, String requestId, String requestMail, String category);

    String completeRequest(String requestId, String location, String requestCreator, String[] participants);


}
