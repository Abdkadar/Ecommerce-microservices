package com.example.demo.dto;

import lombok.Data;

@Data
public class CustomerClient {
    private Long custId;
    private String custName;
    private String custAddress;
    private String custEmail;
}
