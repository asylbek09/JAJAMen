package com.practical.jajamen.oldman;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OpenScreen {
    static Game game;

    public void introScreen() {
        System.out.println
                ("        ██████╗██╗    ██████╗     ███╗   ███╗█████╗███╗   ██╗      ███╗   ███████████╗    ██╗    ██████████████╗██╗████████╗  █████████╗\n" +
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
        String text = "";
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

    public static void saveGame() {
        try {
            FileOutputStream fileOutputForSave = new FileOutputStream("saveFile.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputForSave);
            objectOutputStream.writeObject(game);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Game saved\n");
        } catch (Exception e) {
            System.out.println("Can't save game!");
        }
    }

    public static void loadGame() {
        try {
            FileInputStream fileInputForLoad = new FileInputStream("saveFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputForLoad);
            game = (Game) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("-----game loaded------");
        } catch (Exception e) {
            System.out.println("Game can't be loaded");
        }
    }

}