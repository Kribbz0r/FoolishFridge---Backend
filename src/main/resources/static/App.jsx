import React, { useState, useEffect } from "react";
import { loadStripe } from "@stripe/stripe-js";
import { Elements } from "@stripe/react-stripe-js";
import {
    BrowserRouter as Router,
    Routes,
    Route
} from 'react-router-dom';

import CheckoutForm from "./CheckoutForm";
import CompletePage from "./CompletePage";
import "./App.css";

// Make sure to call loadStripe outside of a component’s render to avoid
// recreating the Stripe object on every render.
// This is your test publishable API key.
const stripePromise = loadStripe("pk_test_51QAxeNG3bfPfRWf7QZbwMtEglxZbImgSFmcSWueFFdcaC0uNeZSG2tYtGWnVRX4i7QXosc6KRVt48jhuqORFfdId00JvAnJjeT");

export default function App() {
    const [clientSecret, setClientSecret] = useState("");
    const [dpmCheckerLink, setDpmCheckerLink] = useState("");

    useEffect(() => {
        // Create PaymentIntent as soon as the page loads
        fetch("/", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: 100,
        })
            .then((res) => res.json())
            .then((data) => {
                setClientSecret(data.clientSecret);
                // [DEV] For demo purposes only
                setDpmCheckerLink(data.dpmCheckerLink);
                console.log(dpmCheckerLink);

            });
    }, []);

    const appearance = {
        theme: 'stripe',
    };
    // Enable the skeleton loader UI for optimal loading.
    const loader = 'auto';

    return (
        <>
            <h1>Tjo</h1>
            <Router>
                <div className="App">
                    {clientSecret && (
                        <Elements options={{ clientSecret, appearance, loader }} stripe={stripePromise}>
                            <Routes>
                                <Route path="/checkout" element={<CheckoutForm dpmCheckerLink={dpmCheckerLink} />} />
                                <Route path="/complete" element={<CompletePage />} />
                            </Routes>
                        </Elements>
                    )}
                </div>
            </Router>
        </>
    );
}