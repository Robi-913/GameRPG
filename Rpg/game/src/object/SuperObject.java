package object;

import main.GamePanel;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public  String name;
    public  boolean collision=false;
    public  int worldX;
    public  int worldY;

    public  Rectangle solid_aria = new Rectangle(0,0,64,64);
    public int solid_ariaDefaultX=0;
    public int solid_ariaDefaultY=0;
    UtilityTool utilityTool = new UtilityTool();

    public  void  draw(Graphics2D graphics2D, GamePanel gamePanel){

        int screen_x = worldX - gamePanel.player.worldx + gamePanel.player.screenX;
        int screen_y = worldY - gamePanel.player.worldy + gamePanel.player.screenY;


        if (worldX + gamePanel.tile_Size > gamePanel.player.worldx - gamePanel.player.screenX && worldX - gamePanel.tile_Size < gamePanel.player.worldx + gamePanel.player.screenX && worldY + gamePanel.tile_Size > gamePanel.player.worldy - gamePanel.player.screenY && worldY - gamePanel.tile_Size < gamePanel.player.worldy + gamePanel.player.screenY) {


                graphics2D.drawImage(image, screen_x, screen_y, gamePanel.tile_Size, gamePanel.tile_Size, null);


        }

    }



}
