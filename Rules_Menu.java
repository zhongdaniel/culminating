/*|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 * File: Main_Game.java
 * Date Created: Oct 31st
 * Co-Authors: Anton Qi and Daniel Zhong
 * Desc: This file's code displays how to play the game, and the controls for each player
 * |-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Rules_Menu extends JPanel implements ActionListener{
	//Variables
	private JButton backButton;
	private ImageIcon bg, back, header;
	private Image backImg, sizedBack;
	private Color textColour, buttonColour;
	
	public Rules_Menu(){  // constructor
		
		//Importing the back button
		back = new ImageIcon("Back_Button.png");
		backImg = back.getImage();
		sizedBack = backImg.getScaledInstance(170, 40, java.awt.Image.SCALE_SMOOTH); 
		back = new ImageIcon(sizedBack);
		
		//Creating the back button
		backButton = new JButton(back);
		backButton.setBounds(100, 537, 170, 40);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
  
		//Adding Background
		bg = new ImageIcon("Rules_Background.png");
		header = new ImageIcon("Instructions.png");
  
		//Adding Listeners
		backButton.addActionListener(this);
		
		//Setting colour presets for buttons
		textColour = new Color(88, 88, 88, 200);
		buttonColour = new Color(255, 255, 255, 200);
  
		//Adding Objects
		this.setLayout(null);
		this.setBackground(Color.white);
		this.add(backButton);
         
	}    
  
	//Action Events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) //returns to home page
			Main_Game.cardsL.show(Main_Game.c, "Home");
		
	}
 
	//Draw Component
	public void paintComponent(Graphics g) {
  
		super.paintComponent(g);
  
		//add background
		g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		
		//Add the Header
		g.drawImage(header.getImage(), 90, 40, 400, 70, null);
		
		//Create Translucent Background for Text
		g.setColor(textColour);
		g.fillRoundRect(80, 120, 300, 110, 30, 30);
		g.fillRoundRect(720, 120, 300, 110, 30, 30);
		g.fillRoundRect(80, 270, 1050, 210, 30, 30);
		
		//Set and added Translucent Background Colour for Button
		g.setColor(buttonColour);
		g.fillRoundRect(90, 525, 200, 60, 30, 30);
    
		//Sets Fonts
		g.setFont(new Font("Arial", Font.BOLD,  18));
		g.setColor(java.awt.Color.white);
  
		//Shows Player 1 Keys
		g.drawString("Player 1 Controls:",100,140);   
		g.drawString("Jump - W",100,160);   
		g.drawString("Move Left - A",100,180);  
		g.drawString("Move Right - D",100,200);   
		g.drawString("Attack - Q",100,220);   
		
		//Shows Player 2 Keys
		g.drawString("Player 2 Controls:",740,140);  
		g.drawString("Jump - I",740,160);  
  		g.drawString("Move Left - J",740,180);   
  		g.drawString("Move Right - L",740,200);   
  		g.drawString("Attack - U",740,220);   

  		//Shows Introduction
  		g.drawString("Hello and Welcome to Konosuba the game!",100,300);
  		g.drawString("Our game is based off the popular anime series, Kono Subarashii, commonly known as Konosuba!",100,320);
  		g.drawString("In this 1-on-1 PvP game, you can face off with your opponents through either Megumin, or Wiz!",100,340);
  		g.drawString("You will be able to shoot Aqua Projectiles, up to 3 at a time. Your ammo will be displayed on the bottom of the screen.",100,360);
  		g.drawString("Your ammo will automatically reload once your Aqua Projectiles either hit an opponent or is out of sight.",100,380);
  		g.drawString("Also, no need to worry about running out or aiming, as your projectiles will keep reloading until the round ends, and ",100,400);
  		g.drawString("auto-shoots to whichever side of you the enemy is on", 100, 420);
  		g.drawString("Each player has 300 health, and each projectile does 15 damage.",100,440);
  		g.drawString("Have fun playing!",100,460);
 
 }
 
 
}
