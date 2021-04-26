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
        System.out.println("\n Press ");
        System.out.println("\t 1 - Start the game!");
        System.out.println("\t 2 - Learn how awesome the creators are!");
        System.out.println("\t 3 - Quit and miss out on greatness");
    }

    //Game starts when user pressed #1 and the intro to the game will begin
    public void startGame() {

        String text = "Hey, It’s your favorite antihero Deadpool here!\n" +
                "You’re probably wondering why I’m here..and no, I’m not the jack ass Deadpool from X-Men Origins.\n" +
                "God, I hate that guy.\n" +
                "Anywhooooooo, we are going on a little journey and we get to follow one of my FAVORITE superheros!\n" +
                "Logan also known as the dashingly good-looking, Wolverine.\n";
        //Code to have letter print one by one
        char[] charArr = text.toCharArray();

        for (int i = 0; i <= charArr.length - 1; i++) {
            System.out.print(charArr[i]);
            try {
                Thread.sleep(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showInstructions() {
        System.out.println("Commands:\n" +
                "  go [north, south, east, west]\n" +
                "  get [steroid]\n" +
                "  fight [villain name]\n" +
                "  run\n" +
                "  q [to quit the game]");
    }

    public void creatorDescription() {
        System.out.println("These creators are the best!!!");
    }
}