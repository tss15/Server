package data;

import java.util.Comparator;

public class PersonComparator implements Comparator<LabWork> {
    @Override
    public int compare(LabWork o1, LabWork o2) {
        int diff= o1.getAuthor().getName().charAt(0)-o2.getAuthor().getName().charAt(0);
        if(diff>0){
            return 1;
        }else if (diff<0){
            return -1;
        }
        return 0;
    }
}
