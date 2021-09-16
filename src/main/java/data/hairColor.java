package data;

public enum hairColor {
    BLACK,
    YELLOW,
    BROWN;

    public static String nameList() {
        String nameList = "";
        for (hairColor hairColor : values()) {
            nameList += hairColor.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
