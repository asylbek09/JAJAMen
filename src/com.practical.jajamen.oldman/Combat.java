package com.practical.jajamen.oldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combat {

    // TODO: End the fight when one Character has no more health
    // TODO: Declare a winner, the user won't know who won otherwise
    // TODO: Refactor in to several methods
    // TODO: Catch and handle the error that is being thrown
    InputParser ip;

    public Combat(Character hero, Character villain) throws IOException {
        ip = new InputParser();

        int hero_health = hero.getHealth();
        int villain_health = villain.getHealth();
        ip.displayTextStream("You just encountered: " + villain.getName() + "\n");
        ip.displayTextStream("Battle with " + villain.getName() + " starts\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (hero_health > 0 || villain_health > 0) {
            ip.displayTextStream("Your health: " + hero_health + " , power and damage: " + hero.getPower() + "\n" +
                            villain.getName() + "'s health: " + villain_health + " , power and damage: " + villain.getPower() + "\n");
            ip.displayTextStream("Enter (p) to use your power or heal (h)? ");
            String action = in.readLine();

            if (action.equals("h")) {
                if (hero.getSteroid() != 0) {
                    hero.setHealth(hero.getSteroid() + hero.getHealth());
                } else {
                    ip.displayTextStream("You don't have any steroid to boost your health!\n");
                }
            }
            if (action.equals("p")) {
                villain_health -= hero.getPowerLimit();
                hero_health -= villain.getPowerLimit();
                if(hero_health <= 0) {
                    ip.displayTextStream("Ups, GAME OVER, you were killed by " + villain.getName() + "!");
                    System.exit(0);
                }
                if(villain_health <= 0){
                    ip.displayTextStream("Congratulations! You just killed " + villain.getName());
                    System.exit(0);
                }
            } else {
                ip.displayTextStream("Enter (p) to use your power or heal (h)? ");
            }
        }
    }
}