package com.example.demo.bean;

import lombok.Data;

@Data
public class Order {
    private String customerType;
    private double totalAmount;
    private double discount;
}
