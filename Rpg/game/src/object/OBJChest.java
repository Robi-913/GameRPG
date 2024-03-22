package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJChest extends SuperObject{

    public OBJChest(GamePanel gamePanel){

        name="chest";


        try{

            image= ImageIO.read(getClass().getResourceAsStream("/objects/Item__73.png"));
            utilityTool.scaleImage(image, gamePanel. tile_Size, gamePanel.tile_Size);

        }catch (IOException e){

            e.printStackTrace();

        }

        collision=true;

    }

}
