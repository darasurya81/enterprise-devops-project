package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void paymentStatusShouldReturnUp() throws Exception {
        mockMvc.perform(get("/payment/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("Payment Service is UP"));
    }
	
	@Test
    void paymentProcessShouldReturnSuccessMessage() throws Exception {
        mockMvc.perform(post("/payment/process")
                        .param("orderId", "ORD101")
                        .param("amount", "500"))
                .andExpect(status().isOk())
                .andExpect(content().string("Payment processed for Order: ORD101 Amount: 500"));
    }
}