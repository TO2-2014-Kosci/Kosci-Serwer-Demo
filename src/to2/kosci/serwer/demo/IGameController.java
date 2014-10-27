package to2.kosci.serwer.demo;

import to2.kosci.protocols.*;
/**
 * Created by Janusz on 2014-10-27.
 */

import java.util.HashMap;
import java.util.List;

public interface IGameController {
    void startGame (List<String> players, HashMap options);
    void handleGameRequest (Request request);
}