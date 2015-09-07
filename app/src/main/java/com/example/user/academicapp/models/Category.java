package com.example.user.academicapp.models;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private String picture;
    private String color;
    private List<Topic> topics = new ArrayList<Topic>();

    public Category() {
    }

    public Category(String color) {
        this.color = color;
    }

    public Category(String name, String color, List<Topic> topics) {
        this.name = name;
        this.color = color;
        this.topics.addAll(topics);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
