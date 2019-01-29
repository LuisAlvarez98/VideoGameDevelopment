/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author luisf
 */
public class KeyManager implements KeyListener{
    //Flags to move the player
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    
    private boolean keys[]; // to store all the flags for every key
    
    public KeyManager(){
        keys = new boolean[256];
    }
    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    /**
     * to enable or disable moves on every tick
     */
    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }
}

   