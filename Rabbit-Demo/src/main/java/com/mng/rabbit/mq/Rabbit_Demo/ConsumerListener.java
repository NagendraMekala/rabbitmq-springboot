package com.mng.rabbit.mq.Rabbit_Demo;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class ConsumerListener implements Consumer {
	
	Channel channel = null;
	
	public ConsumerListener(Channel channel) {
		this.channel=channel;
	}

	public void handleConsumeOk(String consumerTag) {
		System.out.println("handleConsumeOk()");
		System.out.println(consumerTag);
		
	}

	public void handleCancelOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

	public void handleCancel(String consumerTag) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void handleDelivery(String consumerTag, Envelope envelop, BasicProperties properties, byte[] body) throws IOException {
		System.out.println("Recevied from Exchange : " + envelop.getExchange() + " with Routing queue: "+ 
	                        envelop.getRoutingKey() + " Message: "+ new String(body));
		channel.basicAck(envelop.getDeliveryTag(), true);
		
	}

	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		// TODO Auto-generated method stub
		
	}

	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

}
