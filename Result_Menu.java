import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Result_Menu extends JPanel implements ActionListener, KeyListener{
 private JButton goHome;
 private JButton goGame;
  
  
 public Result_Menu() {
  //Creating the objects
  goHome = new JButton(" Return to Main Menu ");
     goGame = new JButton("     Play Again     ");
     
     //Adding Listeners
  goHome.addActionListener(this);
     goGame.addActionListener(this);
     this.setLayout(null);
         
     //Adding Objects
     this.add(goGame);
     this.add(goHome);
     this.setBackground(Color.GREEN);
  
 }
 
 //Key Events
 public void keyTyped(KeyEvent e) {
  // TODO Auto-generated method stub
     
 }

 public void keyReleased(KeyEvent e) {
  // TODO Auto-generated method stub
     
 }
    
 public void keyPressed(KeyEvent e) {
    
    
 }
 
 //Action Events
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == goGame) 
   Main_Game.cardsL.show(Main_Game.c, "Game");
   
  if (e.getSource() == goHome)
   Main_Game.cardsL.show(Main_Game.c, "Home");
  
 }
 
 //Draw Component
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
  g.drawString("Welcome to ~~Summoner's Rift~~ Konosuba: the ripoff",100,200);
   }

 
}
