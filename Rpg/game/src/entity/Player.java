package entity;

import main.GameInputKeys;
import main.GamePanel;
import main.UtilityTool;
import object.OBJDoorOpen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Entity {

    private long lastAnimationTime = System.currentTimeMillis();

    GamePanel gamePanel;
    GameInputKeys gameInputKeys;

    //Player position (x, y)
    public final int screenX;
    public final int screenY;

    private final Timer bootsTimer;
    public int haskey = 0;


    public Player(GamePanel gamePanel, GameInputKeys gameInputKeys) {

        this.gamePanel = gamePanel;
        this.gameInputKeys = gameInputKeys;

        screenX = gamePanel.screen_width / 2 - (gamePanel.tile_Size / 2);
        screenY = gamePanel.screen_height / 2 - (gamePanel.tile_Size / 2);

        solid_area = new Rectangle();
        solid_area.x = 16 * 5;
        solid_area.y = 28 * 5;
        solid_areaDefaultX = solid_area.x;
        solid_areaDefaultY = solid_area.y;
        solid_area.width = 32;
        solid_area.height = 32;

        bootsTimer = new Timer();


        setEntatyValues();
        getPlayerImage();

    }

    public void setEntatyValues() {

        worldx = gamePanel.tile_Size * 24;
        worldy = gamePanel.tile_Size * 22;
        player_speed = 4;
        direction = "idle";

    }

    public void getPlayerImage() {


        frame_run_right1 = setUp("12", "/runingRight/");
        frame_run_right2 = setUp("13", "/runingRight/");
        frame_run_right3 = setUp("14", "/runingRight/");
        frame_run_right4 = setUp("15", "/runingRight/");
        frame_run_right5 = setUp("16", "/runingRight/");
        frame_run_right6 = setUp("17", "/runingRight/");

        frame_run_left1 = setUp("39", "/runingLeft/");
        frame_run_left2 = setUp("40", "/runingLeft/");
        frame_run_left3 = setUp("41", "/runingLeft/");
        frame_run_left4 = setUp("42", "/runingLeft/");
        frame_run_left5 = setUp("43", "/runingLeft/");
        frame_run_left6 = setUp("44", "/runingLeft/");

        frame_run_up1 = setUp("18", "/runUp/");
        frame_run_up2 = setUp("19", "/runUp/");
        frame_run_up3 = setUp("20", "/runUp/");
        frame_run_up4 = setUp("21", "/runUp/");
        frame_run_up5 = setUp("22", "/runUp/");
        frame_run_up6 = setUp("23", "/runUp/");

        frame_run_down1 = setUp("6", "/rundown/");
        frame_run_down2 = setUp("7", "/rundown/");
        frame_run_down3 = setUp("8", "/rundown/");
        frame_run_down4 = setUp("9", "/rundown/");
        frame_run_down5 = setUp("10", "/rundown/");
        frame_run_down6 = setUp("11", "/rundown/");

        frame_idle1 = setUp("0", "/Idle/");
        frame_idle2 = setUp("1", "/Idle/");
        frame_idle3 = setUp("2", "/Idle/");
        frame_idle4 = setUp("3", "/Idle/");
        frame_idle5 = setUp("4", "/Idle/");
        frame_idle6 = setUp("5", "/Idle/");


    }

    private BufferedImage setUp(String frameNumber, String folder) {
        UtilityTool utilityTool = new UtilityTool();
        BufferedImage scaleImage;
        BufferedImage afterScaleImage= null;

        try {
            scaleImage = ImageIO.read(getClass().getResourceAsStream(folder + frameNumber + ".gif"));
            afterScaleImage = utilityTool.scaleImage(scaleImage, gamePanel.tile_Size*3, gamePanel.tile_Size*3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return afterScaleImage;
    }

    public void update() {


        // Check keyboard input and update player position accordingly
        if (gameInputKeys.upkey) {

            direction = "up";


        } else if (gameInputKeys.downkey) {

            direction = "down";


        } else if (gameInputKeys.leftkey) {

            direction = "left";


        } else if (gameInputKeys.rightkey) {

            direction = "right";


        } else {

            direction = "idle";

        }

        //check tile collision
        collision_ON = false;
        gamePanel.collisionChecker.checkTile(this);

        //check obj collision
        int objindex = gamePanel.collisionChecker.checkObject(this, true);
        pickUpObject(objindex);

        //if collision is false player can move
        if (!collision_ON) {


            switch (direction) {

                case "up":
                    worldy -= player_speed;
                    break;
                case "down":
                    worldy += player_speed;
                    break;
                case "left":
                    worldx -= player_speed;
                    break;
                case "right":
                    worldx += player_speed;
                    break;

            }

        }


    }

    public void pickUpObject(int index) {

        if (index != 999) {
            String objectName = gamePanel.superObject[index].name;

            // Adjust the delay as needed
            int delayInSeconds = 5;
            switch (objectName) {

                case "key":
                    haskey++;
                    gamePanel.superObject[index] = null;
                    gamePanel.playSound(1);
                    gamePanel.ui.showMessage("You got a key!");


                    break;
                case "door":

                    if (haskey > 0) {
                        gamePanel.superObject[index] = new OBJDoorOpen(gamePanel);
                        gamePanel.superObject[index].worldX = 14 * gamePanel.tile_Size;
                        gamePanel.superObject[index].worldY = 15 * gamePanel.tile_Size;
                        haskey--;
                        gamePanel.playSound(2);
                        gamePanel.ui.showMessage("You opened the door!");

                    } else {
                        gamePanel.ui.showMessage("You need a key!");
                    }


                    break;
                case "chest":
                    if (haskey > 0) {

                        gamePanel.superObject[index] = null;
                        haskey--;
                        gamePanel.playSound(2);
                        gamePanel.ui.showMessage("You opened the chest!");


                    } else {
                        gamePanel.ui.showMessage("You need a key!");
                    }

                    break;
                case "bootsBrown":


                    bootsTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gamePanel.superObject[index] = null;
                        }
                    }, delayInSeconds * 120); // Convert seconds to milliseconds

                    gamePanel.playSound(3);
                    player_speed = 5;
                    gamePanel.ui.showMessage("Speed up!");

                    break;
                case "dooropen":
                    break;
            }
        }

    }

    public void draw(Graphics2D graphics2D) {
        BufferedImage image;


        // Normal movement
        image = switch (direction.toLowerCase()) {
            case "left" -> getAnimationFrameRuningLeft();
            case "right" -> getAnimationFrameRuningRight();
            case "down" -> getAnimationFrameDown();
            case "up" -> getAnimationFrameUp();
            case "idle" -> getAnimationFrameIdle();
            default -> getAnimationFrameIdle();
        };


        graphics2D.drawImage(image, screenX, screenY, null);


        updateAnimationTimer();
    }


    private void updateAnimationTimer() {
        long currentTime = System.currentTimeMillis();

        // Adjust this value to control the animation speed (in milliseconds)
        int animationDelay = 120;
        if (currentTime - lastAnimationTime >= animationDelay) {
            // Update sprite counters and reset the timer
            sprite_Counter_run_right++;
            sprite_Counter_idle++;
            sprite_Counter_run_left++;
            sprite_Counter_run_up++;
            sprite_Counter_run_down++;

            if (sprite_Counter_run_up > 6) {
                sprite_Counter_run_up = 1;
            }

            if (sprite_Counter_run_down > 6) {
                sprite_Counter_run_down = 1;
            }

            if (sprite_Counter_run_right > 6) {
                sprite_Counter_run_right = 1;
            }

            if (sprite_Counter_run_left > 6) {
                sprite_Counter_run_left = 1;
            }

            if (sprite_Counter_idle > 6) {
                sprite_Counter_idle = 1;
            }

            lastAnimationTime = currentTime;
        }
    }


    private BufferedImage getAnimationFrameRuningRight() {
        // Use sprite counter to determine the animation frame
        return switch (sprite_Counter_run_right) {
            case 1 -> frame_run_right1;
            case 2 -> frame_run_right2;
            case 3 -> frame_run_right3;
            case 4 -> frame_run_right4;
            case 5 -> frame_run_right5;
            case 6 -> frame_run_right6;
            default -> frame_run_right1;  // Default to the first frame in case of unexpected value
        };
    }

    private BufferedImage getAnimationFrameRuningLeft() {
        // Use sprite counter to determine the animation frame
        return switch (sprite_Counter_run_right) {
            case 1 -> frame_run_left1;
            case 2 -> frame_run_left2;
            case 3 -> frame_run_left3;
            case 4 -> frame_run_left4;
            case 5 -> frame_run_left5;
            case 6 -> frame_run_left6;
            default -> frame_run_left1;  // Default to the first frame in case of unexpected value
        };
    }

    private BufferedImage getAnimationFrameIdle() {
        // Use sprite counter to determine the animation frame
        return switch (sprite_Counter_idle) {
            case 1 -> frame_idle1;
            case 2 -> frame_idle2;
            case 3 -> frame_idle3;
            case 4 -> frame_idle4;
            case 5 -> frame_idle5;
            case 6 -> frame_idle6;
            default -> frame_idle1;  // Default to the first frame in case of unexpected value
        };


    }

    private BufferedImage getAnimationFrameUp() {
        // Use sprite counter to determine the animation frame
        return switch (sprite_Counter_run_up) {
            case 1 -> frame_run_up1;
            case 2 -> frame_run_up2;
            case 3 -> frame_run_up3;
            case 4 -> frame_run_up4;
            case 5 -> frame_run_up5;
            case 6 -> frame_run_up6;
            default -> frame_run_up1;  // Default to the first frame in case of unexpected value
        };

    }

    private BufferedImage getAnimationFrameDown() {
        // Use sprite counter to determine the animation frame
        return switch (sprite_Counter_run_up) {
            case 1 -> frame_run_down1;
            case 2 -> frame_run_down2;
            case 3 -> frame_run_down3;
            case 4 -> frame_run_down4;
            case 5 -> frame_run_down5;
            case 6 -> frame_run_down6;
            default -> frame_run_down1;  // Default to the first frame in case of unexpected value
        };


    }

}
