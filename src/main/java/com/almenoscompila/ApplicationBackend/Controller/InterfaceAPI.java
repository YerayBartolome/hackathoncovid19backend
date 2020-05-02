package com.almenoscompila.ApplicationBackend.Controller;

import com.almenoscompila.ApplicationBackend.Domain.User;
import org.json.JSONException;

import java.util.ArrayList;

public interface InterfaceAPI {

    String login(String username, String password) throws JSONException;

    String signUp(String username, String password) throws JSONException;

    String getXp(String username, int amount);

    String getLevel(String username);

    String updateChat(String username);

    String getChat(String user1, String user2);

    String sendMessage(String sender, String receiver, String messageContent);

    String updateMap(String location);

    String getNearRequests(String location, int radius);

    String getAllRequests() throws JSONException;

    String getRequest(String requestId);

    String postRequest(String title, String description, String location, boolean demand, ArrayList<String> category) throws JSONException;

    String completeRequest(String requestId, String location, String requestCreator, String[] participants);


}
