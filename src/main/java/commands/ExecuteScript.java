package commands;

import data.LabWork;
import tools.SerializedCombinedCommand;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class ExecuteScript extends Command  {
    private static final long serialVersionUID = 32L;

    @Override
    public void execute(Object argObject, Socket socket) throws IOException {
        String arg = argObject.toString();
        if (arg.split(" ").length == 1) {
            CommandReceiver commandReceiver = new CommandReceiver(socket);
            commandReceiver.executeScript(arg);

        } else {
            System.out.println("Check the amount of arguments");
        }

    }
}
