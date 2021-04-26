package com.practical.jajamen.oldman;

import java.util.ArrayList;
import java.util.List;

/*
 * This is where the core of the project should be.
 * Game Client should only have to create an instance of this and then run start()
 */
class Game {
    DataParser dataParser;
    InputParser inputParser;
    Character logan;
    List<String> currentCity;
    List<String> cities;
    // TODO: create a field to know when the game has ended

    Game() {
        // insert the name of the JSON file that will be read
        dataParser = new DataParser("data");
        inputParser = new InputParser();
        // the following method allows you to create a character object using the game data
        logan = dataParser.createCharacter("Wolverine");
        cities = dataParser.getAllCities();
        currentCity = dataParser.getCityValues("North Dakota");
    }

    public void start() {
        /*
         * this should be composed of other methods
         * this is where the game's logic should live
         */
//        inputParser.grabNextInput("Type the word: TEST \n");
//        System.out.println("Did the INPUT match the word TEST?: " +
//                ("TEST".equals(inputParser.getCurrentInput().get(0)))
//        );
//        System.out.println(cities);
//        System.out.println(currentCity);
    }
}