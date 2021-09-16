package data;

public enum Difficulty {
    VERY_EASY,
    NORMAL,
    HARD,
    HOPELESS,
    TERRIBLE;

    public static String nameList() {
        String nameList = "";
        for (Difficulty difficulty : values()) {
            nameList += difficulty.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
