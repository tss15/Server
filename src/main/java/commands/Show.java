package commands;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class Show extends Command implements Serializable {
    private static final long serialVersionUID = 32L;
    @Override
    public void execute(Object argObject, Socket socket) throws IOException {
        CommandReceiver commandReciever = new CommandReceiver(socket);
        commandReciever.show();
    }
}
