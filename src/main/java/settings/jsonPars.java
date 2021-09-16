//package settings;
//
//import data.LabWork;
//import data.LabWorkCollection;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.TypeAdapter;
//import com.google.gson.reflect.TypeToken;
//import com.google.gson.stream.JsonReader;
//import com.google.gson.stream.JsonWriter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Reader;
//import java.time.ZonedDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//public class jsonPars {
//
//    private static final Logger logger = LoggerFactory.getLogger(jsonPars.class);
//    private static String filePath = System.getenv("IN_PATH");
//    private static LabWorkCollection collectionManager = LabWorkCollection.getCollectionManager();
//    private static GsonBuilder builder = new GsonBuilder();
//    private static Gson gson = builder
//            .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
//                @Override
//                public void write(JsonWriter out, ZonedDateTime value) throws IOException {
//                    out.value(value.toString());
//                }
//
//                @Override
//                public ZonedDateTime read(JsonReader in) throws IOException {
//                    return ZonedDateTime.parse(in.nextString());
//                }
//            })
//            .serializeNulls()
//            .setPrettyPrinting()
//            .enableComplexMapKeySerialization()
//            .create();
//
//    public static void SaveCollectionToJson() {
//        Gson gson = new Gson();
//        //"C:\\Users\\user\\Desktop\\data.txt"
//        try (FileWriter writer = new FileWriter(filePath)) {
//            gson.toJson(LabWorkCollection.getLabWorks(), writer);
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//    public static void JsonToCollection() {
//        //"C:\\Users\\user\\Desktop\\field.json"
//        if (filePath!=null) {
//            try (Reader reader = new FileReader(filePath)) {
//                LabWorkCollection.doInitialization();
//                HashMap<Integer,LabWork> spaceMarines = gson.fromJson(reader,new TypeToken<HashMap<Integer,LabWork>>(){}.getType());
//                if (spaceMarines.size()!=0) {
//                    for(Map.Entry<Integer, LabWork> labWork : spaceMarines.entrySet()){
//                        LabWorkCollection.addFromJson(labWork.getValue(),labWork.getKey());
//                    }
//                }
//
//
//                logger.info("Сохраненная коллекция выгруженна");
//
//            } catch (IOException e) {
//                logger.error(e.getMessage());
//            } catch (SecurityException e) {
//                logger.error("Недостаточно прав для открытия файла.");
//            } catch (NullPointerException e) {
//                logger.error("В файле нет объектов");
//            } catch (com.google.gson.JsonSyntaxException e) {
//                logger.error("Ошибка в содержании файла " + e.getMessage());
//            }
//
//        } else {
//            logger.error("Переменная окружения не выставлена");
//        }
//
//    }
//
//}
