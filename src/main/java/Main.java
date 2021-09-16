import data.LabWorkCollection;
import tools.Connection;

import java.io.IOException;
import settings.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new LabWorkCollection().doInitialization();
        ReadJson rr = new ReadJson();
        rr.jsonRead(new LabWorkCollection().getLabWorks());
//        Runtime.getRuntime().addShutdownHook(new Thread(jsonPars::SaveCollectionToJson));
        Connection connections = new Connection();
        connections.run(args[0]);
    }
}