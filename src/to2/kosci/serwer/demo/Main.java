package to2.kosci.server_demo2;
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
                    Server server = new Server();
                    server.addController(new IGUIController() {
                    });
                    server.run();
                    break;
                case "p":
                    Player player = new Player();
                    player.login = ("Ean" + (new Random()).nextInt(32));
                    player.state = "My state is...";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}