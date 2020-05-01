package com.almenoscompila.ApplicationBackend.Domain;
import java.util.ArrayList;

public class Request {

    private int id;
    private String title;
    private String description;
    private String location;
    private ArrayList<String> categories;
    private boolean demand;

    public Request(int id, String title, String description, String location, ArrayList<String> categories, boolean demand) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.categories = categories;
        this.demand = demand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public boolean isDemand() {
        return demand;
    }

    public void setDemand(boolean demand) {
        this.demand = demand;
    }

}
