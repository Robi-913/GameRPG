package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    //world position
    public int worldx;
    public int worldy;
    public int player_speed;

    public BufferedImage frame_run_right1, frame_run_right2, frame_run_right3, frame_run_right4, frame_run_right5, frame_run_right6;
    public BufferedImage frame_run_left1, frame_run_left2, frame_run_left3, frame_run_left4, frame_run_left5, frame_run_left6;
    public BufferedImage frame_idle1, frame_idle2, frame_idle3, frame_idle4, frame_idle5, frame_idle6;
    public BufferedImage frame_run_up1, frame_run_up2, frame_run_up3, frame_run_up4, frame_run_up5, frame_run_up6;
    public BufferedImage frame_run_down1, frame_run_down2, frame_run_down3, frame_run_down4, frame_run_down5, frame_run_down6;
    public String direction;

    //how many frames I have per animation
    public int sprite_Counter_run_right = 0;
    public int sprite_Counter_idle = 0;
    public int sprite_Counter_run_left = 0;
    public int sprite_Counter_run_up = 0;
    public int sprite_Counter_run_down = 0;

    public Rectangle solid_area;
    public  int solid_areaDefaultX;
    public  int solid_areaDefaultY;
    public boolean collision_ON = false;


}
