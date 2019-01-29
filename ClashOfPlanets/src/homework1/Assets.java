/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.awt.image.BufferedImage;

/**
 *
 * @author Luis Felipe Alvarez Sanchez A01194173
 */
public class Assets {
    public static BufferedImage planetOne, planetTwo, background;
    /**
     * 
     */
    public static void init(){
        background = ImageLoader.loadImage("/images/bg.png");
        planetOne = ImageLoader.loadImage("/images/sprite1.png");
        planetTwo = ImageLoader.loadImage("/images/sprite2.png");
    }
    
}
