package homework2;

import java.awt.image.BufferedImage;

/**
 * Assets Class
 * @author Luis Felipe Alvarez Sanchez A01194173
 * 10 Feb 2019
 */
public class Assets {
    public static BufferedImage planetOne, planetTwo, background;
    public static SoundClip deathSound;
    /**
     * loads the assets
     */
    public static void init(){
        background = ImageLoader.loadImage("/images/bg.png");
        planetOne = ImageLoader.loadImage("/images/sprite1.png");
        planetTwo = ImageLoader.loadImage("/images/sprite2.png");
        deathSound = new SoundClip("/sounds/death.wav");
        
    }
}
