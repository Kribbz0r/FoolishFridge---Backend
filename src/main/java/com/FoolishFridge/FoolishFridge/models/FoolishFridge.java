package com.FoolishFridge.FoolishFridge.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FoolishFridge")
public class FoolishFridge {

    @Id
    private String id;
    private int warning;
    private int time;
    private String dateTime;

    public FoolishFridge() {
    }

    public FoolishFridge(int warning, int time, String dateTime) {
        this.warning = warning;
        this.time = time;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
