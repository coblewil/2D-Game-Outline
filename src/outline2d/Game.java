/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.Color; //NEW
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

//Canvas 16-19,27-31                       https://www.youtube.com/watch?v=ck39jt04Qpk&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=3
//Threads & Game Loop 21,22, 34-41, 55-81  https://www.youtube.com/watch?v=vFRuEgEdO9Q&index=4&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ
//Buffers and Drawing 24,25, 42-53         https://www.youtube.com/watch?v=Idb6-Zfdq2Q&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=5
//NEW Rectangles                           https://www.youtube.com/watch?v=HdNVFBgNNvY&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=6
public class Game implements Runnable {
    private Display display;
    private int width, height;
    public String title;
    
    private boolean running;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    //private State gameState;
    //private State menuState;
    public State gameState;
    public State menuState;
    
    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        //display = new Display(title, width, height);
    }
    
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0,0);
        
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        //State.setState(gameState);
        State.setState(menuState);
    }
    
    //int imagex = 0;
    //int imagevx =1;
    private void update(){
        keyManager.update();
        if(State.getState()!= null){
            State.getState().update();
        }
        /*if(imagex+120+1>width){
            imagevx = -imagevx;
            imagex+=imagevx;
        }
        else if(imagex<0){
            imagevx = -imagevx;
            imagex+=imagevx;
        }else{imagex+=imagevx;}*/
    }
    
    private void render(){
        //a buffer is a hidden computer screen in your computer
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //graphics is like a paintbrush
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height); //clears screen
        //g.drawImage(Assets.fw1, imagex, height/2-65, null);
        //g.setColor(Color.RED);
        //g.drawRect(10, 50, 50, 70);
        if(State.getState()!= null){
            State.getState().render(g);
        }
        bs.show();
        g.dispose();
        
    }
    public void run(){
        init();
        
        int fps =60;
        double timePerTick = 1000000000/fps;
        double delta= 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        //1)game loop updates all variables, positions of object, etc. EVERYTHING 2)draw everything to the screen 3) repeat
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now-lastTime;
            lastTime = now;
            if (delta>=1){
                update();
                render();
                ticks++;
                delta--;
            }
            
            if(timer>=1000000000){
                ticks = 0;
                timer=0;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running){
            return;
        }
        running = false;
        try{
            thread.join();
        }catch (InterruptedException e){}
        
    }
}
