package com.FoolishFridge.FoolishFridge.services;

import org.springframework.stereotype.Service;

import com.FoolishFridge.FoolishFridge.responses.PaymentResponse;
import com.stripe.exception.StripeException;

@Service
public interface PaymentService {
    public PaymentResponse createPaymentLink() throws StripeException;

}
