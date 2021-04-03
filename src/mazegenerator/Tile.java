/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegenerator;

import java.util.ArrayList;

/**
 *
 * @author landr
 */
public class Tile {
    
    private boolean visited;
    private Maze maze;
    private int i;
    private int j;
    private boolean[] walls;//0 UP, 1 RIGHT, 2 DOWN, 3 LEFT
    
    public Tile(Maze maze, int i, int j){
        visited = false;
        this.maze = maze;
        this.i = i;
        this.j = j;
        walls = new boolean[4];
        for(int a = 0; a < 4; a++)
            walls[a] = true;
    }
    
    public boolean isVisited(){
        return visited;
    }
    public void visit(){
        visited = true;
    }
    public void breakWall(int index){
        walls[index] = false;
    }
    public boolean isWall(int index){
        return walls[index];
    }
    
    
    public ArrayList<Tile> getAdyacents(){
        ArrayList<Tile> out = new ArrayList<>();
        if(i > 0)
            out.add(maze.getTile(i-1, j));
        if(i < maze.getWidth()-1)
            out.add(maze.getTile(i+1, j));
        if(j > 0)
            out.add(maze.getTile(i, j-1));
        if(j < maze.getHeight()-1)
            out.add(maze.getTile(i, j+1));
        return out;
    }
    
    public ArrayList<Tile> unNeighbours(){
        ArrayList<Tile> out = new ArrayList<>();
        ArrayList<Tile> aux = getAdyacents();
        for(Tile tile: aux)
            if(!tile.isVisited())
                out.add(tile);
        return out;
    }
    
    
}
