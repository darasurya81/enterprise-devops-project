package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void orderStatusShouldReturnUp() throws Exception {
        mockMvc.perform(get("/order/status"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order Service is UP"));
    }
	
	@Test
    void createOrderShouldReturnSuccessMessage() throws Exception {
        mockMvc.perform(post("/order/create")
                        .param("item", "Mobile")
                        .param("qty", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order created for item: Mobile Qty: 2"));
    }
}