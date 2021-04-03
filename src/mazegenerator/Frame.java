/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegenerator;

import javax.swing.*;

/**
 *
 * @author landr
 */
public class Frame extends JFrame{
    
    private MazePanel panel;
    
    private JMenuBar menuBar;
    private JMenu mazeMenu;
    private JMenu editMenu;
    private JMenuItem newMaze;
    private JMenuItem saveMaze;
    private JMenuItem clear;
    private JMenuItem settings;
    
    private Director director;
    
    private int selectedWidth = 20, selectedHeight = 20;
    
    public Frame(){
        director = new Director();
        setUpComponents();
        addComponents();
        setUp();
    }
    
    private void setUpComponents(){
        panel = new MazePanel();
        setUpMenuBar();
        setUpMenuActionListeners();
    }
    
    private void addComponents(){
        this.setJMenuBar(menuBar);
        this.add(panel);
    }
    private void setUp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void setUpMenuBar(){
        menuBar = new JMenuBar();
        mazeMenu = new JMenu("Maze");
        editMenu = new JMenu("Edit Maze");
        newMaze = new JMenuItem("New Maze");
        saveMaze = new JMenuItem("Save Maze");
        clear = new JMenuItem("Clear");
        settings = new JMenuItem("Settings");
        
        mazeMenu.add(newMaze);
        mazeMenu.add(saveMaze);
        editMenu.add(clear);
        editMenu.add(settings);
        
        menuBar.add(mazeMenu);
        menuBar.add(editMenu);
    }
    private void setUpMenuActionListeners(){
        newMaze.addActionListener((e)->{
           director.generate(selectedWidth, selectedHeight);
           panel.setMaze(director.getMaze(), director.getMazeWidth(), director.getMazeHeight());
        });
        saveMaze.addActionListener((e)->saveMaze());
        clear.addActionListener((e)->panel.clear());
        settings.addActionListener((e)->new SettingsFrame(this));
    }
    
    private void saveMaze(){
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showSaveDialog(this);
        if(response == JFileChooser.APPROVE_OPTION){
            director.saveMaze(fileChooser.getSelectedFile());
        }
    }

    public int getSelectedWidth() {
        return selectedWidth;
    }
    public void setSelectedWidth(int selectedWidth) {
        this.selectedWidth = selectedWidth;
    }
    public int getSelectedHeight() {
        return selectedHeight;
    }
    public void setSelectedHeight(int selectedHeight) {
        this.selectedHeight = selectedHeight;
    }
    
    
    
}
