package com.practical.jajamen.oldman;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    static String SPACE_DELIMITER = " ";
    static String CHAR_DELIMITER = "";
    // TODO: Find a setting that is pleasing
    // TODO: Create a way for the user to be able to modify the speed during gameplay
    // TODO: Create a "menu" for the user to be modify game settings (textSpeed, saveGame, etc...)
    static int TIME_BETWEEN_CHAR = 0;

    private Scanner scanner;
    private DataParser dataParser;
    private String verb;
    private String subject;

    InputParser() {
        scanner = new Scanner(System.in);
        dataParser = new DataParser("data");
    }

    // credit to Jasmine for the following method
    // will print out text slowly
    public void displayTextStream(String displayText) {
        String[] letters = displayText.split(CHAR_DELIMITER);
        for (String letter : letters) {
            System.out.print(letter);
            try {
                Thread.sleep(TIME_BETWEEN_CHAR);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: Change the souts to instead print from the inputParser
    // TODO: Show user what actions they have available
    // TODO: Give user examples of words they can use
    // will display whatever you pass it and grab the users next input
    public void grabNextInput() {
        System.out.println("\nWhat will your next action be?" + "THIS IS WHERE YOUR OPTIONS WILL SHOW UP");
        // will grab the user's response
        String result = scanner.nextLine();
        // will split the user's response - "go el paso" -> "go" "el paso"
        splitInput(result);
    }

    // will display whatever you pass it and grab the users next input
    public void showTextAndGrabNextInput(String displayText) {
        // will display the text that was passed in
        displayTextStream(displayText);
        // will grab the user's response
        String result = scanner.nextLine();
        // will split the user's response - "go el paso" -> "go" "el paso"
        splitInput(result);
    }

    public String getVerb() {
        return verb;
    }
    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    private void splitInput(String input) {
        // will split the user's response from the first word of the response
        // verbs are, effectively, only allowed to be one word
        List<String> splitResponse = Arrays.asList(input.split(SPACE_DELIMITER, 2));
        // will check to see if the user typed at least one word in
        if (!splitResponse.get(0).isEmpty())
            setVerb(splitResponse.get(0));
            // only used for troubleshooting, can be removed
            System.out.println("\nVERB: " + getVerb());
        // will check to see if the user typed several words in
        if (splitResponse.size() > 1)
            setSubject(splitResponse.get(1));
            // only used for troubleshooting, can be removed
            System.out.println("SUBJECT: " + getSubject() + "\n");
    }

    // TODO: Provide more words, allows the player more freedom
    // will check the player's input for a movement based verb
    public boolean isAllowedMovementVerb(String input) {
        List<String> allowedVerbs = Arrays.asList(
                // fill with verbs based on movement
                "go", "run", "hop", "skip", "jump", "walk", "mope", "meander", "wobble", "crawl"
        );
        return allowedVerbs.contains(input);
    }

    // TODO: Provide more words, allows the player more freedom
    // will check the player's input for an acquiring based verb
    public boolean isAllowedAcquireVerb(String input) {
        List<String> allowedMovementVerbs = Arrays.asList(
                // fill with verbs based on acquiring
                "grab", "get", "acquire", "attain", "snatch", "pilfer"
        );
        return allowedMovementVerbs.contains(input);
    }

    // TODO: Provide more words, allows the player more freedom
    // will check the player's input for combat
    public boolean isAllowedCombatVerb(String input) {
        List<String> allowedCombatVerbs = Arrays.asList(
                // fill with verbs based on acquiring
                "fight", "engage", "whoop", "open a can", "combat", "beat"
        );
        return allowedCombatVerbs.contains(input);
    }

    // TODO: Provide more words, allows the player more freedom
    // checks to see if the player can interact with a subject in their current city
    public boolean isAllowedSubject(String city, String input) {
        // should return all the things the player can interact with
        List<String> allowedSubjects = dataParser.getCityValues(city);
        return allowedSubjects.contains(input);
    }

    // TODO: Provide more words, allows the player more freedom
    public boolean isAllowedStatusVerb(String input) {
        List<String> allowedStatusVerbs = Arrays.asList(
                // fill with verbs based on acquiring
                "show", "view"
        );
        return allowedStatusVerbs.contains(input);
    }

    // TODO: Provide more words, allows the player more freedom
    // will check the player's input for quitting verbs
    public boolean isAllowedQuitVerb(String input) {
        List<String> allowedQuitVerbs = Arrays.asList(
                // fill with verbs based on leaving the app
                "quit", "exit", "leave", "q"
        );
        return allowedQuitVerbs.contains(input);
    }
}