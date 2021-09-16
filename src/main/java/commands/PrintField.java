package commands;

import java.io.IOException;
import java.net.Socket;

public class PrintField extends Command {
    private static final long serialVersionUID = 32L;
    @Override
    public void execute(Object argObject, Socket socket) throws IOException {
        CommandReceiver commandReciever = new CommandReceiver(socket);
        commandReciever.printField();

    }
}
