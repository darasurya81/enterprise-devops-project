package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/status")
    public String status() {
        return "Order Service is UP";
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestParam String item,
                                      @RequestParam Integer qty) {
        Map<String, Object> response = new HashMap<>();
        response.put("item", item);
        response.put("qty", qty);
        response.put("orderStatus", "CREATED");
        return response;
    }
}