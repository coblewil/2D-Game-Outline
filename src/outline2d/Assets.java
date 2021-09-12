/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int WIDTH = 64, HEIGHT = 64;
    public static BufferedImage green, dirt, grass, tallgrass;
    public static BufferedImage tree, rock;
    public static BufferedImage fa, ff, fs, la, lf, ls, b1, ra, rf, rs; 
    public static BufferedImage fw1, fw2, fw3, fw4, fw5, fw6, fw7, fw8, fw9, fw10; //maybe save as array and loop through
    public static BufferedImage lw1, lw2, lw3, lw4, lw5, lw6, lw7, lw8, lw9, lw10;
    public static BufferedImage rw1, rw2, rw3, rw4, rw5, rw6, rw7, rw8, rw9, rw10;
    public static BufferedImage bw1, bw2, bw3, bw4, bw5, bw6, bw7, bw8, bw9, bw10;
    public static BufferedImage bg;
    public static BufferedImage[] dekuStart;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_right;
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/linksprite2.png"));
        green = ImageLoader.loadImage("res/textures/Tiles/LGreen.png");
        dirt = ImageLoader.loadImage("res/textures/Tiles/LDirt.png");
        grass = ImageLoader.loadImage("res/textures/Tiles/LGrass.png");
        tallgrass = ImageLoader.loadImage("res/textures/Tiles/LTallGrass.png");
        tree = ImageLoader.loadImage("res/textures/StaticEnts/Tree.png");
        rock = ImageLoader.loadImage("res/textures/StaticEnts/Rock.png");
        bg = ImageLoader.loadImage("res/textures/triforce.jpg");
        
        dekuStart = new BufferedImage[2];
        player_down = new BufferedImage[10];
        player_up = new BufferedImage[10];
        player_right = new BufferedImage[10];
        player_left = new BufferedImage[10];
        
        dekuStart[0]=ImageLoader.loadImage("res/textures/StaticEnts/DekuSprite.png");
        dekuStart[1]=ImageLoader.loadImage("res/textures/StaticEnts/DekuSpriteOpen2.png");
        
        fa = sheet.crop(0, 0, WIDTH, HEIGHT);
        ff = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        fs = sheet.crop(2*WIDTH, 0, WIDTH, HEIGHT);
        la = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
        ra = sheet.crop(0, 3*WIDTH, WIDTH, HEIGHT);
        b1 = sheet.crop(0, 2*WIDTH, WIDTH, HEIGHT);
        fw1= sheet.crop(0, HEIGHT*4, WIDTH, HEIGHT);
        fw2= sheet.crop(WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw3= sheet.crop(2*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw4= sheet.crop(3*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw5= sheet.crop(4*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw6= sheet.crop(5*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw7= sheet.crop(6*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw8= sheet.crop(7*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw9= sheet.crop(8*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        fw10= sheet.crop(9*WIDTH, HEIGHT*4, WIDTH, HEIGHT);
        lw1 = sheet.crop(0, HEIGHT*5, WIDTH, HEIGHT);
        lw2 = sheet.crop(WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw3 = sheet.crop(2*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw4 = sheet.crop(3*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw5 = sheet.crop(4*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw6 = sheet.crop(5*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw7 = sheet.crop(6*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw8 = sheet.crop(7*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw9 = sheet.crop(8*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        lw10 = sheet.crop(9*WIDTH, HEIGHT*5, WIDTH, HEIGHT);
        bw1 = sheet.crop(0, HEIGHT*6, WIDTH, HEIGHT);
        bw2 = sheet.crop(WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw3 = sheet.crop(2*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw4 = sheet.crop(3*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw5 = sheet.crop(4*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw6 = sheet.crop(5*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw7 = sheet.crop(6*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw8 = sheet.crop(7*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw9 = sheet.crop(8*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        bw10 = sheet.crop(9*WIDTH, HEIGHT*6, WIDTH, HEIGHT);
        rw1 = sheet.crop(0, HEIGHT*7, WIDTH, HEIGHT);
        rw2 = sheet.crop(WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw3 = sheet.crop(2*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw4 = sheet.crop(3*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw5 = sheet.crop(4*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw6 = sheet.crop(5*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw7 = sheet.crop(6*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw8 = sheet.crop(7*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw9 = sheet.crop(8*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        rw10 = sheet.crop(9*WIDTH, HEIGHT*7, WIDTH, HEIGHT);
        
        player_down[0]=fw1;
        player_down[1]=fw2;
        player_down[2]=fw3;
        player_down[3]=fw4;
        player_down[4]=fw5;
        player_down[5]=fw6;
        player_down[6]=fw7;
        player_down[7]=fw8;
        player_down[8]=fw9;
        player_down[9]=fw10;
        
        player_left[0]=lw1;
        player_left[1]=lw2;
        player_left[2]=lw3;
        player_left[3]=lw4;
        player_left[4]=lw5;
        player_left[5]=lw6;
        player_left[6]=lw7;
        player_left[7]=lw8;
        player_left[8]=lw9;
        player_left[9]=lw10;
        
        player_right[0]=rw1;
        player_right[1]=rw2;
        player_right[2]=rw3;
        player_right[3]=rw4;
        player_right[4]=rw5;
        player_right[5]=rw6;
        player_right[6]=rw7;
        player_right[7]=rw8;
        player_right[8]=rw9;
        player_right[9]=rw10;
        
        player_up[0]=bw1;
        player_up[1]=bw2;
        player_up[2]=bw3;
        player_up[3]=bw4;
        player_up[4]=bw5;
        player_up[5]=bw6;
        player_up[6]=bw7;
        player_up[7]=bw8;
        player_up[8]=bw9;
        player_up[9]=bw10;
    }
}
