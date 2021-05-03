package com.practical.jajamen.oldman;

import java.io.IOException;
import java.util.InputMismatchException;

/*
 * This is where the core of the project should be.
 * Game Client should only have to create an instance of this and then run start()
 */
class Game {
    DataParser dataParser;
    InputParser inputParser;
    Character logan;
    OpenScreen openScreen;
    String currentCity;

    boolean quit = false;
    boolean introComplete = false;
    boolean gameFinished = false;

    Game() {
        // insert the name of the JSON file that will be read
        dataParser = new DataParser();
        inputParser = new InputParser();
        // the following method allows you to create a character object using the game data
        logan = dataParser.createCharacter("Wolverine");
        currentCity = "El Paso";
        openScreen = new OpenScreen();
    }

    public void askPlayer() {
        // will continue to ask the user what they want to do until they pass a valid response
        while (inputParser.getVerb().isEmpty()) {
            dataParser.printArea(getCurrentCity());
            inputParser.grabNextInput();
        }
    }

    public void showStatus() {
        String[] output = {"---------------------------------", "Your are " + logan.getName(), "You are in the " + currentCity,
                "Your health: " + logan.getHealth(), "You own: " + logan.getSteroid() + " steroids", "---------------------------------"};
        for (int i = 0; i < output.length; i++) {
            inputParser.displayTextStream(output[i] + "\n");
        }
    }

    public void gameLogic() {
        /*
         * !!!!!!!!!!!!!!!!!! HEY THERE !!!!!!!!!!!!!!!!!!
         * all the code that runs after the intro goes here
         */
        while (!isGameFinished()) {

            // resets the user's last input
            inputParser.setVerb("");
            inputParser.setSubject("");

            // ask for new input
            askPlayer();

            // checks to see if the input verb is empty
            if (!inputParser.getVerb().isEmpty()) {
                gameImplementaion();
            }
        }
    }

    public void start() {
        // will show the intro screen
        openScreen.introScreen();

        while (!isQuit()) {
            // will check to see if the intro has completed
            if (!isIntroComplete()) {
                try {
                    inputParser.showTextAndGrabNextInput("\nEnter your choice: ");
                    String choice = inputParser.getVerb();

                    switch (choice) {
                        case ("play"):
                            // shows the introduction screen
                            openScreen.introduction();
                            setIntroComplete(true);
                            // gameLogic is where the core of the game is located
                            gameLogic();
                            break;
                        case ("read"):
                            openScreen.creatorDescription();
                            break;
                        case ("quit"):
                            setQuit(true);
                            break;
                    }
                } catch (InputMismatchException e) {
                    inputParser.displayTextStream("That's an invalid input!");
                    break;
                }
            }
        }
    }

    public void gameImplementaion() {
        inputParser.displayTextStream("OUTER - VERB: Parsing logic route\n");
        String verb = inputParser.getVerb();

        if (inputParser.isAllowedStatusVerb(verb)) {
            // show status
            inputParser.displayTextStream("STATUS: You're in the status route\n");
            showStatus();
        }

        if (inputParser.isAllowedQuitVerb(verb)) {
            inputParser.displayTextStream("QUIT: You're in the quit route\n");
            System.exit(0);
        }

        // checks to see if the subject is empty
        if (!inputParser.getSubject().isEmpty()) {
            String subject = inputParser.getSubject();
            inputParser.displayTextStream("INNER - VERB, SUBJECT: Parsing logic route\n");

            // within this scope, you will only be able to interact with city targets
            if (inputParser.isAllowedSubject(getCurrentCity(), subject)) {

                if (inputParser.isAllowedMovementVerb(verb)) {
                    // changes the current city to the subject
                    inputParser.displayTextStream("MISSION: You're in the mission route\n");
                    setCurrentCity(subject);
                }

                if (inputParser.isAllowedAcquireVerb(verb)) {
                    // get steroid
                    inputParser.displayTextStream("ITEM: You're in the item route\n");
                    logan.setSteroid(logan.getSteroid() + 1);
                    inputParser.displayTextStream("You now own: " + logan.getSteroid() + " steroids");
                }

                if (inputParser.isAllowedCombatVerb(verb)) {
                    // fight subject
                    inputParser.displayTextStream("COMBAT: You're in the combat route\n");
                    try {
                        // creates a fight between logan and the city villain
                        showStatus();
                        new Combat(logan, dataParser.createCharacter(dataParser.getCityVillain(getCurrentCity())), getCurrentCity(), dataParser);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public boolean isIntroComplete() {
        return introComplete;
    }

    public void setIntroComplete(boolean introComplete) {
        this.introComplete = introComplete;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }
}