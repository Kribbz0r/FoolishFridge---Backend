package com.FoolishFridge.FoolishFridge.serviceTests.aiTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.FoolishFridge.FoolishFridge.models.ai.AiMessageResponse;
import com.FoolishFridge.FoolishFridge.services.ai.MessageService;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @Test
    public void givenValidPromptWhenPostRequestThenReturnOk() {
        String validPrompt = "Valid prompt";
        AiMessageResponse response = messageService.aiMessageResponse(validPrompt);
        Assertions.assertNotNull(response, "Response should not be null when valid string is passed.");
    }

    @Test
    public void givenNullAsPromptWhenAttemptingToCallAIMessageResponseThenReturnError() {
        String invalidPrompt = null;
        Assertions.assertThrows(Error.class, () -> {
            messageService.aiMessageResponse(invalidPrompt);
        }, "The prompt was Null. This is illegal");
    }

    @Test
    public void givenAnEmptyStringAsPromptWhenAttemptingToCallAIMessageResponseThenReturnError() {
        String emptyPrompt = "";
        Assertions.assertThrows(Error.class, () -> {
            messageService.aiMessageResponse(emptyPrompt);
        }, "The prompt was an empty String. This is illegal");
    }
}
