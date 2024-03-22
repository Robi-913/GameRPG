package main;

import object.OBJBootsBrown;
import object.OBJChest;
import object.OBJDoor;
import object.OBJkey;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

    }

    public  void setObject(){

        gamePanel.superObject[0]=new OBJkey(gamePanel);
        gamePanel.superObject[0].worldX=25*gamePanel.tile_Size;
        gamePanel.superObject[0].worldY=16*gamePanel.tile_Size;

        gamePanel.superObject[1] = new OBJBootsBrown(gamePanel);
        gamePanel.superObject[1].worldX = 41 * gamePanel.tile_Size;
        gamePanel.superObject[1].worldY = 45 * gamePanel.tile_Size;

        gamePanel.superObject[2]=new OBJkey(gamePanel);
        gamePanel.superObject[2].worldX=25*gamePanel.tile_Size;
        gamePanel.superObject[2].worldY=40*gamePanel.tile_Size;

        gamePanel.superObject[3]=new OBJDoor(gamePanel);
        gamePanel.superObject[3].worldX=14*gamePanel.tile_Size;
        gamePanel.superObject[3].worldY=15*gamePanel.tile_Size;

        gamePanel.superObject[4]=new OBJChest(gamePanel);
        gamePanel.superObject[4].worldX=41*gamePanel.tile_Size;
        gamePanel.superObject[4].worldY=45*gamePanel.tile_Size-4;

        gamePanel.superObject[5]=new OBJChest(gamePanel);
        gamePanel.superObject[5].worldX=14*gamePanel.tile_Size;
        gamePanel.superObject[5].worldY=11*gamePanel.tile_Size;





    }

}
