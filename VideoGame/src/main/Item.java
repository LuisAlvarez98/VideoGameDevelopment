/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;

/**
 *
 * @author luisf
 */
public abstract class Item {
    protected int x;
    protected int y;
    /**
     * 
     * @param x
     * @param y 
     */
    public Item(int x, int y){
        this.x = x;
        this.y = y;
    }
    /**
     * 
     */
    public abstract void tick();
    /**
     * 
     * @param g 
     */
    public abstract void render(Graphics g);
    /**
     * 
     * @return 
     */
    public int getX() {
        return x;
    }
    /**
     * 
     * @return 
     */
    public int getY() {
        return y;
    }
    /**
     * 
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * 
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    
}
