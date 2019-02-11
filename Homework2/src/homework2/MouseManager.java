package homework2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * MouseManager Class
 * @author Luis Felipe Alvarez Sanchez A01194173
 * 10 Feb 2019
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    //Instance variables
    private boolean izquierdo;
    private boolean derecho;
    private int x;
    private int y;
    
    private boolean dragged;
    /**
     * MouseManager constructor
     */
    public MouseManager(){}
    /**
     * getX method
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * getY method
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * setX method
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * setY method
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * isIzquierdo method
     * @return izquierdo
     */
    public boolean isIzquierdo(){
        return izquierdo;
    }
    /**
     * isDerecho method
     * @return derecho
     */
    public boolean isDerecho(){
        return derecho;
    }
    /**
     * setIzquierdo method
     * @param izquierdo 
     */
    public void setIzquierdo(boolean izquierdo){
        this.izquierdo = izquierdo;
    }
    /**
     * setDerecho method
     * @param derecho 
     */
    public void setDerecho(boolean derecho){
        this.derecho = derecho;
    }
    /**
     * mouseClicked method
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    /**
     * mousePressed method
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
        /* if(e.getButton() == MouseEvent.BUTTON1){
            izquierdo = true;
            System.out.println("pressed");
        }*/
        
    }
    /**
     * mouseReleased method
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
          dragged = false;
    }
    /**
     * mouseEntered method
     * @param me 
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }
    /**
     * mouseExited method
     * @param me 
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }
    /**
     * mouseDragged method
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e) {
            dragged = true;
            x = e.getX();
            y = e.getY();
    }
    /**
     * mouseMoved method
     * @param me 
     */
    @Override
    public void mouseMoved(MouseEvent me) {
    }
    /**
     * isDragged method
     * @return dragged
     */
    boolean isDragged() {
        return dragged;
    }
}
