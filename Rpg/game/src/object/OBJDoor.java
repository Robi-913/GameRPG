package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJDoor extends SuperObject{

    public OBJDoor(GamePanel gamePanel){

        name="door";


        try{

            image= ImageIO.read(getClass().getResourceAsStream("/objects/Item__72.png"));
            utilityTool.scaleImage(image, gamePanel. tile_Size, gamePanel.tile_Size);

        }catch (IOException e){

            e.printStackTrace();

        }

        collision=true;

    }

}
