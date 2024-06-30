package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CustomerClient;


@Component
@FeignClient(name = "customer-service",url = "http://localhost:8081/api/customer")
public interface CustomerServiceClient {
	
	@GetMapping("/customers/{id}")
    CustomerClient getCustomerById(@PathVariable("id") Long CustomerId);

}
