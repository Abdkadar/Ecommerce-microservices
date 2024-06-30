package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Customer;

public interface CustomerService {

	Customer createCustomer(Customer user);

	Customer getCustomerById(Long userId);

	List<Customer> getAllCustomers();

	Customer updateCustomer(Customer user);

	void deleteCustomer(Long userId);

}
