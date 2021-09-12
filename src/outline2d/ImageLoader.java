/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outline2d;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {
    
    public static BufferedImage loadImage(String path){
        //System.out.println(path);
        try{
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch(IOException e){
            System.out.println("ImageLoader error");
            System.exit(1);
        }
        return null;
    }
}
