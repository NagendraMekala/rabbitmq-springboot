package com.mng.rabbit.mq.Rabbit_Demo;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class ProducerRun 
{
    public static void main( String[] args ) throws IOException
    {
    	Channel channel = null;
    	Connection connection;
    	
    	//Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();
	    
        //hostname of your rabbitmq server
        factory.setHost("127.0.0.1");
        //factory.setPort(1567);
		
        //getting a connection
        connection = factory.newConnection();
	    
        //creating a channel
        channel = connection.createChannel();
       
		for (int i = 0; i < 2000000; i++) {
			String str = "sent message count: "+ i;
			//channel.basicPublish("demo-queue-exchange", "demo-queue", null, str.getBytes());
			channel.basicPublish("new-exchange", "n1", null, str.getBytes());
 			System.out.println("Message Number "+ i +" sent.");
		}
        System.out.println("sending complete");
    }
}
