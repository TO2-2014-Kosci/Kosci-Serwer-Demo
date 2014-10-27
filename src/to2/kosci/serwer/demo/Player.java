package to2.kosci.serwer.demo;
import to2.kosci.protocols.ServerProtocols;

/**
 * Created by Janusz on 2014-10-27.
 */
public class Player {
    public String login;
    public String state;
    public Room room;
    private IGUIController controller;

    void sendMessage (ServerProtocols.Response Message) {}
    //Response sitDown();
    //Response standUp();
}