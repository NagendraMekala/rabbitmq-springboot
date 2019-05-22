package com.mng.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mng.spring.model.Employee;
import com.mng.spring.rabbitmq.RabbitMqPublisher;

@RestController
public class RabbitMqEmployeeController {
	
	@Autowired
	public RabbitMqPublisher rabbitMqPublisher;
	
	@RequestMapping("/hello")
	public String hello() {
		return "welcome rabbit mq programing";
	}
	
	@RequestMapping("/emp")
	public Employee getEmployee() {
		Employee obj = new Employee();
		obj.setEmpId("1235");
		obj.setEmpName("Nagendar");
		return obj;
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public void save(@RequestBody Employee employee) {
		rabbitMqPublisher.send(employee);
		System.out.println("employee object processed");
	}
}
