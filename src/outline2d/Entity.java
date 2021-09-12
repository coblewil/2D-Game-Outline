/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {
    
    public static final int DEFAULT_HEALTH = 10;
    protected Handler handler;
    protected float x,y;
    protected int width, height;
    public int health;
    protected boolean active = true;
    protected Rectangle bounds;
    protected long lastHurt; //custom
    protected Rectangle[] healthbar = new Rectangle[2]; //custom
    protected BufferedImage entityImage; //custom
    
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height= height;
        health = DEFAULT_HEALTH;
        
        bounds = new Rectangle(0, 0, width, height);
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public void hurt(int amt){
        health -= amt;
        lastHurt = System.currentTimeMillis(); //custom
        //if statement
        healthbar[0].width-=(int)entityImage.getWidth()/(DEFAULT_HEALTH/amt); //custom  total health instead of default
        healthbar[1].width+=(int)entityImage.getWidth()/(DEFAULT_HEALTH/amt); //custom
        if(health<=0){
            active = false;
            die();
        }
    }
    
    abstract void die();
    
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int)(x+bounds.x+xOffset), (int)(y+bounds.y+yOffset), bounds.width, bounds.height);
    }
    
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
        }
        }
        return false;
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    

}
