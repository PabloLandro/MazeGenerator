/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegenerator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author landr
 */
public class SettingsFrame extends JFrame{
    
    final static int WIDTH = 150;
    final static int HEIGHT = 150;
    
    private JTextField widthField;
    private JTextField heightField;
    private JButton closeButton;
    
    private Frame frame;
    
    public SettingsFrame(Frame frame){
        this.frame = frame;
        setUpComponents();
        addComponents();
        setUp();
    }
    
    private void setUpComponents(){
        widthField = new JTextField("" + frame.getSelectedWidth());
        heightField = new JTextField("" + frame.getSelectedWidth());
        closeButton = new JButton("Apply");
        widthField.setPreferredSize(new Dimension(50, widthField.getFont().getSize()+10));
        heightField.setPreferredSize(new Dimension(50, heightField.getFont().getSize()+10));
        closeButton.addActionListener((e)->applyChanges());
    }
    
    private void addComponents(){
        this.getContentPane().add(widthField);
        this.getContentPane().add(heightField);
        this.getContentPane().add(closeButton);
    }
    
    private void setUp(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void applyChanges(){
        frame.setSelectedWidth(Integer.parseInt(widthField.getText()));
        frame.setSelectedHeight(Integer.parseInt(heightField.getText()));
        this.dispose();
    }
    
}
