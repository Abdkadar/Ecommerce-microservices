package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService CustomerService;

    // build create Customer REST API
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer Customer){
        Customer savedCustomer = CustomerService.createCustomer(Customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    // build get Customer by id REST API
    // http://localhost:8080/api/Customers/1
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long CustomerId){
        Customer Customer = CustomerService.getCustomerById(CustomerId);
        return new ResponseEntity<>(Customer, HttpStatus.OK);
    }

    // Build Get All Customers REST API
    // http://localhost:8080/api/Customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> Customers = CustomerService.getAllCustomers();
        return new ResponseEntity<>(Customers, HttpStatus.OK);
    }

    // Build Update Customer REST API
    @PutMapping("/customers/{id}")
    // http://localhost:8080/api/Customers/1
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long CustomerId,
                                           @RequestBody Customer Customer){
        Customer.setCustId(CustomerId);
        Customer updatedCustomer = CustomerService.updateCustomer(Customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    // Build Delete Customer REST API
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long CustomerId){
        CustomerService.deleteCustomer(CustomerId);
        return new ResponseEntity<>("Customer successfully deleted!", HttpStatus.OK);
    }
    

}
