package to2.kosci.serwer.demo;

import to2.kosci.protocols.ServerResponse;

public interface IController {
    public ServerResponse.Response respondTo(String message);
}
