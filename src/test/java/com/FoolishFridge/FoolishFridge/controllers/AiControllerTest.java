package com.FoolishFridge.FoolishFridge.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import java.text.ChoiceFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.FoolishFridge.FoolishFridge.models.ai.AiMessageResponse;
import com.FoolishFridge.FoolishFridge.models.ai.AiMessageResponse.Choice;
import com.FoolishFridge.FoolishFridge.models.ai.Message;
import com.FoolishFridge.FoolishFridge.services.ai.MessageService;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;

@SpringBootTest
@AutoConfigureMockMvc
public class AiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    // @Test
    // void
    // givenStringInRequestBodyWhenAiMessageIsCalledThenReturnArrayWithOneString() {

    // String mockResponseString = "This should be returned";
    // AiMessageResponse mockAiMessageResponse = new AiMessageResponse();

    // mockAiMessageResponse.setChoices(List.of(new Choice(new
    // Message(mockResponseString))));

    // when(messageService.aiMessageResponse(anyString())).thenReturn(mockAiMessageResponse);

    // mockMvc.perform(post("/Fetch/AiMessage")
    // .contentType(MediaType.TEXT_PLAIN)
    // .content("Mocked String for the AI to process"))
    // .andExpect(status().isOk())
    // .andExpect(content().string(mockResponseString));

    // }

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
