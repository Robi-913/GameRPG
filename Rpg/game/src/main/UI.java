package main;

import object.OBJkey;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gamePanel;
    Font font;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter;
    public boolean gameFinished = false;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        font = new Font("Comic Sans MS", Font.PLAIN, 30);
        OBJkey key = new OBJkey(gamePanel);
        keyImage = key.image;
    }

    public void showMessage(String string) {

        message = string;
        messageOn = true;

    }

    public void draw(Graphics2D graphics2D) {

        if(gameFinished){



        }else {

            graphics2D.setFont(font);
            graphics2D.setColor(Color.white);
            graphics2D.drawImage(keyImage, gamePanel.tile_Size / 4, gamePanel.tile_Size / 4, (int) (gamePanel.tile_Size / 1.2), (int) (gamePanel.tile_Size / 1.2), null);
            graphics2D.drawString("* " + gamePanel.player.haskey, 70, 45);

            if (messageOn) {
                graphics2D.setFont(graphics2D.getFont().deriveFont(30F));
                graphics2D.drawString(message, gamePanel.tile_Size, gamePanel.tile_Size * 2);

                messageCounter++;

                if (messageCounter > 200) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }

        }



    }

}
