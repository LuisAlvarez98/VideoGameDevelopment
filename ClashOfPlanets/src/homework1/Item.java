package homework1;

import java.awt.Graphics;

/**
 * Item Class
 * @author Luis Felipe Alvarez Sanchez A01194173
 * 4 Feb 2019
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
