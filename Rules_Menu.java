import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Rules_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton backButton;
	private ImageIcon bg, back, header1;
	private Image backImg, sizedBack;
	private Color bgColour;
	
	public Rules_Menu(){  // constructor
		//Creating the Back Button
		back = new ImageIcon("Back_Button.png");
		backImg = back.getImage();
		sizedBack = backImg.getScaledInstance(150, 40, java.awt.Image.SCALE_SMOOTH); 
		back = new ImageIcon(sizedBack);
		backButton = new JButton(back);
		backButton.setBounds(100, 600, 150, 40);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
  
		//Adding Background
		bg = new ImageIcon("Rules_Background.png");
		header1 = new ImageIcon("Instructions.png");
  
		//Adding Listeners
		backButton.addActionListener(this);
		addKeyListener(this);
		
		//Adding box background colour
		bgColour = new Color(88, 88, 88, 200);
  
		//Adding Objects
		this.setLayout(null);
		this.setBackground(Color.white);
		this.add(backButton);
         
	}    
  
	//Action Events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) 
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
  
		g.setColor(bgColour);
		g.fillRoundRect(80, 120, 300, 110, 30, 30);
		g.fillRoundRect(720, 120, 300, 110, 30, 30);
		g.fillRoundRect(80, 270, 1050, 190, 30, 30);
		
		g.drawImage(header1.getImage(), 90, 40, 400, 70, null);
    
		g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC,  18));
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
  		
  		g.setFont(new Font("Arial", Font.BOLD,  18));
  		//Shows Introduction
  		g.drawString("Hello and Welcome to Konosuba the game!",100,300);
  		g.drawString("Our game is based off the popular anime series, Kono Subarashii, commonly known as Konosuba!",100,320);
  		g.drawString("In this 1-on-1 PvP game, you can face off with your opponents through either Megumin, or Wiz!",100,340);
  		g.drawString("You will be able to shoot Aqua Projectiles, up to 3 at a time. Your ammo will be displayed on the bottom of the screen.",100,360);
  		g.drawString("Your ammo will automatically reload once your Aqua Projectiles either hit an opponent or is out of sight.",100,380);
  		g.drawString("Also, no need to worry about running out, as your projectiles will keep reloading until the round ends!",100,400);
  		g.drawString("Each player has 300 health, and each projectile does 15 damage.",100,420);
  		g.drawString("Have fun playing!",100,440);
 
 }
 
 
}
