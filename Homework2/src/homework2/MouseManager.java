/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author luisf
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    private boolean izquierdo;
    private boolean derecho;
    private int x;
    private int y;
    
    public MouseManager(){
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isIzquierdo(){
        return izquierdo;
    }
    public boolean isDerecho(){
        return derecho;
    }
    public void setIzquierdo(boolean izquierdo){
        this.izquierdo = izquierdo;
    }
    public void setDerecho(boolean derecho){
        this.derecho = derecho;
    }
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
         if(e.getButton() == MouseEvent.BUTTON1){
            izquierdo = true;
            System.out.println("pressed");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
           if(e.getButton() == MouseEvent.BUTTON1){
            izquierdo = false;
            x = e.getX();
            y = e.getY();
            System.out.println("releases");
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            izquierdo = true;
            x = e.getX();
            y = e.getY();
            System.out.println("dragged");
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
    
    
}
