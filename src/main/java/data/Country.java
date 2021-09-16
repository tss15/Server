package data;

public enum Country {
    UNITED_KINGDOM,
    GERMANY,
    SPAIN,
    INDIA,
    THAILAND;

    public static String nameList() {
        String nameList = "";
        for (Country nationality : values()) {
            nameList += nationality.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
