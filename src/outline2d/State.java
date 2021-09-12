/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Graphics;

public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    //CLASS
    
    protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
    }
    public abstract void update();
    
    public abstract void render(Graphics g);
}
