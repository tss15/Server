package commands;

import tools.SerializedArgumentCommand;
import tools.SerializedCombinedCommand;
import tools.SerializedObjectCommand;
import tools.SerializedSimplyCommand;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Answer {

    private final Socket socket;

    public Answer(Socket socket) {
        this.socket = socket;
    }

    public void toAnswer(Object o) throws IOException {
        if (o instanceof SerializedSimplyCommand) {
            SerializedSimplyCommand simplyCommand = (SerializedSimplyCommand) o;
            Command command = simplyCommand.getCommand();
            String arg = "";
            command.execute(arg, socket);
        }

        if (o instanceof SerializedArgumentCommand) {
            SerializedArgumentCommand argumentCommand = (SerializedArgumentCommand) o;
            Command command = argumentCommand.getCommand();
            String arg = argumentCommand.getArg();
            command.execute(arg, socket);
//            if(command.toString().equals("execute_script")){
//                String line;
//                String comm;
//                ArrayList<String> field = new ArrayList<>();
//                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(arg)), StandardCharsets.UTF_8))){
//                    while ((line = bufferedReader.readLine()) != null) {
////                if (line.split(" ")[0].matches("insert_null|update")) {
////                    command = line;
////
////                    for (int i = 0; i < 13; i++) {
////                        if (line != null) {
////                            line = bufferedReader.readLine();
////                            field.add(line);
////                        } else {
////                            System.out.println("Не хватает параметров для создания объекта.");
////                            break;
////                        }
////                    }
////                    LabWork lab = Creator.ScriptFromJsonToCollection(field);
////                    switch (command.split(" ")[0]) {
////
////                        case "insert_null":
////                            sender.toSend(new SerializedCombinedCommand(new InsertNull(), creator.LabWorkCreate(), Integer.parseInt(command.split(" ")[1])));
////                            Thread.sleep(delay);
////                            Receiver.receive(socketChannel);
////                            break;
////                        case "update":
////                            sender.toSend(new SerializedCombinedCommand(new UpdateID(), creator.LabWorkCreate(), Integer.parseInt(command.split(" ")[1])));
////                            Thread.sleep(delay);
////                            Receiver.receive(socketChannel);
////                            break;
////                    }
////                }  else {
//                        CommandReceiver commandReceiver = new CommandReceiver();
//                        command.execute(line.split(" "));
//                        //}
//                    }
//                } catch (IOException | ClassNotFoundException | InterruptedException e) {
//                    System.out.println("Ошибка! " + e.getMessage());
//                }
//            }
        }

        if (o instanceof SerializedObjectCommand) {
            SerializedObjectCommand objectCommand = (SerializedObjectCommand) o;
            Command command = objectCommand.getCommand();
            Object arg = objectCommand.getObject();
            command.execute(arg, socket);
        }

        if (o instanceof SerializedCombinedCommand) {
            SerializedCombinedCommand combinedCommand = (SerializedCombinedCommand) o;
            Command command = combinedCommand.getCommand();
            command.execute(combinedCommand, socket);
        }
    }
}
