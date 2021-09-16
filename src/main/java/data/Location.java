package data;

import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = 32L;

    private Long x;
    private double y;
    private String name;

    public Location(long x, double y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Long getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "X: "+ x + " Y:" + y + "Name: " + name;
    }

    @Override
    public int hashCode() {
        return (int) y + x.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Location) {
            Location locationObj = (Location) obj;
            return x.equals(locationObj.getX()) && (y == locationObj.getY()) && name.equals(locationObj.getName());
        }
        return false;
    }
}
