package com.example.fran.appiumtechtalk.bussines;

/**
 * Created by fran on 26/06/17.
 */

public class ListItem {

    private String title;
    private String description;

    public ListItem() {
    }

    public ListItem(String title, String description) {
        this.title = title;
        this.description = description;
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
}
