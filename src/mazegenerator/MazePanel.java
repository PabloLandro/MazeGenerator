/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegenerator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author landr
 */
public class MazePanel extends JPanel{
    
    private final static int PANEL_WIDTH = 500;
    private final static int PANEL_HEIGHT = 500;
    
    private int mazeWidth;
    private int mazeHeight;
    private int[] maze;
    
    public MazePanel(){
        setUp();
    }
    private void setUp(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        clear();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawMaze(g);
    }
    private void drawMaze(Graphics g){
        int size = (mazeWidth > mazeHeight) ? PANEL_WIDTH/mazeWidth: PANEL_HEIGHT/mazeHeight;
        g.setColor(Color.green);
        for(int i = 0; i < maze.length; i++){
            if(maze[i] == 1){
                int x = (int)(PANEL_WIDTH-(size*mazeWidth))/2 + size*(i%mazeWidth);
                int y = (int)(PANEL_HEIGHT-(size*mazeHeight))/2 + size*(i/mazeHeight);
                //int x = size*(i%mazeWidth);
                //int y = size*(i/mazeHeight);   
                g.fillRect(x, y, size, size);
            }
        }
    }
    
    public void setMaze(int[] maze, int width, int height){
        this.maze = maze;
        this.mazeWidth = width;
        this.mazeHeight = height;
        repaint();
    }
    
    public void clear(){
        int[] aux = {0};
        setMaze(aux, 1, 1);
    }
    
}
