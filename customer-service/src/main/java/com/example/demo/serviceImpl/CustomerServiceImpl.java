package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo tenantRepository;

    @Override
    public Customer createCustomer(Customer Customer) {
        return tenantRepository.save(Customer);
    }

    @Override
    public Customer getCustomerById(Long CustomerId) {
        Optional<Customer> optionalCustomer = tenantRepository.findById(CustomerId);
        return optionalCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return tenantRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer Customer) {
        Customer existingCustomer = tenantRepository.findById(Customer.getCustId()).get();
        existingCustomer.setCustName(Customer.getCustName());
        existingCustomer.setCustAddress(Customer.getCustAddress());
        existingCustomer.setCustEmail(Customer.getCustEmail());
        Customer updatedCustomer = tenantRepository.save(existingCustomer);
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(Long CustomerId) {
        tenantRepository.deleteById(CustomerId);
    }
}
