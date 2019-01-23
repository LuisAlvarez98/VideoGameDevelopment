/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.image.BufferedImage;

/**
 *
 * @author luisf
 */
public class Assets {
    public static BufferedImage background;
    public static BufferedImage player;
    public static void init(){
        background = ImageLoader.loadImage("/images/background.png");
        player = ImageLoader.loadImage("/images/player.png");
       
    }
}
