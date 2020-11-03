import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Rules_Menu extends JPanel implements ActionListener, KeyListener{
 //Variables
 private JButton goHome;
 private ImageIcon bg;
 
 public Rules_Menu(){  // constructor
  //Creating the Buttons
  goHome = new JButton("Go back");
  goHome.setFont(new Font("Garamond", Font.BOLD, 16));
  goHome.setBounds(100, 400, 200, 35);
  goHome.setBackground(new Color(227, 88, 64));
  
  bg = new ImageIcon("Rules_Background.png");
  
  //Adding Listeners
  goHome.addActionListener(this);
  addKeyListener(this);
  
  //Adding Objects
  this.setLayout(null);
  this.setBackground(Color.white);
  this.add(goHome);
         
 }    
  
 //Action Events
 public void actionPerformed(ActionEvent e) {
  if(e.getSource() == goHome) 
   Main_Game.cardsL.show(Main_Game.c, "Home");
   
 }
  
 //Key Events
 public void keyPressed( KeyEvent e ) {
     
  if(e.getKeyCode() == 27)// 27 is escape
   Main_Game.cardsL.show(Main_Game.c, "Home");
 }

 public void keyTyped(KeyEvent e) {
  // TODO Auto-generated method stub
  
 }

 public void keyReleased(KeyEvent e) {
  // TODO Auto-generated method stub
  
 }
 
 //Draw Component
 public void paintComponent(Graphics g) {
  
  super.paintComponent(g);
  
  //add background
  g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
  
  g.fillRect(80, 175, 300, 140);

  g.fillRect(720, 175, 300, 140);
  g.setColor(java.awt.Color.black);
  
    
  g.setFont(new Font("Garamond", Font.BOLD+Font.ITALIC,  18));
  g.setColor(java.awt.Color.white);
  
  
  g.drawString("Instructions:",100,200);  
  g.drawString("Player 1 Controls:",100,225);   
  g.drawString("Move Character - WASD",100,250);   
  g.drawString("Attack - Q",100,275);   
  g.drawString("Use Special Ability - E", 100, 300);
  g.drawString("Player 2 Controls:",740,225);   
  g.drawString("Move Character - IJKL",740,250);   
  g.drawString("Attack - U",740,275);   
  g.drawString("Use Special Ability - O", 740, 300);
 
 }
 
 
}
