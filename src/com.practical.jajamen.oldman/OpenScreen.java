package com.practical.jajamen.oldman;

public class OpenScreen {

    public void introScreen() {
        System.out.println
                (" ██████╗██╗    ██████╗     ███╗   ███╗█████╗███╗   ██╗      ███╗   ███████████╗    ██╗    ██████████████╗██╗████████╗  █████████╗\n" +
                        "██╔═══████║    ██╔══██╗    ████╗ ██████╔══██████╗  ██║      ████╗  ████╔════██║    ██║    ╚══██╔══██╔══██████╔════██║ ██╔██╔════╝\n" +
                        "██║   ████║    ██║  ██║    ██╔████╔███████████╔██╗ ██║      ██╔██╗ ███████╗ ██║ █╗ ██║       ██║  ██████╔████║    █████╔╝███████╗\n" +
                        "██║   ████║    ██║  ██║    ██║╚██╔╝████╔══████║╚██╗██║      ██║╚██╗████╔══╝ ██║███╗██║       ██║  ██╔══██████║    ██╔═██╗╚════██║\n" +
                        "╚██████╔█████████████╔╝    ██║ ╚═╝ ████║  ████║ ╚████▄█╗    ██║ ╚███████████╚███╔███╔╝       ██║  ██║  ████╚████████║  █████████║\n" +
                        " ╚═════╝╚══════╚═════╝     ╚═╝     ╚═╚═╝  ╚═╚═╝  ╚═══╚═╝    ╚═╝  ╚═══╚══════╝╚══╝╚══╝        ╚═╝  ╚═╝  ╚═╚═╝╚═════╚═╝  ╚═╚═════");

        printInstructions();
    }

    public void printInstructions() {
        System.out.println("\n Type one of the following ");
        System.out.println("\t play - Start the game!");
        System.out.println("\t read - Learn how awesome the creators are!");
        System.out.println("\t quit - Quit and miss out on greatness");
    }

    // TODO: Refactor into several different methods
    //Game starts when user pressed #1 and the intro to the game will begin
    public void introduction() {

        // TODO: Maybe feed this into the inputParser, can also be placed into the data.json and then pulled from there
        String text =
                "Hey, It’s your favorite antihero Deadpool here!\n" +
                "You’re probably wondering why I’m here..and no, I’m not the jack ass Deadpool from X-Men Origins.\n" +
                "God, I hate that guy.\n" +
                "Anywhooooooo, we are going on a little journey and we get to follow one of my FAVORITE superheros!\n" +
                "Logan also known as the dashingly good-looking, Wolverine.\n";
        //Code to have letter print one by one
        char[] charArr = text.toCharArray();

        // TODO: Re-implemented in inputParser, should this be here?
        for (int i = 0; i <= charArr.length - 1; i++) {
            System.out.print(charArr[i]);
            try {
                Thread.sleep(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: Get creators to actually provide descriptions of themselves
    // TODO: print the sout using inputParser
    public void creatorDescription() {
        System.out.println("These creators are the best!!!");
    }
}