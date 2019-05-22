package com.mng.spring.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.mng.spring.model.Employee;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;

@Component
public class RabbitMqSubcriber {
	
	 private static final Logger log = LoggerFactory.getLogger(RabbitMqSubcriber.class);
	 
	 @RabbitListener(queues="${rabbitmq.queue}")
	 public void receiveObject(Employee employee, Envelope env, Channel channel) {
			try {
				log.info("Received Message: " + employee);
	    		log.info("Making REST call to the API");
	    		
	    		RestTemplate restTemplate = new RestTemplate();
	    		restTemplate.postForObject("http://localhost:8585/msg", employee, Employee.class);
	    		//restTemplate.postForObject("http://localhost:8585/msg",Employee.class, employee);
	    		
	    		//TODO: Code to make REST call
	        	log.info("<< Exiting receiveMessageCrawlCI() after API call.");
	    	} catch(HttpClientErrorException  ex) {
	    		if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
	        		log.info("Delay...");
	        		try {
	    				Thread.sleep(5000);
	    			} catch (InterruptedException e) { }
	    			
	    			log.info("Throwing exception so that message will be requed in the queue.");
	    			// Note: Typically Application specific exception can be thrown below
	    			throw new RuntimeException();
	    		} else {
	    			throw new AmqpRejectAndDontRequeueException(ex); 
	    		}
	    		
	    	} catch(Exception e) {
	    		log.error("Internal server error occurred in python server. Bypassing message requeue {}", e);
	    		throw new AmqpRejectAndDontRequeueException(e); 
	    	}

	    }
}
