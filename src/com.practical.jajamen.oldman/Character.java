package com.practical.jajamen.oldman;
import java.util.Map;
import java.util.Objects;

public class Character {
    private String name;
    private int health;
    private Map<String, Integer> power;
    private int steroid;

    Character() {
    }

    public Character(String name, int health, Map<String, Integer> power, int steroid) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.steroid = steroid;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Map<String, Integer> getPower() {
        return power;
    }

    public void setPower(Map<String, Integer> power) {
        this.power = power;
    }

    public String getPowerName() {
        return String.join("", power.keySet());
    }

    public int getPowerLimit() {
        return power.get(getPowerName());
    }
    public int getSteroid() {
        return steroid;
    }

    public void setSteroid(int steroid) {
        this.steroid = steroid;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", power=" + power +
                ", steroid=" + steroid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return getName().equals(character.getName()) &&
                getPower().equals(character.getPower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower());
    }
}