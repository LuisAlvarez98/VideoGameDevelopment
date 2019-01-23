/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicwindow;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author luisf
 */
public class BasicWindow extends JFrame{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Window init
        JFrame jframe = new JFrame("Ejemplo");
        jframe.setVisible(true);
        jframe.setResizable(true);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe.setSize(500,500);
        
        
    }
    
}
