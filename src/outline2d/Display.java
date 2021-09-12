/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

//Window 12-16,18-35,42,43       https://www.youtube.com/watch?v=lf9awz6j88Q&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=2
//Canvas 10,11,16,36-41,44       https://www.youtube.com/watch?v=ck39jt04Qpk&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=3
//Buffers and Drawing 48,49      https://www.youtube.com/watch?v=Idb6-Zfdq2Q&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=5
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {

    private JFrame frame;
    private Canvas canvas;
    
    private String title;
    private int width, height;
    
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        
        createDisplay();
    }
    
    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        frame.add(canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
}
