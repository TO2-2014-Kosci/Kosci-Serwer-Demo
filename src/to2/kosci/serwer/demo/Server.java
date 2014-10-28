package to2.kosci.serwer.demo;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import to2.kosci.protocols.ServerProtocols;

import java.io.IOException;
import java.util.LinkedList;
/**
 * Created by Janusz on 2014-10-27.
 */
public class Server {
    private LinkedList<Player> players = new LinkedList<>();
    private LinkedList<Room> rooms = new LinkedList<>();

    public ServerProtocols.Response handleRequest(ServerProtocols.Request request) {
        Player fanfilmu = new Player(request.getLogin(), null , null, null);
        players.add(fanfilmu);

        Room room_test = new Room();
        rooms.add(room_test);

        room_test.addPlayer(fanfilmu);

        for (Player p : players){
            if (room_test.hasUser(p)) {
                System.out.println("Players in room_test: ");
            }
        }
        throw new NotImplementedException(); //hyhy hyhy hyhy
    }

    public void addController(IGUIController controller) {
        throw new NotImplementedException();
    }
}