package com.mng.rabbit.mq.Rabbit_Demo;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConsumerRun {

	public static void main( String[] args ) throws IOException
    {
    	Channel channel = null;
    	Connection connection;
    	
    	//Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();
	    
        //hostname of your rabbitmq server
        factory.setHost("localhost");
		
        //getting a connection
        connection = factory.newConnection();
	    
        //creating a channel
        channel = connection.createChannel();
	    
        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.basicConsume("new-queue", false, new ConsumerListener(channel));
        System.out.println("----- Read to Recevive Message from Queue -----");
    }
}