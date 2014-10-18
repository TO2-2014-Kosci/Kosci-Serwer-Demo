package com.kosci.serwer.demo;

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
                    client.sendHello();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
