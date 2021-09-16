package data;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 32L;

    private String name;
    private Double weight;
    private Color eyeColor;
    private data.hairColor hairColor;
    private Country nationality;
    private Location location;

    public Person(String name, double weight, Color eyeColor, hairColor hairColor, Country nationality, Location location) {
        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public Person(String pname, Double weight, String eyeColor, String hairColor, Location location) {
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public hairColor getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name +" "+ weight+ " " + eyeColor+ " " + hairColor +" "+nationality +" "+ location ;
    }

    //@Override
//    public int hashcode() {
//        return  name.hashCode() + getWeight().intValue() + eyeColor.hashCode() + hairColor.hashCode() + nationality.hashCode() + location.hashCode();
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person personObj = (Person) obj;
            return name.equals(personObj.getName()) && weight.equals(personObj.getWeight()) && (eyeColor == personObj.getEyeColor()) && (hairColor == personObj.getHairColor()) && (nationality == personObj.getNationality()) && (location == personObj.getLocation());
        }
        return false;
    }
}
