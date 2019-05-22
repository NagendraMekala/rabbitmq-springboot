package com.mng.spring.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mng.spring.model.Employee;

@Component
public class RabbitMqPublisher {
	
	@Autowired
	public AmqpTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, routingKey, employee);
		System.out.println("Send msg = " + employee);
	}
}
