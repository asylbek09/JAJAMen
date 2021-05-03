package com.practical.jajamen.oldman;

public class OpenScreen {

    InputParser ip = new InputParser();
    DataParser dp = new DataParser();

    public void introScreen() {
        ip.displayTextStream
                (" ██████╗██╗    ██████╗     ███╗   ███╗█████╗███╗   ██╗      ███╗   ███████████╗    ██╗    ██████████████╗██╗████████╗  █████████╗\n" +
                        "██╔═══████║    ██╔══██╗    ████╗ ██████╔══██████╗  ██║      ████╗  ████╔════██║    ██║    ╚══██╔══██╔══██████╔════██║ ██╔██╔════╝\n" +
                        "██║   ████║    ██║  ██║    ██╔████╔███████████╔██╗ ██║      ██╔██╗ ███████╗ ██║ █╗ ██║       ██║  ██████╔████║    █████╔╝███████╗\n" +
                        "██║   ████║    ██║  ██║    ██║╚██╔╝████╔══████║╚██╗██║      ██║╚██╗████╔══╝ ██║███╗██║       ██║  ██╔══██████║    ██╔═██╗╚════██║\n" +
                        "╚██████╔█████████████╔╝    ██║ ╚═╝ ████║  ████║ ╚████▄█╗    ██║ ╚███████████╚███╔███╔╝       ██║  ██║  ████╚████████║  █████████║\n" +
                        " ╚═════╝╚══════╚═════╝     ╚═╝     ╚═╚═╝  ╚═╚═╝  ╚═══╚═╝    ╚═╝  ╚═══╚══════╝╚══╝╚══╝        ╚═╝  ╚═╝  ╚═╚═╝╚═════╚═╝  ╚═╚═════");

        printInstructions();
    }

    public void printInstructions() {
        ip.displayTextStream("\n\nType one of the following:\n");
        ip.displayTextStream("\tplay - Start the game!\n");
        ip.displayTextStream("\tread - Learn how awesome the creators are!\n");
        ip.displayTextStream("\tquit - Quit and miss out on greatness!\n");
    }

    public void introduction() {
        ip.displayTextStream(dp.getIntro());
    }

    public void creatorDescription() {
        ip.displayTextStream("These creators are the best!!!");
    }
}