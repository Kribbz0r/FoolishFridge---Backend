package com.FoolishFridge.FoolishFridge.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.format.DateTimeFormatter;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.FoolishFridge.FoolishFridge.models.FoolishFridgeData;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class FoolishFridgeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenFoolishFridgeDataObjectInRequestBodyWhenNewFoolishFridgeEntryIsCalledThenReturnFoolishFridgeObject()
            throws Exception {

        FoolishFridgeData foolishFridgeDataMock = new FoolishFridgeData("0", "10000");

        mockMvc.perform(post("/FoolishFridge")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(foolishFridgeDataMock)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isString())
                .andExpect(jsonPath("$.dateTime").isString())
                .andExpect(jsonPath("$.warning").value(0))
                .andExpect(jsonPath("$.time").value(10000));
    }

}
