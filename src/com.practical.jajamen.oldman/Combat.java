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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (hero_health > 0 || villain_health > 0) {
            System.out.print("Enter (p) to use your power or heal (h)? ");
            String action = in.readLine();
            System.out.println(
                    "Your health: " + hero_health + " , power and damage: " + hero.getPower() + "\n" +
                            villain.getName() + "'s health: " + villain_health + " , power and damage: " + villain.getPower() + "\n");
            if (action.equals("h")) {
                hero.setHealth(hero.getSteroid() + hero.getHealth());
            } else if (action.equals("p")) {
                if(hero_health < 0) {
                    System.out.println("Ups, GAME OVER, you were killed by " + villain.getName() + "!");
                    break;
                }
                if(villain_health < 0){
                    System.out.println("Congratulations! You just killed " + villain.getName());
                    break;
                }
                villain_health -= hero.getPowerLimit();
                hero_health -= villain.getPowerLimit();
            } else {
                System.out.println("Enter (p) to use your power or heal (h)? ");
            }
        }
    }
}