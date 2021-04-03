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
public class Maze {
    
    private int WIDTH = 20;
    private int HEIGHT = 20;
    private ArrayList<Tile> map;
    
    public Maze(int WIDTH, int HEIGHT){
        map = new ArrayList<>();
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        initMap();
    }
    
    private void initMap(){
        for(int j = 0; j < HEIGHT; j++){
            for(int i = 0; i < WIDTH; i++){
                map.add(new Tile(this, i, j));
            }
        }
    }
    
    public Tile getTile(int i, int j){
        if(i > WIDTH || i < 0 || j > HEIGHT || j < 0)
            return null;
        return map.get(i + WIDTH*j);
    }
    
    public int getX(Tile tile){
        return map.indexOf(tile)%HEIGHT;
    }
    public int getY(Tile tile){
        return (int)map.indexOf(tile)/WIDTH;
    }
    public int getWidth(){
        return WIDTH;
    }
    public int getHeight(){
        return HEIGHT;
    }
    
    public String print(){
        String out = new String();
        for(int row = 0; row < HEIGHT; row++){
            out += topLine(row);
            out += middleLine(row);
        }
        out += bottomLine(HEIGHT-1);
        return out;
    }
    
    private String topLine(int row){
        String out = new String("");
        for(int index = row*WIDTH; index < (row+1)*WIDTH; index++){
            if(map.get(index).isWall(3) || map.get(index).isWall(0) || (index > 0 && map.get(Math.max(index-1, 0)).isWall(0)))
                out += "1,";
            else
                out += "0,";
            if(map.get(index).isWall(0))
                out += "1,";
            else
                out += "0,";
        }
        if(map.get(((row+1)*WIDTH)-1).isWall(0) ||map.get(((row+1)*WIDTH)-1).isWall(1))
            out += "1,";
        else
            out += "0,";
        return out;
    }
    private String middleLine(int row){
        String out = new String("");
        for(int index = row*WIDTH; index < (row+1)*WIDTH; index++){
            if(map.get(index).isWall(3))
                out += "1,";
            else
                out += "0,";
            out += "0,";
        }
        if(map.get(((row+1)*WIDTH)-1).isWall(1))
            out += "1,";
        else
            out += "0,";
        return out;
    }
    private String bottomLine(int row){
        String out = new String("");
        for(int index = row*WIDTH; index < (row+1)*WIDTH; index++){
            if(map.get(index).isWall(3) || map.get(index).isWall(2))
                out += "1,";
            else
                out += "0,";
            if(map.get(index).isWall(2))
                out += "1,";
            else
                out += "0,";
        }
        if(map.get(((row+1)*WIDTH)-1).isWall(2) || map.get(((row+1)*WIDTH)-1).isWall(1))
            out += "1,";
        else
            out += "0,";
        return out;
    }
    
}
