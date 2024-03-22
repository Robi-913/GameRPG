package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJDoorOpen extends  SuperObject{

    public OBJDoorOpen(GamePanel gamePanel){

        name="dooropen";


        try{

            image= ImageIO.read(getClass().getResourceAsStream("/objects/Item__74.png"));
            utilityTool.scaleImage(image, gamePanel. tile_Size, gamePanel.tile_Size);

        }catch (IOException e){

            e.printStackTrace();

        }


    }
}
