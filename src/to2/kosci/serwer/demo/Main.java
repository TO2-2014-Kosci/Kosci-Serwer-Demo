package to2.kosci.serwer.demo;

import java.util.Random;
import to2.kosci.protocols.*;
/**
 * Created by Janusz on 2014-10-27.
 */
public class Main {
    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "s":
                    ServerProtocols.Request request_test =
                            ServerProtocols.Request.newBuilder()
                                    .setLogin("fanfilmu")
                                    .setType(ServerProtocols.Request.RequestType.LOGIN)
                                    .build();

                    Server server = new Server();
                    server.handleRequest(request_test);
                    server.addController(null);
                    //server.run();
                    break;
                case "p":
                    Player player = new Player(null, null, null, null);
                    player.login = ("Ean" + (new Random()).nextInt(32));
                    player.state = "My state is...";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}