/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author landr
 */
public class MazePanel extends JPanel{
    
    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    
    
    
    
    
    MazePanel(){
        setUp();
    }
    
    private void setUp(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
    }
    
}
