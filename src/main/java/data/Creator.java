package data;

import commands.excpetionsCommand.NullException;
import commands.excpetionsCommand.ValueTooBigException;
import commands.excpetionsCommand.ValueTooSmallException;
import data.dataException.NoSuchCountry;
import data.dataException.NoSuchDifficulty;
import data.dataException.NoSuchEyeColor;
import data.dataException.NoSuchHairColor;
import tools.StringTool;

import java.time.LocalDateTime;

public class Creator {

    private static Integer id;
    private static String name;
    private static Long x;
    private static double y;
    private static Coordinates coordinates;
    private static Location location;
    private static LocalDateTime creationDate;
    private static Double minimalPoint;
    private static Difficulty difficulty;
    private static Person author;
   private static String pname;
   private static Double pweight;
   private static Color eyeColor;
   private static data.hairColor hairColor;
   private static Country nationality;
   private static Long lx;
   private static double ly;
   private static String lname;

    public static Integer setID() {
        id = 0;
        id++;
        return id;
    }
    public static LabWork LabWorkCreate() throws NullException, ValueTooSmallException, ValueTooBigException {

//        System.out.print("Please enter name");
//        Long x;
//        double y;
//        String namee;
//        double minimalPoint;
//        Difficulty difficulty;

        System.out.println("Please enter name");
        while (true) {
            try {
                name = StringTool.Input();
                if (name == null) {
                    throw new NullException("Print Something");
                }
                break;
            } catch (NullException ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter x-coordinate");
        while (true) {
            try {
                String sx = StringTool.Input();
                x = Long.parseLong(sx);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter y-coordinate");
        while (true) {
            try {
                String sy = StringTool.Input();
                y = Double.parseDouble(sy);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter minimal point");
        while (true) {
            try {
                String mP = StringTool.Input();
                minimalPoint = Double.valueOf(mP);
                if (minimalPoint < 0) {
                    throw new ValueTooSmallException(" should be bigger than 0\n");
                }
                break;
            } catch (ValueTooSmallException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter something");
            }
        }

        System.out.println("Please enter difficulty level");
        while (true) {
            try {
                String df = StringTool.Input();
                df = df.toUpperCase();
                if (!Difficulty.nameList().contains(df)){
                    throw new NoSuchDifficulty("no such difficulty\n");
                }
                difficulty = Difficulty.valueOf(df);
                break;
            }catch (NoSuchDifficulty ex) {
                System.out.print(ex.getMessage());
            }

        }

        System.out.println("Please enter person's name");
        while (true) {
            try {
                pname = StringTool.Input();
                if (pname == null){
                    throw new NullException("Print Something");
                }break;
            }catch (NullException ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter person's weight");
        while (true) {
            try {
                String pw = StringTool.Input();
                pweight = Double.parseDouble(pw);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter eye color");
        while (true) {
            try {
                String ec = StringTool.Input();
                ec = ec.toUpperCase();
                if (!Color.nameList().contains(ec)){
                    throw new NoSuchEyeColor("no such eye color\n");
                }
                eyeColor = Color.valueOf(ec);
                break;
            }catch (NoSuchEyeColor ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter hair color");
        while (true) {
            try{
                String hc = StringTool.Input();
                hc = hc.toUpperCase();
                if (!data.hairColor.nameList().contains(hc)){
                    throw new NoSuchHairColor("no such hair color\n");
                }
                hairColor = data.hairColor.valueOf(hc);
                break;
            }catch (NoSuchHairColor ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter country");
        while (true) {
            try{
                String c = StringTool.Input();
                c = c.toUpperCase();
                if (!Country.nameList().contains(c)){
                    throw new NoSuchCountry("no such country\n");
                }
                nationality = Country.valueOf(c);
                break;
            }catch (NoSuchCountry ex) {
                System.out.print(ex.getMessage());
            }
        }

        System.out.println("Please enter location x-coordinate");
        while (true) {
            try {
                String locx = StringTool.Input();
                lx = Long.parseLong(locx);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter location y-coordinate");
        while (true) {
            try {
                String locy = StringTool.Input();
                ly = Double.parseDouble(locy);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Field cannot be null");
            }
        }

        System.out.println("Please enter location name");
        while (true) {
            try {
                lname = StringTool.Input();
                if (lname.length()>838) {
                    throw new ValueTooBigException("too long");}
                if (lname == null) { throw new NullException("Print Something");}
                break;
            }catch (ValueTooBigException ex) {System.out.println(ex.getMessage());}
            catch (NullException ex) {System.out.print(ex.getMessage());}
        }
        setID();
        coordinates = new Coordinates(x,y);
        location =new Location(lx,ly,lname);
        author = new Person(pname, pweight,eyeColor, hairColor, nationality, location);




        return new LabWork( name,  coordinates, minimalPoint, difficulty,author);
    }
}