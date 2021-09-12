
package outline2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyManager implements KeyListener{
    
    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean attack;
    public static ArrayList lastPressed;
    public static int lastReleased;
    
    public KeyManager(){
        keys = new boolean[256];
        lastPressed = new ArrayList<>();
        lastPressed.add(-3000); //just to prevent a index out of bounds exception
    }
    
    public void update(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        
        attack = keys[KeyEvent.VK_Z];
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_RIGHT){
            lastPressed.add(0, e.getKeyCode());
        }
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_RIGHT){
            //if(!keys[KeyEvent.VK_UP]&&!keys[KeyEvent.VK_DOWN]&&!!keys[KeyEvent.VK_LEFT]&&!!keys[KeyEvent.VK_RIGHT]){              
                lastPressed.removeAll(Arrays.asList(e.getKeyCode())); //custom
                lastReleased = e.getKeyCode();
            //}    
            //IF MOVEMENT IS STOPPED
        }
    }
    
    public boolean[] getKeys(){
        return keys;
    }
    
}
