package com.practical.jajamen.oldman;

/*
 * This is where the core of the project should be.
 * Game Client should only have to create an instance of this and then run start()
 */
class Game {
    DataParser dataParser;
    InputParser inputParser;
    Character logan;
    String currentCity;
    // TODO: create a field to know when the game has ended

    Game() {
        // insert the name of the JSON file that will be read
        dataParser = new DataParser("data");
        inputParser = new InputParser();
        // the following method allows you to create a character object using the game data
        logan = dataParser.createCharacter("Wolverine");
    }

    public void start() {
        /*
         * this should be composed of other methods
         * this is where the game's logic should live
         */
        inputParser.grabNextInput("Type the word: TEST \n");
        System.out.println("Did the INPUT match the word TEST?: " +
                ("TEST".equals(inputParser.getCurrentInput().get(0)))
        );
    }
}