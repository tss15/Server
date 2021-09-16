package commands;

import java.io.IOException;
import java.net.Socket;

public class RemoveKeyNull extends Command {
    private static final long serialVersionUID = 32L;

    @Override
    public void execute(Object argObject, Socket socket) throws IOException {

        String arg = argObject.toString();
        if (arg.split(" ").length == 1) {
            CommandReceiver commandReceiver = new CommandReceiver(socket);
            commandReceiver.RemoveKeyNull(arg);
        } else {
            System.out.println("Check the amount of arguments");
        }
    }

}
