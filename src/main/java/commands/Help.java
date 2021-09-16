package commands;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class Help extends Command implements Serializable {
    private CommandReceiver commandReciever;

    public Help (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Help() {}



    @Override
    public void execute(Object argObject, Socket socket) throws IOException {

    }
}
