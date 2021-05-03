package com.practical.jajamen.oldman;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Combat {
    InputParser ip;

    public Combat(Character hero, Character villain, String cityName, DataParser dp) throws IOException {
        ip = new InputParser();

        int hero_health = hero.getHealth();
        int villain_health = villain.getHealth();
        ip.displayTextStream("You just encountered: " + villain.getName() + "\n");
        ip.displayTextStream("Battle with " + villain.getName() + " starts\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (hero_health > 0 || villain_health > 0) {
            hero_health  = hero.getHealth();
            villain_health = villain.getHealth();
            ip.displayTextStream("Your health: " + hero_health + " , power and damage: " + hero.getPower() + "\n" +
                            villain.getName() + "'s health: " + villain_health + " , power and damage: " + villain.getPower() + "\n");
            ip.displayTextStream("Enter (p) to use your power or heal (h)? ");
            String action = in.readLine();

            if (action.equals("h")) {
                if (hero.getSteroid() != 0) {
                    int health_steroid = dp.getSteroid() + hero.getHealth();
                    hero.setHealth(health_steroid);
                    hero.setSteroid(hero.getSteroid() - 1);
                } else {
                    ip.displayTextStream("You don't have any steroid to boost your health!\n");
                }
            }
            if (action.equals("p")) {
                villain.setHealth(villain.getHealth() - hero.getPowerLimit());
                if(villain.getHealth() <= 0){
                    ip.displayTextStream("\n***Congratulations! You just killed " + villain.getName() + "!***\n");
                    hero.setHealth(dp.getCharacterHealth("Wolverine"));
                    dp.removeVillain(cityName);
                    break;
                }
                hero.setHealth(hero.getHealth() - villain.getPowerLimit());
                if(hero.getHealth() <= 0) {
                    ip.displayTextStream("\n***Ups, GAME OVER, you were killed by " + villain.getName() + "!***\n");
                    System.exit(0);
                }
            } else {
                ip.displayTextStream("Enter (p) to use your power or heal (h)? ");
            }
        }
    }
}