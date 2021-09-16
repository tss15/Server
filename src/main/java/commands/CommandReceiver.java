package commands;

import data.LabWork;
import data.LabWorkCollection;
import tools.SerializedArgumentCommand;
import tools.SerializedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CommandReceiver {
    private final Socket socket;
    private static final Logger logger = LoggerFactory.getLogger(CommandReceiver.class);
    private final LabWorkCollection collectionManager = LabWorkCollection.getCollectionManager();

    public CommandReceiver(Socket socket) {
        this.socket = socket;
    }




    public void info() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage(collectionManager.executeInfo()));
        logger.info(String.format("Client %s:%s received information",socket.getInetAddress(), socket.getPort()));
    }
    public void show() throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage(collectionManager.executeShow()));
        logger.info(String.format("Client  %s:%s received results of command 'show'", socket.getInetAddress(), socket.getPort()));
    }

    public void insertNull(String ID, Object o) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        LabWork labWork = (LabWork) o;
            LabWorkCollection.executeInsertNull(Integer.parseInt(ID),labWork);
            out.writeObject(new SerializedMessage("Added successfully"));

        logger.info(String.format("Client %s:%s received results of command 'insertNull'", socket.getInetAddress(), socket.getPort()));


    }


    public void clear() throws IOException {
        LabWorkCollection.executeClear();
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Collection successfully cleared"));
        logger.info(String.format("Client %s:%s received results of command 'clear'", socket.getInetAddress(),   socket.getPort()));
    }
//    public void help() throws IOException {
//        System.out.println("help:");
//        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//        out.writeObject(new SerializedMessage("Коллекция успешно очищена"));
//        logger.info(String.format("Клиенту %s отправлен результат очистки",  socket.getPort()));
//    }


    public void replaceIfLower(String id, Object o) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        LabWork labWork = (LabWork) o;
        LabWorkCollection.executeReplaceIfLower(id,labWork);
        out.writeObject(new SerializedMessage("Successfully replaced"));
        logger.info(String.format("Client %s:%s  received results of command replace_if_lower", socket.getInetAddress(),   socket.getPort()));
    }

    public void replaceIfGreater(String id, Object o) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        LabWork labWork = (LabWork) o;
        LabWorkCollection.executeReplaceIfGreater(id,labWork);
        out.writeObject(new SerializedMessage("Successfully replaced"));
        logger.info(String.format("Client %s:%s received results of command replace_if_greater",  socket.getInetAddress(),  socket.getPort()));
    }

    public void RemoveLowerKey(String key) throws IOException {
        LabWorkCollection.executeRemoveLowerkey(Integer.parseInt(key));
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Successfully removed"));
        logger.info(String.format("Client %s:%s received results of command remove_lower_key",  socket.getInetAddress(),  socket.getPort()));
    }

    public void RemoveKeyNull(String key) throws IOException {
        LabWorkCollection.executeRemoveKeyNull(Integer.parseInt(key));
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Successfully removed"));
        logger.info(String.format("Client %s:%s received results of command remove_key_null",  socket.getInetAddress(),  socket.getPort()));
    }

    public void RemoveDifficulty(String option) throws IOException {
        LabWorkCollection.executeRemoveDifficulty(option);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Successfully removed"));
        logger.info(String.format("Client %s:%s received results of command remove_difficulty",  socket.getInetAddress(),  socket.getPort()));
    }

    public void countByDif(String option) throws IOException {
//        LabWorkCollection.executeCountByDifficulty(option);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage(LabWorkCollection.executeCountByDifficulty(option)));
        logger.info(String.format("Client %s:%s received results of command count_by_difficulty",  socket.getInetAddress(),  socket.getPort()));
    }

    public  void executeScript(String path) throws IOException{

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Script executed: "));
        logger.info(String.format("Client %s:%s received results of command count_by_difficulty",  socket.getInetAddress(),  socket.getPort()));
    }

    public void printField() throws IOException {
//        LabWorkCollection.executePrintField();
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Collection sorted"+LabWorkCollection.executePrintField()));
        logger.info(String.format("Client %s:%s received results of command print_field",  socket.getInetAddress(),  socket.getPort()));
    }

    public void save() throws IOException {
        LabWorkCollection.executeSave();
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(new SerializedMessage("Collection successfully saved"));
        logger.info(String.format("Client %s:%s received results of command save",  socket.getInetAddress(),  socket.getPort()));
    }

    public void updateId(Integer option, Object o) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        LabWork labWork = (LabWork) o;
        LabWorkCollection.executeUpdateID(option,labWork);
        out.writeObject(new SerializedMessage("Element updated"));
        logger.info(String.format("Client %s:%s received results of command update_id",   socket.getInetAddress(), socket.getPort()));
    }




    public void exit() {
        System.out.println("That's all, folks!");
        System.exit(0);
    }





}
