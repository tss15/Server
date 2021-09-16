package data;

import commands.CommandReceiver;
import commands.InsertNull;
import commands.UpdateID;
import commands.excpetionsCommand.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tools.SerializedCombinedCommand;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

public class LabWorkCollection {
    private static LocalDate InitializationTime;
    private static HashMap<Integer, LabWork> labWorks;
    public static boolean Initialization = false;
    private static LabWorkCollection labWorkCollection;

    public LabWorkCollection() {
    }

    public static LabWorkCollection getCollectionManager() {
        if (labWorkCollection == null) {
            labWorkCollection = new LabWorkCollection();
        }
        return labWorkCollection;
    }

    public static void addFromJson(LabWork labWork,Integer key) {
        labWork.setId(labWork.getId());
//        labWorkCollection.executeInsertNull(key,labWork);
    }



    public static HashMap<Integer, LabWork> getLabWorks() throws Initialization {
        if (!Initialization){
            throw new Initialization("collection wasn't initialized");
        }else{
            return labWorks;
        }
    }

    public static void doInitialization(){
        if (!Initialization){
            labWorks = new HashMap<>();
            InitializationTime = LocalDate.now();
            Initialization = true;
        }
    }

    public LocalDate getInitializationTime() {
        return InitializationTime;
    }

    public  static void executeUpdateID(String in,LabWork labWork2) throws FileNotFoundException {
        new LabWorkCollection().doInitialization();
        Integer id = Integer.valueOf(in);
        LabWork labWork;
        Iterator<LabWork> iterator = labWorks.values().iterator();
        while (iterator.hasNext()) {
            if ((labWork = iterator.next()).getId().equals(id)) {
//                LabWork insert = Creator.LabWorkCreate();
                labWork2.changeId(id);
                labWorks.replace(id,labWork2);


            }
        }
        executeSave();
    }

    public static void executeCountByDifficulty(String option){
        new LabWorkCollection().doInitialization();
        HashMap<Integer, LabWork> labWorkHashMap = new HashMap<Integer, LabWork>();
        LabWorkCollection collection = new LabWorkCollection();
        for(Map.Entry<Integer, LabWork> labWork : labWorks.entrySet()){
            if (labWork.getValue().getDifficulty().toString().equalsIgnoreCase(option)){
                labWorkHashMap.put(labWork.getKey(),labWork.getValue());
                System.out.println(labWorkHashMap.toString());
            }
        }
        if (labWorkHashMap.isEmpty()){
            System.out.println("No such difficulty found");
        }
    }



    public static void executePrintField() throws FileNotFoundException {
        PersonComparator compareAuthor = new PersonComparator();
        new LabWorkCollection().doInitialization();
        List<LabWork> labWorkSorted = new ArrayList<>(labWorks.values());
        labWorkSorted.sort(Collections.reverseOrder(compareAuthor));
        System.out.println(labWorkSorted);
        executeSave();
    }

    public static void executeSave() throws FileNotFoundException {
        HashMap<Integer,LabWork> hashMap = new LabWorkCollection().getLabWorks();
        File file = new File("info.json");
        PrintWriter writer = new PrintWriter(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(hashMap);
        writer.write(json);
        writer.close();
    }



    public static void executeRemoveDifficulty(String option) throws FileNotFoundException {
        new LabWorkCollection().doInitialization();
        HashMap<Integer, LabWork> labWorkHashMap = new HashMap<>();
        LabWorkCollection collection = new LabWorkCollection();
        for(Map.Entry<Integer, LabWork> labWork : labWorks.entrySet()){
            if (labWork.getValue().getDifficulty().toString().equalsIgnoreCase(option)){
                labWorkHashMap.remove(labWork.getKey(), labWork.getValue());
                System.out.println(labWorkHashMap.toString());
            }
        }
        if (labWorkHashMap.isEmpty()){
            System.out.println("There is no labwork with such difficulty");
        }
        executeSave();
    }

    public static void executeRemoveKeyNull(Integer key) throws FileNotFoundException {
        new LabWorkCollection().doInitialization();
        labWorks.remove(key);
        executeSave();
    }

    public static void executeRemoveLowerkey(Integer key) throws FileNotFoundException {
        new LabWorkCollection().doInitialization();
        labWorks.entrySet().removeIf(entry -> entry.getKey()< key);
        executeSave();
    }

    public static void executeReplaceIfGreater(String in,LabWork labWork) throws FileNotFoundException {
        new LabWorkCollection().doInitialization();
        Integer id = Integer.valueOf(in);
        Iterator<LabWork> iterator = labWorks.values().iterator();

        if (labWorks.entrySet().iterator().next().getValue().getMinimalPoint()<labWork.getMinimalPoint()){
            labWorks.replace(id,labWork);
            System.out.println("Successfully replaced");
        }else {
            System.out.println("wasn't added because the value was lower");
        }
        executeSave();
    }

    public static void executeReplaceIfLower(String in,LabWork labWork) throws FileNotFoundException {
        new LabWorkCollection().doInitialization();
        Integer id = Integer.valueOf(in);
        Iterator<LabWork> iterator = labWorks.values().iterator();
        if (labWorks.entrySet().iterator().next().getValue().getMinimalPoint()>labWork.getMinimalPoint()){
            labWorks.replace(id,labWork);
            System.out.println("Successfully replaced");
        }else {
            System.out.println("wasn't added because the value was greater");
        }
        executeSave();
    }


    public static void executeClear() throws IOException {
        File file = new File ("info.json");
        FileWriter fwOb = new FileWriter(file,false);
        PrintWriter pwOb = new PrintWriter(fwOb,false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        labWorks.clear();
        executeSave();

    }

    public static void executeInsertNull(Integer num, LabWork labWork) throws ValueTooBigException, ValueTooSmallException, NullException, FileNotFoundException {
        new LabWorkCollection().doInitialization();
        labWorks.put(num, labWork);
        executeSave();
    }

    public String executeShow(){
        new LabWorkCollection().doInitialization();

        if (labWorks.size()==0){
            throw new NullException("collection still empty\n");
        }
        return labWorks.values().toString();
    }







    public String executeInfo(){
        if (!LabWorkCollection.Initialization){
            throw new NotInitialization("collection wasn't initialized");
        }else {
            String info = "the date of initialization " + new LabWorkCollection().getInitializationTime()+
                    "\n the amount of elements "+ new LabWorkCollection().getLabWorks().size()+
                    "\n the type of collection is "+  new LabWorkCollection().getLabWorks().getClass() +"\n";
            return info;

        }
    }



}
