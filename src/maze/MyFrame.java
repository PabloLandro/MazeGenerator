/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import javax.swing.JFrame;

/**
 *
 * @author landr
 */
public class MyFrame extends JFrame{
    
    MyFrame(){
        setUpComponents();
        addComponents();
        setUp();
    }
    
    private void setUp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    private void setUpComponents(){
        
    }
    
    private void addComponents(){
        this.add(new MazePanel());
    }
    
}
