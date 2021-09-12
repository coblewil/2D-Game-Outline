/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author acob1
 */
public class ItemManager {
    
    private Handler handler;
    private ArrayList<Item> items;
    
    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<Item>();
    }
    
    public void update(){
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            Item i = it.next();
            i.update();;
            if(i.getCount()==Item.PICKED_UP){
                it.remove();
            }
        }
    }
    
    public void render(Graphics g){
        for(Item i: items){
            i.render(g);
        }
    }
    
    public void addItem(Item i){
        i.setHandler(handler);
        items.add(i);
    }
    
}
