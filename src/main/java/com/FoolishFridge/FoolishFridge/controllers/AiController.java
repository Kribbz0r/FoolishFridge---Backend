package com.FoolishFridge.FoolishFridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoolishFridge.FoolishFridge.models.FoolishFridge;
import com.FoolishFridge.FoolishFridge.models.ai.AiMessageResponse;
import com.FoolishFridge.FoolishFridge.services.ai.MessageService;

@RestController
@CrossOrigin("*")
public class AiController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/Fetch/AiMessage")
    public String aiMessage(@RequestBody String prompt) {

        AiMessageResponse response = messageService.aiMessageResponse(prompt);

        System.out.println("Detta kom in: " + prompt);
        System.out.println("Detta skickas: " + response.getChoices().get(0).getMessage().getContent());

        return response.getChoices().get(0).getMessage().getContent();

    }

}
