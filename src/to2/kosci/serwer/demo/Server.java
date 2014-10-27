package to2.kosci.serwer.demo;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;
import java.util.LinkedList;
/**
 * Created by Janusz on 2014-10-27.
 */
public class Server {
    private LinkedList<Player> players = new LinkedList<>();
    private LinkedList<Room> rooms = new LinkedList<>();

    Response handleRequest(Request Request);
}
