package to2.kosci.serwer.demo;

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

    public void sendHello() throws IOException {
        JsonObject value = Json.createObjectBuilder()
                .add("name", "some name")
                .add("message", "Hello stranger!").build();

        channel.basicPublish("", queueName, null, toJson(value).getBytes());
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
