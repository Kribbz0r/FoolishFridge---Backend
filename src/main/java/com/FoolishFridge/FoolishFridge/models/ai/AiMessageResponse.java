package com.FoolishFridge.FoolishFridge.models.ai;

import java.util.List;

public class AiMessageResponse {

    private List<Choice> choices;

    public AiMessageResponse() {
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    };

    public static class Choice {
        private Message message;

        public Choice() {
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

    }

}
