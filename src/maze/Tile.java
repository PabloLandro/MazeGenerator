/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;

/**
 *
 * @author landr
 */
public class Tile{
    
    private int x,y;
    private boolean visited, wall;
    
    Tile(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setWall(){
        visited = true;
        wall = true;
    }
    
    public void setFloor(){
        visited = true;
    }
    
    public boolean isWall(){
        return wall;
    }
    public boolean isVisited(){
        return visited;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    
    
    
}
