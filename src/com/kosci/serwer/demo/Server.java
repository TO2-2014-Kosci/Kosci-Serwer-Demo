package com.kosci.serwer.demo;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.List;

/**
 * Created by Fan on 2014-10-18.
 */
public class Server {
    private static final String QUEUE_NAME = "dice_demo_queue";
    private Connection connection;
    private Channel channel;

    private List<IController> controllers;

    public Server() throws  IOException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }

    public void run() throws IOException, InterruptedException {
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            for (IController controller : controllers) {
                System.out.println(controller.respondTo(message));
            }
        }
    }

    public void addController(IController controller) {
        controllers.add(controller);
    }
}
