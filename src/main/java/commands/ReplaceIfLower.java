package commands;

import data.LabWork;
import tools.SerializedCombinedCommand;

import java.io.IOException;
import java.net.Socket;

public class ReplaceIfLower extends Command {
    private static final long serialVersionUID = 32L;

    @Override
    public void execute(Object argObject, Socket socket) throws IOException {
        SerializedCombinedCommand combinedCommand = (SerializedCombinedCommand) argObject;
        Integer arg = combinedCommand.getArg();
        LabWork labWork = (LabWork) combinedCommand.getObject();

        CommandReceiver commandReciever = new CommandReceiver(socket);
        commandReciever.replaceIfLower(String.valueOf(arg), labWork);

    }
}
