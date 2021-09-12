/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
    
    public static Tile[] tiles = new Tile[256];
    public static Tile greenTile = new GreenTile(0);
    public static Tile dirtTile = new DirtTile(1);
    public static Tile grassTile = new GrassTile(2);
    public static Tile tallgrassTile = new TallGrassTile(3);
    public static Tile treeTile = new TreeTile(4);
    
    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
    
    protected BufferedImage texture;
    protected final int id;
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
    public void update(){}
    
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public int getId(){
        return id;
    }
}
