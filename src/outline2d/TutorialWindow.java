/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

//Window 9-14               https://www.youtube.com/watch?v=lf9awz6j88Q&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=2
import javax.swing.JFrame;

public class TutorialWindow { 
    
    public static void main(String[] args) {
       Game game = new Game("Game", 800, 500);
       game.start();
    }
    
}
