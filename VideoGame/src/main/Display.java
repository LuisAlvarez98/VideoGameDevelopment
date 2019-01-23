/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author luisf
 */
public class Display {
    private JFrame jframe;
    private Canvas canvas;
    private String title;
    private int width;
    private int height;
    
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    public JFrame getJframe() {
        return jframe;
    }

    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
        public void createDisplay(){
        jframe = new JFrame(title);
        
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        jframe.add(canvas);
        jframe.pack();
    }
    
}
