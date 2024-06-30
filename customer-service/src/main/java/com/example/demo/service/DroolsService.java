package com.example.demo.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Order;

@Service
public class DroolsService {

	@Autowired
	private KieContainer kieContainer;

	public Order getOrder(Order applicantRequest) {
		Order order1 = new Order();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("order", order1);
		kieSession.insert(applicantRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		return order1;
	}

}
