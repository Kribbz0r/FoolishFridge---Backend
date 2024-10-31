package com.FoolishFridge.FoolishFridge.models.ai;

import java.util.ArrayList;
import java.util.List;

public class MessageRequest {

    private String model;
    private List<Message> messages;
    private int n;

    public MessageRequest() {

    }

    public MessageRequest(String model, String prompt, int n) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("system",
                "Om 'warning' är 1 har kylskåpet varit öppet mer än tillåtet, varna om så är fallet. Om 'warning' är 0 har kylskåpet varit öppet i en tillåten tid, informera användaren om detta är fallet. Om 'warning inte är 0 eller 1 har något gått fel, informera om så är fallet"));
        this.messages.add(new Message("system",
                "'time' är tiden i millisekunder som kylskåpsdörren varit öppen. Informera hur länge kylskåpsdärren varit öppen i minuter och sekunder "));
        this.messages.add(new Message("user", prompt));
        this.n = n;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}
