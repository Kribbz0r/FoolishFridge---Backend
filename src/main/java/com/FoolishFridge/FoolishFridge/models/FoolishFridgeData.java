package com.FoolishFridge.FoolishFridge.models;

public class FoolishFridgeData {

    private String warning;
    private String doorOpenTime;

    public FoolishFridgeData() {
    }

    public FoolishFridgeData(String warning, String doorOpenTime) {
        this.warning = warning;
        this.doorOpenTime = doorOpenTime;

    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getDoorOpenTime() {
        return doorOpenTime;
    }

    public void setDoorOpenTime(String doorOpenTime) {
        this.doorOpenTime = doorOpenTime;
    }

}
