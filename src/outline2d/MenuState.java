/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State{
    
    private UIManager uiManager;
    
    public MenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        
        uiManager.addObject(new UIImageButton(handler.getWidth()/2 - Assets.dekuStart[0].getWidth()/2, 0, 250, 200, Assets.dekuStart, new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }
        ));
    }
        
    
    public void update(){
        uiManager.update();
    }
    
    public void render(Graphics g){
        uiManager.render(g);
        g.setColor(Color.YELLOW);
        g.drawString("Press Deku Tree to Start", 333, 310);
    }
}
