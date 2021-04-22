package com.practical.jajamen.oldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combat {

    public Combat(Character hero, Character villain) throws IOException {
        int hero_health = hero.getHealth();
        int villain_health = villain.getHealth();
        System.out.println("You just encountered: " + villain.getName() + "\n");
        System.out.println("Battle with " + villain.getName() + " starts\n");
        System.out.println("Your stats for health: " + hero_health + " , power and damage: " + hero.getPower() + " / "
                + hero.getPowerLimit() + villain.getName() + "s health: " + villain_health + " , power and damage: "
                + villain.getPower() + " / " + villain.getPowerLimit());
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    }
}