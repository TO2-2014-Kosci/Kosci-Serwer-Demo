package to2.kosci.serwer.demo;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import to2.kosci.protocols.ClientRequest;

import java.io.IOException;
import java.util.LinkedList;

public class Server {
    private static final String QUEUE_NAME = "dice_demo_queue";
    private Connection connection;
    private Channel channel;

    private LinkedList<IController> controllers = new LinkedList<>();

    public Server() throws  IOException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueDeclare("kosci_public_response", false, false, false, null);
    }

    public void run() throws IOException, InterruptedException {
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            ClientRequest.LoginRequest request = ClientRequest.LoginRequest.parseFrom(delivery.getBody());
            String login = request.getLogin();
            System.out.format(" [*] Received login request from %s%n", login);

            for (IController controller : controllers) {
                channel.basicPublish("", "kosci_public_response", null, controller.respondTo(login).toByteArray());
            }
        }
    }

    public void addController(IController controller) {
        controllers.add(controller);
    }
}
