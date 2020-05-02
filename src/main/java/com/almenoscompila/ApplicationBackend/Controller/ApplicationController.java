package com.almenoscompila.ApplicationBackend.Controller;

import com.almenoscompila.ApplicationBackend.Domain.Request;
import com.almenoscompila.ApplicationBackend.Domain.User;
import com.almenoscompila.ApplicationBackend.Persistence.RequestDAO;
import com.almenoscompila.ApplicationBackend.Persistence.UserDAO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController implements InterfaceAPI {

    private UserDAO userDAO;
    private RequestDAO requestDAO;

    @Autowired
    public ApplicationController(UserDAO userDAO, RequestDAO requestDAO) {
        this.userDAO = userDAO;
        this.requestDAO = requestDAO;
    }

    @Override
    public String login(String username, String password) throws JSONException {
        try {
            List<User> newUser = this.userDAO.retrieveUser(username);

            return crearJSON(newUser.get(0).getUsername()+","+newUser.get(0).getEmail()+","+newUser.get(0).getDescription()+","+newUser.get(0).getProfilePic(), "");

        } catch (Exception e) {

            return crearJSON("", "Login error");
        }
    }

    @Override
    public String signUp(String username, String password) throws JSONException {
        try {
            User newUser = new User(username, null, password, null, null, 0, 0);
            this.userDAO.insertUser(newUser);

            return crearJSON(username, "");

        } catch (Exception e) {

            return crearJSON("", "Sign Up error");
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
    public String postRequest(String title, String description, String location, boolean demand, String username, ArrayList<String> category) throws JSONException {
        try {
            this.requestDAO.insertRequest(new Request(title, description, location, category, demand);
            //insertRequest(Request request, User user)
            return crearJSON(title+","+description+","+location+","+demand+","+username,"");
        } catch (Exception e) {

            return crearJSON("", "Request creation error");
        }
    }

    @Override
    public String completeRequest(String requestId, String location, String requestCreator, String[] participants) {
        return null;
    }

    public String crearJSON(String str1, String str2) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("res", str1);
        json.put("err", str2);
        String json2 = json.toString();
        return json2;
    }
}
