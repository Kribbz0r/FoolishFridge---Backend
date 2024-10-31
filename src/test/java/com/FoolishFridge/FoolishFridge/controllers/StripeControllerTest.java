package com.FoolishFridge.FoolishFridge.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.FoolishFridge.FoolishFridge.responses.PaymentResponse;

public class StripeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenUserCancelsStripePaymentWhenHandelingStripePaymentThenRidirectToFailWebsite() throws Exception {

        PaymentResponse paymentResponse;

        // Hur i hela friden ska detta se ut?

    }

}
