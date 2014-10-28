package to2.kosci.serwer.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import to2.kosci.protocols.ServerProtocols;

/**
 * Created by Janusz on 2014-10-27.
 */
public class Room implements IGameController {
    public Room room;
    private LinkedList<Player> players = new LinkedList<>();
    Map dictionary = new HashMap();

    @Override
    public void startGame (List<String> players, HashMap options){

    }
    @Override
    public void handleGameRequest (ServerProtocols.Request request){

    }

    void addPlayer (Player player){
        players.add(player);
    }

    void sendToPlayer (IGameController sender, String login){
        //sender.handleGameRequest();
    }

    void sendToAll (IGameController sender){
        for (Player p : players) sendToPlayer (sender, p.login);
    }

    void endGame (IGameController sender){
        for (Player p : players) sendToPlayer (sender, p.login);
    }

    boolean hasUser (Player player){
        for (Player p : players) if (p.login==player.login) return true;
        return false;
    }
}
