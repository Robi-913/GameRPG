package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TilesManager {

    GamePanel gamePanel;
    public Tiles[] tile;
    public int[][] mapTileNumber;
    //int[][] mapTileNumber2;

    public TilesManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tiles[40];
        mapTileNumber = new int[gamePanel.max_World_col][gamePanel.max_World_row];


        loadMap("/maps/map2.txt");
        getTileImage();

    }

    public void getTileImage() {

//        try {
//
//            tile[0] = new Tiles();
//            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/000.png"));
//            tile[1] = new Tiles();
//            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/001.png"));
//            tile[2] = new Tiles();
//            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/002.png"));
//            tile[3] = new Tiles();
//            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/003.png"));
//            tile[4] = new Tiles();
//            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/004.png"));
//            tile[5] = new Tiles();
//            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/005.png"));
//            tile[6] = new Tiles();
//            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/006.png"));
//            tile[7] = new Tiles();
//            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/007.png"));
//            tile[8] = new Tiles();
//            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/008.png"));
//            tile[9] = new Tiles();
//            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/009.png"));
//            tile[10] = new Tiles();
//            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/010.png"));
//            tile[11] = new Tiles();
//            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/011.png"));
//            tile[12] = new Tiles();
//            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/012.png"));
//            tile[13] = new Tiles();
//            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/013.png"));
//            tile[14] = new Tiles();
//            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/014.png"));
//            tile[15] = new Tiles();
//            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/015.png"));
//            tile[16] = new Tiles();
//            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/016.png"));
//            tile[16].collision=true;
//            tile[17] = new Tiles();
//            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/017.png"));
//            tile[18] = new Tiles();
//            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/018.png"));
//            tile[18].collision=true;
//            tile[19] = new Tiles();
//            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/019.png"));
//            tile[19].collision=true;
//            tile[20] = new Tiles();
//            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/020.png"));
//            tile[20].collision=true;
//            tile[21] = new Tiles();
//            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/021.png"));
//            tile[21].collision=true;
//            tile[22] = new Tiles();
//            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/022.png"));
//            tile[22].collision=true;
//            tile[23] = new Tiles();
//            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/023.png"));
//            tile[23].collision=true;
//            tile[24] = new Tiles();
//            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/024.png"));
//            tile[24].collision=true;
//            tile[25] = new Tiles();
//            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/025.png"));
//            tile[25].collision=true;
//            tile[26] = new Tiles();
//            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/026.png"));
//            tile[26].collision=true;
//            tile[27] = new Tiles();
//            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/027.png"));
//            tile[27].collision=true;
//            tile[28] = new Tiles();
//            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/028.png"));
//            tile[28].collision=true;
//            tile[29] = new Tiles();
//            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/tiles/029.png"));
//            tile[29].collision=true;
//            tile[30] = new Tiles();
//            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/030.png"));
//            tile[30].collision=true;
//            tile[31] = new Tiles();
//            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/031.png"));
//            tile[31].collision=true;
//            tile[32] = new Tiles();
//            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/032.png"));
//            tile[32].collision=true;
//            tile[33] = new Tiles();
//            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/tiles/033.png"));
//            tile[34] = new Tiles();
//            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/tiles/034.png"));
//            tile[35] = new Tiles();
//            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/035.png"));
//            tile[35].collision=true;
//            tile[36] = new Tiles();
//            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/036.png"));
//            tile[37] = new Tiles();
//            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/037.png"));
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        setUp(0, "000", false);
        setUp(1, "001", false);
        setUp(2, "002", false);
        setUp(3, "003", false);
        setUp(4, "004", false);
        setUp(5, "005", false);
        setUp(6, "006", false);
        setUp(7, "007", false);
        setUp(8, "008", false);
        setUp(9, "009", false);
        setUp(10, "010", false);
        setUp(11, "011", false);
        setUp(12, "012", false);
        setUp(13, "013", false);
        setUp(14, "014", false);
        setUp(15, "015", false);
        setUp(16, "016", true);
        setUp(17, "017", false);
        setUp(18, "018", true);
        setUp(19, "019", true);
        setUp(20, "020", true);
        setUp(21, "021", true);
        setUp(22, "022", true);
        setUp(23, "023", true);
        setUp(24, "024", true);
        setUp(25, "025", true);
        setUp(26, "026", true);
        setUp(27, "027", true);
        setUp(28, "028", true);
        setUp(29, "029", true);
        setUp(30, "030", true);
        setUp(31, "031", true);
        setUp(32, "032", true);
        setUp(33, "033", true);
        setUp(34, "034", false);
        setUp(35, "035", true);
        setUp(36, "036", false);
        setUp(37, "037", false);

    }

    public void setUp(int index, String imageName, boolean collision) {

        UtilityTool utilityTool = new UtilityTool();

        try {

            tile[index] = new Tiles();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = utilityTool.scaleImage(tile[index].image, gamePanel.tile_Size, gamePanel.tile_Size);
            tile[index].collision = collision;


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadMap(String mapName) {

        try {

            InputStream inputStream = getClass().getResourceAsStream(mapName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            int col = 0;
            int row = 0;
            while (col < gamePanel.max_World_col && row < gamePanel.max_World_row) {

                String line = bufferedReader.readLine();
                while (col < gamePanel.max_World_col) {

                    String[] numbers = line.split(" ");

                    int number_int = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = number_int;
                    col++;

                }
                if (col == gamePanel.max_World_col) {
                    col = 0;
                    row++;
                }

            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D graphics2D) {


        int world_col = 0;
        int world_row = 0;


        while (world_col < gamePanel.max_World_col && world_row < gamePanel.max_World_row) {

            int tileNum = mapTileNumber[world_col][world_row];

            int wordl_x = world_col * gamePanel.tile_Size;
            int wordl_y = world_row * gamePanel.tile_Size;
            int screen_x = wordl_x - gamePanel.player.worldx + gamePanel.player.screenX;
            int screen_y = wordl_y - gamePanel.player.worldy + gamePanel.player.screenY;


            if (wordl_x + gamePanel.tile_Size > gamePanel.player.worldx - gamePanel.player.screenX && wordl_x - gamePanel.tile_Size < gamePanel.player.worldx + gamePanel.player.screenX && wordl_y + gamePanel.tile_Size > gamePanel.player.worldy - gamePanel.player.screenY && wordl_y - gamePanel.tile_Size < gamePanel.player.worldy + gamePanel.player.screenY) {

                graphics2D.drawImage(tile[tileNum].image, screen_x, screen_y, null);

            }


            world_col++;

            if (world_col == gamePanel.max_World_col) {
                world_col = 0;

                world_row++;


            }

        }


    }

}
