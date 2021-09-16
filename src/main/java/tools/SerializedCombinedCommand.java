package tools;


import commands.Command;

import java.io.Serializable;

public class SerializedCombinedCommand implements Serializable {

    private Command command;
    private Object object;
    private Integer arg;

    public SerializedCombinedCommand(Command command, Object object, int arg) {
        this.command = command;
        this.object = object;
        this.arg = arg;
    }

    public Command getCommand() {
        return command;
    }

    public Object getObject() {
        return object;
    }

    public Integer getArg() {
        return arg;
    }
}