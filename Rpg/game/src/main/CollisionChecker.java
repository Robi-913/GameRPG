package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

    }

    public void checkTile(Entity entity) {

        int entity_left_world_x = entity.worldx + entity.solid_area.x;
        int entity_right_world_x = entity.worldx + entity.solid_area.x + entity.solid_area.width;
        int entity_top_world_y = entity.worldy + entity.solid_area.y;
        int entity_down_world_y = entity.worldy + entity.solid_area.y + entity.solid_area.height;


        int entity_left_col = entity_left_world_x / gamePanel.tile_Size;
        int entity_right_col = entity_right_world_x / gamePanel.tile_Size;
        int entity_top_row = entity_top_world_y / gamePanel.tile_Size;
        int entity_down_row = entity_down_world_y / gamePanel.tile_Size;

        int tile_nr1;
        int tile_nr2;

        switch (entity.direction) {

            case "up":

                entity_top_row = (entity_top_world_y - entity.player_speed) / gamePanel.tile_Size;
                tile_nr1 = gamePanel.tilesManager.mapTileNumber[entity_left_col][entity_top_row];
                tile_nr2 = gamePanel.tilesManager.mapTileNumber[entity_right_col][entity_top_row];
                if (gamePanel.tilesManager.tile[tile_nr1].collision || gamePanel.tilesManager.tile[tile_nr2].collision) {
                    entity.collision_ON = true;
                }

                break;
            case "down":

                entity_down_row = (entity_down_world_y + entity.player_speed) / gamePanel.tile_Size;
                tile_nr1 = gamePanel.tilesManager.mapTileNumber[entity_left_col][entity_down_row];
                tile_nr2 = gamePanel.tilesManager.mapTileNumber[entity_right_col][entity_down_row];
                if (gamePanel.tilesManager.tile[tile_nr1].collision || gamePanel.tilesManager.tile[tile_nr2].collision) {
                    entity.collision_ON = true;
                }

                break;
            case "left":

                entity_left_col = (entity_left_world_x - entity.player_speed) / gamePanel.tile_Size;
                tile_nr1 = gamePanel.tilesManager.mapTileNumber[entity_left_col][entity_top_row];
                tile_nr2 = gamePanel.tilesManager.mapTileNumber[entity_left_col][entity_down_row];
                if (gamePanel.tilesManager.tile[tile_nr1].collision || gamePanel.tilesManager.tile[tile_nr2].collision) {
                    entity.collision_ON = true;
                }

                break;
            case "right":

                entity_right_col = (entity_right_world_x + entity.player_speed) / gamePanel.tile_Size;
                tile_nr1 = gamePanel.tilesManager.mapTileNumber[entity_right_col][entity_top_row];
                tile_nr2 = gamePanel.tilesManager.mapTileNumber[entity_right_col][entity_down_row];
                if (gamePanel.tilesManager.tile[tile_nr1].collision || gamePanel.tilesManager.tile[tile_nr2].collision) {
                    entity.collision_ON = true;
                }

                break;


        }


    }


    public int checkObject(Entity entity, boolean player) {

        int index = 999;

        for (int i = 0; i < gamePanel.superObject.length; i++) {

            if (gamePanel.superObject[i] != null) {

                entity.solid_area.x = entity.worldx + entity.solid_area.x;
                entity.solid_area.y = entity.worldy + entity.solid_area.y;

                gamePanel.superObject[i].solid_aria.x = gamePanel.superObject[i].worldX + gamePanel.superObject[i].solid_aria.x;
                gamePanel.superObject[i].solid_aria.y = gamePanel.superObject[i].worldY + gamePanel.superObject[i].solid_aria.y;

                switch (entity.direction) {

                    case "up":
                        entity.solid_area.y -= entity.player_speed;
                        if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                            if(gamePanel.superObject[i].collision){

                                entity.collision_ON=true;

                            }
                            if(player){

                                index=i;

                            }
                        }
                        break;
                    case "down":
                        entity.solid_area.y += entity.player_speed;
                        if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                            if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                                if(gamePanel.superObject[i].collision){

                                    entity.collision_ON=true;

                                }
                                if(player){

                                    index=i;

                                }
                            }
                        }
                        break;
                    case "left":
                        entity.solid_area.x -= entity.player_speed;
                        if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                            if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                                if(gamePanel.superObject[i].collision){

                                    entity.collision_ON=true;

                                }
                                if(player){

                                    index=i;

                                }
                            }
                        }
                        break;
                    case "right":
                        entity.solid_area.x += entity.player_speed;
                        if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                            if(entity.solid_area.intersects(gamePanel.superObject[i].solid_aria)){
                                if(gamePanel.superObject[i].collision){

                                    entity.collision_ON=true;

                                }
                                if(player){

                                    index=i;

                                }
                            }
                        }
                        break;


                }

                entity.solid_area.x=entity.solid_areaDefaultX;
                entity.solid_area.y=entity.solid_areaDefaultY;
                gamePanel.superObject[i].solid_aria.x = gamePanel.superObject[i].solid_ariaDefaultX;
                gamePanel.superObject[i].solid_aria.y = gamePanel.superObject[i].solid_ariaDefaultY;

            }

        }


        return index;

    }


}
