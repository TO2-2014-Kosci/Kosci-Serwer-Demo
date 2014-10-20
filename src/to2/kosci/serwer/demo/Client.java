package to2.kosci.serwer.demo;

import com.rabbitmq.client.QueueingConsumer;
import to2.kosci.protocols.*;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import javax.json.JsonObject;
import javax.json.Json;
import javax.json.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;


public class Client {
    private String host;
    private String queueName;
    private Connection connection;
    private Channel channel;

    public Client(String host, String queueName) throws IOException {
        this.host = host;
        this.queueName = queueName;
        setup();
    }

    public void login(String login) throws IOException, InterruptedException {
        ClientRequest.LoginRequest request = ClientRequest.LoginRequest.newBuilder()
                .setLogin(login)
                .build();

        channel.basicPublish("", queueName, null, request.toByteArray());

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume("kosci_public_response", true, consumer);
        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
        ServerResponse.Response response = ServerResponse.Response.parseFrom(delivery.getBody());

        System.out.format("Server response: %s%n", response.getStatus());
        if (response.getStatus() == ServerResponse.Response.Status.FAILURE)
            System.out.format("Reason: %s%n", response.getReason());
    }

    public void closeConnection() throws  IOException {
        channel.close();
        connection.close();
    }

    private void setup() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
    }

    private String toJson(JsonObject object) {
        StringWriter json = new StringWriter();
        JsonWriter jw = Json.createWriter(json);
        jw.writeObject(object);
        jw.close();
        return json.toString();
    }
}
