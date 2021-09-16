package commands;

import data.LabWork;

public class Check {

    public static boolean LabWorkCheck(LabWork labWork) {
        return labWork.getName() != null && labWork.getId() != null && labWork.getCoordinates().getX() > -538 &&
                labWork.getCreationDate() != null && labWork.getMinimalPoint() > 0 &&
                labWork.getDifficulty() != null && labWork.getAuthor() != null;
    }
}
