/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Graphics;

public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] map;
    private EntityManager entityManager;
    private ItemManager itemManager;
    
    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        itemManager = new ItemManager(handler);
        entityManager.addEntity(new Tree(handler, 250, 100));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*3, Tile.TILE_HEIGHT*5));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*10+12, Tile.TILE_HEIGHT*10-14));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*13+12, Tile.TILE_HEIGHT*15-14));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*14+12, Tile.TILE_HEIGHT*15-14));
        entityManager.addEntity(new Tree(handler, Tile.TILE_WIDTH*15+12, Tile.TILE_HEIGHT*15-14));
        entityManager.addEntity(new Rock(handler, 100, 300));
        
        entityManager.addEntity(new Rock(handler, 100, 500));
        entityManager.addEntity(new Rock(handler, 132, 500));
        entityManager.addEntity(new Rock(handler, 164, 500));
        entityManager.addEntity(new Rock(handler, 100, 532));
        entityManager.addEntity(new Rock(handler, 132, 532));
        entityManager.addEntity(new Rock(handler, 164, 532));
        entityManager.addEntity(new Rock(handler, 100, 564));
        entityManager.addEntity(new Rock(handler, 132, 564));
        entityManager.addEntity(new Rock(handler, 164, 564));
        loadWorld(path);
        
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);   
    }
    
    public void update(){
        itemManager.update();
        entityManager.update();
    }
    
    public void render(Graphics g){
        int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILE_WIDTH+1);
        int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILE_HEIGHT+1);
        for(int y = yStart;y<yEnd;y++){
            for(int x = xStart;x<xEnd;x++){
                Tile.greenTile.render(g, (int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int)(y*Tile.TILE_HEIGHT-handler.getGameCamera().getyOffset())); //CUSTOM
                getTile(x,y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int)(y*Tile.TILE_HEIGHT-handler.getGameCamera().getyOffset()));
            }
        }
        itemManager.render(g);
        
        entityManager.render(g);
    }
    
    public Tile getTile(int x, int y){
        if(x<0||y<0||x>= width||y>height){
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[map[x][y]];
        if(t==null){
            return Tile.dirtTile;
        }
        return t;
    }
    
    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);
        
        map = new int[width][height];
        for(int y =0;y<height;y++){
            for(int x=0;x<width;x++){
                map[x][y]=Utils.parseInt(tokens[((x+y*width)+4)]);
            }
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
}
