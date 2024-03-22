package main;

import entity.Player;
import object.SuperObject;
import tile.TilesManager;


import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {


    // Settings for screen
    final int original_TileSize = 16;  // 16x16
    final int scale = 4;

    public final int tile_Size = original_TileSize * scale;  // Size of the character
    public final int max_screen_colons = 20;
    public final int max_screen_rows = 12;
    public final int screen_width = tile_Size * max_screen_colons;  // 1280 pixels
    public final int screen_height = tile_Size * max_screen_rows;  // 768 pixels

    Color myColor = new Color(0, 0, 0, 255);
    //world map
    public final int max_World_col=60;
    public final int max_World_row=60;




    // Frames per second (FPS)
    private static final double FPS = 120;
    private static final double UPS = 60;

    //System
    TilesManager tilesManager = new TilesManager(this);
    Sound sound= new Sound();
    Sound music = new Sound();
    public  UI ui = new UI(this);
    Thread game_Thread;  // Thread to monitor the game timer
    GameInputKeys key_imput = new GameInputKeys();  // Handles keyboard input
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public  AssetSetter assetSetter = new AssetSetter(this);


    //entity and object
    public Player player = new Player(this, key_imput);

    public  SuperObject []superObject= new SuperObject[10];



    // Create the game window for interaction
    public GamePanel() {

        this.setPreferredSize(new Dimension(screen_width, screen_height));  // Set panel size
        this.setBackground(myColor);  // Set background color
        this.setDoubleBuffered(true);  // Enable double buffering for smooth rendering
        this.addKeyListener(key_imput);  // Add keyboard input listener
        this.setFocusable(true);  // Panel can receive focus



    }

    public  void setupGame(){


        assetSetter.setObject();
        playMusic(0);

    }

    // Start the game thread
    public void StartGameThread() {

        game_Thread = new Thread(this);
        game_Thread.start();

    }

    // Game loop
    @Override
    public void run() {

        double frameTime = 1000000000.0 / FPS;  // Time between frames for FPS
        double updateTime = 1000000000.0 / UPS;  // Time between updates for UPS
        long lastTime = System.nanoTime();  // Current time in nanoseconds
        double elapsedFrames = 0.0;  // Time between frames
        double elapsedUpdates = 0.0;  // Time between updates
        long timer = 0;
        int frameCount = 0;
        int updateCount = 0;

        // Game loop continues until forcibly stopped
        while (game_Thread != null) {

            long currentTime = System.nanoTime();
            elapsedFrames += (currentTime - lastTime) / frameTime;
            elapsedUpdates += (currentTime - lastTime) / updateTime;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (elapsedUpdates >= 1.0) {

                update();  // Update game logic
                elapsedUpdates--;
                updateCount++;

            }

            if (elapsedFrames >= 1.0) {

                repaint();  // Repaint the screen
                elapsedFrames--;
                frameCount++;

            }

            // Display the frame and update rates per second
            if (timer >= 1000000000) {

                System.out.println("FPS: " + frameCount + ", UPS: " + updateCount);
                frameCount = 0;
                updateCount = 0;
                timer = 0;

            }
        }
    }


    // Update game logic
    public void update() {

        player.update();




    }

    // Paint component to render the game graphics
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);  // Call the superclass paintComponent method

        Graphics2D graphics2D = (Graphics2D) graphics;  // Convert graphics to 2D



        //tiles
        tilesManager.draw(graphics2D);

        //objects
        for (SuperObject object : superObject) {

            if (object != null) {

                object.draw(graphics2D, this);

            }

        }

        //player
        player.draw(graphics2D);

        //UI
        ui.draw(graphics2D);

        graphics2D.dispose();  // Release system resources


    }

    public void playMusic(int index){

        music.setFile(index);
        music.play();
        music.loop();

    }

    public void playSound(int index){

        sound.setFile(index);
        sound.play();

    }

    public  void stopMusic(){

        music.stop();

    }


}
