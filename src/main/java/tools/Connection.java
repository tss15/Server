package tools;

import commands.Answer;
import data.LabWorkCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
//import settings.jsonPars;

public class Connection {

    private static Socket clientSocket; //socket for communication
    private static ServerSocket server; // server socket
    private static ObjectInputStream in; // Stream for reading from socket
    private static final Logger logger = LoggerFactory.getLogger(Connection.class);



    public void run(String strPort) throws IOException {
        try {
            try {
                int port = 0;
                LabWorkCollection collectionManager = LabWorkCollection.getCollectionManager();
                collectionManager.doInitialization();
                logger.info("Empty collection created");
//                jsonPars.JsonToCollection();
                try {
                    port = Integer.parseInt(strPort);
                } catch (NumberFormatException ex) {
                    logger.info("Error! Wrong port format");
                    System.exit(0);
                }

                server = new ServerSocket(port);
                logger.info("Server launched!");
                while (true) {
                    clientSocket = server.accept();
                    logger.info("I've been waiting for you to come': " + clientSocket);
                    try {
                        while (true) {
                            in = new ObjectInputStream(clientSocket.getInputStream());
                            Answer answer = new Answer(clientSocket);
                            Object o = in.readObject();
                            answer.toAnswer(o);
                        }

                    } catch (EOFException | SocketException ex) {
                        logger.info(clientSocket + " left without a goodbye");
                    } finally {
                        clientSocket.close();
                        if (in != null) { in.close(); }
                    }
                }
            } finally {
                if (clientSocket != null) { clientSocket.close(); }
                logger.info("Server closed!");
                server.close();
            }
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
            logger.error(String.valueOf(e));
        }
    }



}