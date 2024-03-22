package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJBootsBrown extends SuperObject{

    public OBJBootsBrown(GamePanel gamePanel){

        name="bootsBrown";


        try{

            image= ImageIO.read(getClass().getResourceAsStream("/objects/Item__48.png"));
            utilityTool.scaleImage(image, gamePanel. tile_Size, gamePanel.tile_Size);

        }catch (IOException e){

            e.printStackTrace();

        }

        collision=true;

    }

}
