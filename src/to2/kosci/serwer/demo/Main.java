package to2.kosci.serwer.demo;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try {
            switch (args[0]) {
                case "s":
                    Server server = new Server();
                    server.addController(new StandardController());
                    server.run();
                    break;
                case "c":
                    Client client = new Client("localhost", "dice_demo_queue");
                    client.login("Ean" + (new Random()).nextInt(32));
                    client.closeConnection();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}///lalala//
