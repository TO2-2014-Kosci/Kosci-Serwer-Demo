package to2.kosci.serwer.demo;

/**
 * Created by Janusz on 2014-10-27.
 */
public class Player {
    public String login;
    public String state;
    public Room room;
    private IGUIController controller;

    void sendMessage (Message Message) {}
    Response sitDown();
    Response standUp();
}