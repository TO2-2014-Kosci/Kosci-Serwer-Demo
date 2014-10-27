package to2.kosci.serwer.demo;


public class StandardController implements IController {
    @Override
    public ServerResponse.Response respondTo(String login) {
        ServerResponse.Response.Builder r = ServerResponse.Response.newBuilder();

        if (login.toCharArray()[0] == 'F')
            r.setStatus(ServerResponse.Response.Status.SUCCESS);
        else {
            r.setStatus(ServerResponse.Response.Status.FAILURE);
            r.setReason("Login doesn't start with F");
        }

        return r.build();
    }
}
