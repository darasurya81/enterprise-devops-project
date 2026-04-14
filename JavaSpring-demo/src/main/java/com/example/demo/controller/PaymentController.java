package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/status")
    public String status() {
        return "Payment Service is UP";
    }

    @PostMapping("/process")
    public Map<String, Object> process(@RequestParam String orderId,
                                       @RequestParam Double amount) {
        Map<String, Object> response = new HashMap<>();
        response.put("orderId", orderId);
        response.put("amount", amount);
        response.put("status", "SUCCESS");
        return response;
    }
}