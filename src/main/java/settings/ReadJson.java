package settings;

import data.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadJson{
    JSONParser jsonP = new JSONParser();

    public ReadJson() {
    }

    public void jsonRead(HashMap<Integer,LabWork> labWorkHashMap){
        try{
            File file = new File(System.getenv("IN_PATH"));
            FileReader fileReader = new FileReader(file );
            Object obj = jsonP.parse(fileReader);
            JSONArray lblist= (JSONArray) obj;
            lblist.forEach(lb -> parsA((JSONObject)lb,labWorkHashMap));
            fileReader.close();
        } catch (ParseException | IOException e) { System.out.println("Parser exception");
        }
    }

    private void parsA(JSONObject lbw, HashMap<Integer,LabWork> labWorkHashMap){


            JSONObject lbwObj = (JSONObject) lbw.get("LabWorks");
            String keyy =  (String) lbwObj.get("key");
//            lbw.forEach(());
//            lbwObj.
            String name = (String) lbwObj.get("name");
            String xx = (String) lbwObj.get("x");
            String yy = (String) lbwObj.get("y");
            String minimalPointt = (String) lbwObj.get("minpoint");
            String diff = (String) lbwObj.get("difficulty");
            String pname = (String) lbwObj.get("pname");
            String weightt = (String) lbwObj.get("weight");
            String eyecolo = (String) lbwObj.get("eyecolor");
            String haircolo = (String) lbwObj.get("haircolor");
            String nationalit = (String) lbwObj.get("nationality");
            String lxx = (String) lbwObj.get("lx");
            String lyy = (String) lbwObj.get("ly");
            String lname = (String) lbwObj.get("lname");

            Integer key =  Integer.parseInt(keyy);
            Long x = Long.valueOf(xx);
            Long lx = Long.valueOf(lxx);
            Double ly = Double.valueOf(lyy);
            Double y = Double.valueOf(yy);
            Double weight = Double.valueOf(weightt);
            Double minimalPoint = Double.valueOf(minimalPointt);



            Difficulty difficulty = Difficulty.valueOf(diff.toUpperCase());
            Color eyecolor = Color.valueOf(eyecolo.toUpperCase());
            hairColor haircolor = hairColor.valueOf(haircolo.toUpperCase());
            Country nationality = Country.valueOf(nationalit.toUpperCase());

            Coordinates coordinates = new Coordinates(x,y);
            Location location = new Location(lx,ly,lname);
            Person person = new Person(pname,weight,eyecolor,haircolor,nationality,location);
            LabWork labWork = new LabWork(name,coordinates,minimalPoint,difficulty,person);

            labWorkHashMap.put(key, labWork);




    }

    
}
