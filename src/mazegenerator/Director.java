/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegenerator;

import java.io.*;
import java.util.Random;

/**
 *
 * @author landr
 */
public class Director {
    
    private final static int initX = 5;
    private final static int initY = 19;
    
    
    Maze maze;
    Random random;
    
    public Director(){
        random = new Random();
    }
    
    public void generate(int width, int height){
        maze = new Maze(width, height);
        maze.getTile(0, random.nextInt(height)).breakWall(3);
        algorithm(maze.getTile(0, random.nextInt(height)));
    }
    
    private void algorithm(Tile tile){
        tile.visit();
        while(!tile.unNeighbours().isEmpty()){
            Tile chosen = tile.unNeighbours().get(random.nextInt(tile.unNeighbours().size()));
            breakWall(tile, chosen);
            algorithm(chosen);
        }
    }
    
    public int[] getMaze(){
        String[] parts = maze.print().split(",");
        int[] out = new int[parts.length];
        for(int i = 0; i < parts.length; i++)
            out[i] = Integer.parseInt(parts[i]);
        return out;
    }
    
    public int getMazeWidth(){
        return 2*maze.getWidth()+1;
    }
    public int getMazeHeight(){
        return 2*maze.getHeight()+1;
    }
    
    public void saveMaze(File file){
        try{
            PrintWriter printWriter = new PrintWriter(file);
            int[] maze = this.getMaze();
            printWriter.println("" + this.getMazeWidth() + "," + this.getMazeHeight() + ",20");
            for(int j = 0; j < this.getMazeHeight(); j++){
                for(int i = 0; i < this.getMazeWidth(); i++){
                    printWriter.print(maze[i+j*this.getMazeWidth()]);
                    if(i != this.getMazeWidth()-1)
                        printWriter.print(",");
                    else
                        printWriter.print("\n");
                }
            }
            printWriter.print("1,0,1,0");
            printWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void breakWall(Tile tile1, Tile tile2){
        int x1 = maze.getX(tile1), y1 = maze.getY(tile1);
        int x2 = maze.getX(tile2), y2 = maze.getY(tile2);
        if(x1 < x2){
            tile1.breakWall(1);
            tile2.breakWall(3);
        }
        else if(x1 > x2){
            tile1.breakWall(3);
            tile2.breakWall(1);
        }
        else if(y1 < y2){
            tile1.breakWall(2);
            tile2.breakWall(0);
        }
        else if(y1 > y2){
            tile1.breakWall(0);
            tile2.breakWall(2);
        }
    }
    
}
