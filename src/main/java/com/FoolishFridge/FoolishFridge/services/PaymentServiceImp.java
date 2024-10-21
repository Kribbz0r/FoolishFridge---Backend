package com.FoolishFridge.FoolishFridge.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.FoolishFridge.FoolishFridge.responses.PaymentResponse;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class PaymentServiceImp implements PaymentService {

        @Value("${stripe.secret.api.key}")
        private String stripeSecretApiKey;

        @Override
        public PaymentResponse createPaymentLink() throws StripeException {

                Stripe.apiKey = stripeSecretApiKey;

                SessionCreateParams params = SessionCreateParams.builder()
                                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                                .setMode(SessionCreateParams.Mode.PAYMENT)
                                .setSuccessUrl("http://localhost:8080/payment/sucsess")
                                .setCancelUrl("http://localhost:8080/payment/fail")
                                .addLineItem(SessionCreateParams.LineItem.builder()
                                                .setQuantity(1L)
                                                .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                                                .setCurrency("sek")
                                                                .setUnitAmount((long) 100 * 10)
                                                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData
                                                                                .builder()
                                                                                .setName("Foolish Fridge")
                                                                                .build())
                                                                .build())
                                                .build())
                                .build();

                Session session = Session.create(params);

                PaymentResponse response = new PaymentResponse(session.getUrl());

                return response;
        }

}
