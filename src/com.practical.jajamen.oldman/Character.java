package com.practical.jajamen.oldman;
import java.util.Map;

public class Character {
    protected String name;
    protected int health;
    protected Map<String, Integer> power;
    protected int steroid;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health += health;
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
}