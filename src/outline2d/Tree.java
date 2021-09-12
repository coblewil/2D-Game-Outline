/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tree extends StaticEntity{
    
    public Tree(Handler handler, float x, float y){
        super(handler, x, y, 42, 61); //image height and width
        bounds.x=0;
        bounds.y=(int)61/2-4;
        bounds.width=42;
        bounds.height=61-bounds.y;
        
        entityImage = Assets.tree; //custom
        
        healthbar[0]= new Rectangle(); //custom
        healthbar[1]= new Rectangle(); //custom
        healthbar[0].height=5; //custom
        healthbar[0].width=entityImage.getWidth(); //custom
        healthbar[1].height=5; //custom
        healthbar[1].width=0; //custom
    }
    
    public void update(){
        
    }
    
    @Override
    public void die(){
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x, (int)y));
    }
    
    public void render(Graphics g){
        g.drawImage(entityImage, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
        if(System.currentTimeMillis()-lastHurt<=1000){//custom
            g.setColor(Color.BLACK);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset())-1, (int)(y-handler.getGameCamera().getyOffset())-11, entityImage.getWidth()+2, healthbar[0].height+2);
            g.setColor(Color.RED);
            g.fillRect( (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset())-10, entityImage.getWidth(), healthbar[1].height);
            g.setColor(Color.GREEN);
            g.fillRect( (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset())-10, healthbar[0].width, healthbar[0].height);
            //g.drawString(Integer.toString(health), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()));
        }
        
        
    }

}
