package com.FoolishFridge.FoolishFridge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoolishFridge.FoolishFridge.models.FoolishFridgeOrder;
// import com.FoolishFridge.FoolishFridge.dto.CreatePayment;
// import com.FoolishFridge.FoolishFridge.dto.CreatePaymentResponse;
import com.FoolishFridge.FoolishFridge.responses.PaymentResponse;
import com.FoolishFridge.FoolishFridge.services.PaymentService;
import com.stripe.exception.StripeException;
// import com.stripe.model.PaymentIntent;
// import com.stripe.param.PaymentIntentCreateParams;

@RestController
@CrossOrigin("*")
public class StripeController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/api/embedded-checkout")
    public ResponseEntity<PaymentResponse> createOrder() throws StripeException {

        PaymentResponse paymentResponse = paymentService.createPaymentLink();
        System.out.println("hallå eller");
        return new ResponseEntity(paymentResponse, HttpStatus.OK);

    }

}
