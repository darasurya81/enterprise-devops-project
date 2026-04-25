package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private int amount;

    public Payment() {}

    public Payment(String orderId, int amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public String getOrderId() { return orderId; }
    public int getAmount() { return amount; }

    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setAmount(int amount) { this.amount = amount; }
}