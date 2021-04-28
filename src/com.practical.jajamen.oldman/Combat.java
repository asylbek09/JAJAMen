package com.practical.jajamen.oldman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combat {

    // TODO: End the fight when one Character has no more health
    // TODO: Declare a winner, the user won't know who won otherwise
    // TODO: Refactor in to several methods
    // TODO: Catch and handle the error that is being thrown
    // TODO: Change the souts to instead print from the inputParser
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
                hero.setHealth(hero.getSteroid());
            } else {
                villain_health -= hero.getPowerLimit();
                hero_health -= villain.getPowerLimit();
                if(hero_health < 0) {
                    System.out.println("Ups, GAME OVER, you were killed by " + villain.getName() + "!");
                    break;
                }
                if(villain_health < 0){
                    System.out.println("Congratulations! You just killed " + villain.getName());
                    break;
                }
            }
        }
    }
}