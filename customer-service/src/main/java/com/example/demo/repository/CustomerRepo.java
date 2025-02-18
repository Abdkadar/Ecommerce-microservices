package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
