package com.practical.jajamen.oldman;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * This class is designed to represent the game for the benefit of the player
 * Adventure will be passed into this class in order to help visualize the game
 * Options for menu creation
 */
class UserInterface {
//    Adventure adventure = null;

    UserInterface() {
    }

//    UserInterface(Adventure adventure) {
//        this.adventure = adventure;
//    }

    // creates a gap between components
    private EmptySpace space() {
        return new EmptySpace()
                        .setLayoutData(
                                GridLayout.createHorizontallyFilledLayoutData(2));
    }

    public static void main(String[] args) {
        // TODO: Refactor to adhere to OOP, currently running in main for fast prototyping
        UserInterface ui = new UserInterface();
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Screen screen = null;

        try {
            // create a lantera instance - will automatically choose a terminal based on your os
            screen = terminalFactory.createScreen();
            screen.startScreen();

            // disable the cursor for the window
            screen.setCursorPosition(null);

            Random random = new Random();
            TerminalSize terminalSize = screen.getTerminalSize();

            // create a multi-screen window
            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
            // title the window
            final Window window = new BasicWindow("Old Man, New Tricks");

            // how to create a gui box within the window - can create several
            Panel introGui = new Panel(new GridLayout(2));  // create the grid layout - designates the layout for the components

            GridLayout gridLayout = (GridLayout)introGui.getLayoutManager();
            gridLayout.setHorizontalSpacing(3);

            // how to label a component
            Label title = new Label("Welcome to JAJA Men's Project");
            title.setLayoutData(GridLayout.createLayoutData(
                    GridLayout.Alignment.BEGINNING,
                    GridLayout.Alignment.BEGINNING,
                    true,
                    false,
                    2,
                    1));
            // attach it to the gui window
            introGui.addComponent(title);

            introGui.addComponent(ui.space());

            introGui.addComponent(new Label("Use arrow keys to navigate"));

            introGui.addComponent(ui.space());

            introGui.addComponent(new Label("Characters"));
            List<String> mutants = new ArrayList<>(Arrays.asList("Logan", "Magneto", "Cyclops"));  // how to display a list
            ComboBox<String> readOnlyComboBox = new ComboBox<>(mutants);
            readOnlyComboBox.setReadOnly(true);  // cannot modify content
            readOnlyComboBox.setPreferredSize(new TerminalSize(20, 1));
            introGui.addComponent(readOnlyComboBox);

            introGui.addComponent(new Label("Inventory"));
            introGui.addComponent(
                    // how to display a list - alternate way
                    new ComboBox<>("Health Potion", "Attack Potion", "Defense Potion", "Speed Potion")
                            // allows you to modify the list
                            .setReadOnly(false)
                            .setLayoutData(GridLayout.createHorizontallyFilledLayoutData(1)));

            introGui.addComponent(new Label("Resume"));
            introGui.addComponent(
                    // how to create a button will a resulting window
                    new Button(
                            // button label
                            "Resume",
                            // button action - call a method here
                            () -> MessageDialog.showMessageDialog(
                                    textGUI,
                                    "Load Save",
                                    "Continuing to your adventure",
                                    MessageDialogButton.OK)).setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER)));

            introGui.addComponent(ui.space());

            introGui.addComponent(new Label("Color Attack"));
            Screen finalScreen = screen;
            introGui.addComponent(
                    // how to create a button will a resulting window
                    new Button(
                            // button label
                            "Begin",
                            // button action
                            () -> {
                                // this shows that we can replace the whole screen with custom colors - maybe custom images
                                for(int column = 0; column < terminalSize.getColumns(); column++) {
                                    for(int row = 0; row < terminalSize.getRows(); row++) {
                                        finalScreen.setCharacter(column, row, new TextCharacter(
                                                ' ',
                                                TextColor.ANSI.DEFAULT,
                                                // this will pick a random background color
                                                TextColor.ANSI.values()[random.nextInt(TextColor.ANSI.values().length)]));
                                    }
                                }
                                try {
                                    finalScreen.refresh();
                                    TimeUnit.MILLISECONDS.sleep(250);
                                } catch (IOException | InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }));

            introGui.addComponent(ui.space());

            introGui.addComponent(new Label("File Name"));
            introGui.addComponent(
                    // how to create an input box
                    new TextBox()
                            .setLayoutData(GridLayout.createLayoutData(GridLayout.Alignment.BEGINNING, GridLayout.Alignment.CENTER)));

            introGui.addComponent(ui.space());

            introGui.addComponent(
                    new Separator(Direction.HORIZONTAL)
                            .setLayoutData(
                                    GridLayout.createHorizontallyFilledLayoutData(2)));
            introGui.addComponent(
                    new Button("Close", window::close).setLayoutData(
                            GridLayout.createHorizontallyEndAlignedLayoutData(2)));

            window.setComponent(introGui);

            textGUI.addWindowAndWait(window);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(screen != null) {
                try {
                    screen.stopScreen();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}