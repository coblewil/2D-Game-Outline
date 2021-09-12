/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Creature{
    
    //Animations
    private Animation animdown, animright, animup,animleft;
    private boolean[] keys;
    private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
    
    public Player (Handler handler, float x, float y){
        super(handler, x, y, 64, 64);
        //this.handler = handler;
        
        bounds.x = 10;
        bounds.y = 40;
        bounds.width = 43;
        bounds.height = 24;
        
        animdown = new Animation(60, Assets.player_down);
        animup = new Animation(60, Assets.player_up);
        animleft = new Animation(60, Assets.player_left);
        animright = new Animation(60, Assets.player_right);
        
        keys = handler.getKeyManager().getKeys();
        
    }
    
    public void update(){
        animdown.update();
        animup.update();
        animleft.update();
        animright.update();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //Attack
        checkAttacks();
    }
    
    private void checkAttacks() {
        attackTimer += System.currentTimeMillis()-lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown){
            return;
        }
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().attack && (keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_RIGHT])) {
            if (keys[KeyEvent.VK_UP]) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if (keys[KeyEvent.VK_DOWN]) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            } else if (keys[KeyEvent.VK_LEFT]) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else if (keys[KeyEvent.VK_RIGHT]) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            }
        } else if (handler.getKeyManager().attack && ((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_UP || (int)KeyManager.lastPressed.get(0) == KeyEvent.VK_DOWN || (int)KeyManager.lastPressed.get(0) == KeyEvent.VK_LEFT || (int)KeyManager.lastPressed.get(0) == KeyEvent.VK_RIGHT)) {
            if ((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_UP) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if ((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_DOWN) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            } else if ((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_LEFT) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else if ((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_RIGHT) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            }
        }//custom
        /*if (handler.getKeyManager().attack && (KeyManager.lastused == KeyEvent.VK_UP||keys[KeyEvent.VK_UP])) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().attack && (KeyManager.lastused == KeyEvent.VK_DOWN||keys[KeyEvent.VK_DOWN])) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().attack && (KeyManager.lastused == KeyEvent.VK_LEFT||keys[KeyEvent.VK_LEFT])) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().attack && (KeyManager.lastused == KeyEvent.VK_RIGHT||keys[KeyEvent.VK_RIGHT])) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }*/ else {
            return;
        }
        
        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
                return;
            }
        }
    }
        
    
    
    @Override
    public void die(){
        System.out.println("You lose");
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        
        if((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_UP){
            //xMove = 0;
            yMove = -speed;            
        }
        if((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_DOWN){
            //xMove = 0;
            yMove = speed;            
        }
        if((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_LEFT){
            //yMove = 0;
            xMove = -speed;            
        }
        if((int)KeyManager.lastPressed.get(0) == KeyEvent.VK_RIGHT){
            //yMove = 0;
            xMove = speed;            
        }
    }
    
    public void render(Graphics g){
        g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()), width, height, null);
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        
        if(xMove<0){
            return animleft.getCurrentFrame();
        }
        else if(xMove>0){
            return animright.getCurrentFrame();
        }
        else if(yMove<0){
            return animup.getCurrentFrame();
        }
        else if(yMove>0){
            return animdown.getCurrentFrame();
        }else{
            if((int)KeyManager.lastReleased==KeyEvent.VK_UP){
                return Assets.b1;
            }
            else if((int)KeyManager.lastReleased==KeyEvent.VK_LEFT){
                return Assets.la;
            }
            else if((int)KeyManager.lastReleased==KeyEvent.VK_RIGHT){
                return Assets.ra;
            }
            else{return Assets.fa;}
        }
    }
}
