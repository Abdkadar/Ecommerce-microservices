package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Order;
import com.example.demo.service.DroolsService;

@RestController
@RequestMapping("/order")
public class DroolsSampleController {

	@Autowired
	private DroolsService bankService;

	@PostMapping("/getdiscount")
	public ResponseEntity<Order> getDiscount(@RequestBody Order request) {
		return new ResponseEntity<>(bankService.getOrder(request), org.springframework.http.HttpStatus.OK);
	}

}
