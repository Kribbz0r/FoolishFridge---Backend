package com.FoolishFridge.FoolishFridge.models;

public class FoolishFridgeOrder {

    private int price;

    public FoolishFridgeOrder() {
    }

    public FoolishFridgeOrder(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
