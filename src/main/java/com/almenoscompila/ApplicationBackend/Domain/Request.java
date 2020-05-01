package com.almenoscompila.ApplicationBackend.Domain;
import java.awt.*;
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

    public Request(RequestBuilder requestBuilder) {
        this.id = requestBuilder.id;
        this.title = requestBuilder.title;
        this.description = requestBuilder.description;
        this.location = requestBuilder.location;
        this.categories = requestBuilder.categories;
        this.demand = requestBuilder.demand;
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

    public static class RequestBuilder {

        public String title, description, location;
        public ArrayList<String> categories;
        public boolean demand;
        public int id;

        public RequestBuilder() {
        }

        public Request.RequestBuilder title(String title){
            this.title= title;
            return this;
        }

        public Request.RequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Request.RequestBuilder location(String location) {
            this.location = location;
            return this;
        }

        public Request.RequestBuilder id(int id){
            this.id = id;
            return this;
        }

        public Request.RequestBuilder demand(boolean demand){
            this.demand = demand;
            return this;
        }

        public Request.RequestBuilder categories(ArrayList<String> categories){
            this.categories = categories;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }

}
