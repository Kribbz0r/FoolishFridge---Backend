package com.FoolishFridge.FoolishFridge.services.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.FoolishFridge.FoolishFridge.models.ai.AiMessageResponse;
import com.FoolishFridge.FoolishFridge.models.ai.MessageRequest;

@Service
public class MessageService {

    @Value("${openai.api.url}")
    String apiUrl;

    private final RestTemplate restTemplate;

    public MessageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AiMessageResponse aiMessageResponse(String prompt) throws Error {

        if (prompt == null || prompt.trim().isEmpty()) {
            throw new Error("Prompt cannot be null or empty");
        }

        MessageRequest messageRequest = new MessageRequest("gpt-4o", prompt, 1);
        AiMessageResponse aiMessageResponse = restTemplate.postForObject(apiUrl, messageRequest,
                AiMessageResponse.class);

        if (aiMessageResponse == null) {
            throw new Error("Failed to obtain a response.");
        }
        return aiMessageResponse;

    }

}
