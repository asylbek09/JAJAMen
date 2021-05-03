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

    //Game starts when user pressed #1 and the intro to the game will begin
    public void introduction() {

        String text = "";
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

    public void creatorDescription() {
        System.out.println("These creators are the best!!!");
    }
}