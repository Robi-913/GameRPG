package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJkey extends  SuperObject{


    public OBJkey(GamePanel gamePanel){

        name="key";


        try{

            image= ImageIO.read(getClass().getResourceAsStream("/objects/Item__68.png"));
            utilityTool.scaleImage(image, gamePanel. tile_Size, gamePanel.tile_Size);

        }catch (IOException e){

            e.printStackTrace();

        }

        collision=true;

    }

}
