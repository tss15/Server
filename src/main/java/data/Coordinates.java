package data;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 32L;

    private Long x;
    private double y;

    public Coordinates(Long x, double y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X: "+ x + " Y:" + y;
    }

    @Override
    public int hashCode() {
        return (int) y + x.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinatesObj = (Coordinates) obj;
            return x.equals(coordinatesObj.getX()) && (y == coordinatesObj.getY());
        }
        return false;
    }
}
