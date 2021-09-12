
package outline2d;

import java.awt.Graphics;

public class GameState extends State{
    
    private World world;
    
    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/worlds/world2.txt");
        handler.setWorld(world);
    }
    
    public void update(){
        world.update();
    }
    
    public void render(Graphics g){
        world.render(g);
        //Tile.tiles[0].render(g, 0,0);
    }
}
