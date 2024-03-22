package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Create a window for the game
        JFrame window_game = new JFrame();

        // Initialize the exit button
        window_game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make a non-resizable window positioned in the center
        window_game.setResizable(false);
        window_game.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window_game.setTitle("Rpg"); // Set window title

        // Create the game interface
        GamePanel gamePanel = new GamePanel();
        window_game.add(gamePanel);
        window_game.pack(); // Sizes the frame so that all its contents are at or above their preferred sizes

        window_game.setLocationRelativeTo(null); // Center the window on the screen
        window_game.setVisible(true);

        // Start the game thread
        gamePanel.setupGame();
        gamePanel.StartGameThread();

    }
}
