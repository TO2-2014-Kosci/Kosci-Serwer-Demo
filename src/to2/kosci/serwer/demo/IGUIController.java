package to2.kosci.serwer.demo;
import to2.kosci.protocols.ServerProtocols;

/**
 * Created by Janusz on 2014-10-27.
 */
public interface IGUIController {
    public void sendResponse (String player, ServerProtocols.Response response);
}