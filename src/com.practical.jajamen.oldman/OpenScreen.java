package com.practical.jajamen.oldman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OpenScreen {
    // TODO: convert to a class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ██████╗██╗    ██████╗     ███╗   ███╗█████╗███╗   ██╗      ███╗   ███████████╗    ██╗    ██████████████╗██╗████████╗  █████████╗\n" +
                "██╔═══████║    ██╔══██╗    ████╗ ██████╔══██████╗  ██║      ████╗  ████╔════██║    ██║    ╚══██╔══██╔══██████╔════██║ ██╔██╔════╝\n" +
                "██║   ████║    ██║  ██║    ██╔████╔███████████╔██╗ ██║      ██╔██╗ ███████╗ ██║ █╗ ██║       ██║  ██████╔████║    █████╔╝███████╗\n" +
                "██║   ████║    ██║  ██║    ██║╚██╔╝████╔══████║╚██╗██║      ██║╚██╗████╔══╝ ██║███╗██║       ██║  ██╔══██████║    ██╔═██╗╚════██║\n" +
                "╚██████╔█████████████╔╝    ██║ ╚═╝ ████║  ████║ ╚████▄█╗    ██║ ╚███████████╚███╔███╔╝       ██║  ██║  ████╚████████║  █████████║\n" +
                " ╚═════╝╚══════╚═════╝     ╚═╝     ╚═╚═╝  ╚═╚═╝  ╚═══╚═╝    ╚═╝  ╚═══╚══════╝╚══╝╚══╝        ╚═╝  ╚═╝  ╚═╚═╝╚═════╚═╝  ╚═╚═════");

//Switch case to prompt the user to pick an option
        printInstructions();
        boolean quit = false;

        int choice;
        while (!quit) {
            try{
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        startGame();
                        break;
                    case 2:
                        creatorDescription();
                        break;
                    case 3:
                        return;
                }
            }catch(InputMismatchException e){
                System.out.println("That's an invalid input!");
                break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\n Press ");
        System.out.println("\t 1 - Start the game!");
        System.out.println("\t 2 - Learn how awesome the creators are!");
        System.out.println("\t 3 - Quit and miss out on greatness");
    }

    //Game starts when user pressed #1 and the intro to the game will begin
    public static void startGame() {

        String text = "Hey, It’s your favorite antihero Deadpool here! \n" +
                "You’re probably wondering why I’m here..and no, I’m not the jack ass Deadpool from X-Men Origins.\n" +
                "God, I hate that guy.\n" +
                "Anywhooooooo, we are going on a little journey and we get to follow one of my FAVORITE superheros! \n " +
                "Logan also known as the dashingly good-looking, Wolverine.";
        //Code to have letter print one by one
        char[] charArr = text.toCharArray();

        for (int i = 0; i <= charArr.length - 1; i++) {

            System.out.print(charArr[i]);
            try {
                Thread.sleep(45);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void creatorDescription() {
        System.out.println("These creator are the best!!!");

    }
}