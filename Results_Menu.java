  
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Results_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private Color buttonColour;
	private JButton againButton, backButton;
	private ImageIcon bg, playAgain, back, p1, p2;
	private Image againImg, sizedAgain, backImg, sizedBack;
	private int winner;
	
	//Constructor
	public Results_Menu(){
		//Creating the Objects
		playAgain = new ImageIcon("Again_Button.png");
		againImg = playAgain.getImage();
		sizedAgain = againImg.getScaledInstance(250, 50, java.awt.Image.SCALE_SMOOTH); 
		playAgain = new ImageIcon(sizedAgain);
		
		againButton = new JButton(playAgain);
		againButton.setBounds(100, 390, 260, 60);
		againButton.setOpaque(false);
		againButton.setContentAreaFilled(false);
		againButton.setBorderPainted(false);
		
		back = new ImageIcon("BackMain_Button.png");
		backImg = back.getImage();
		sizedBack = backImg.getScaledInstance(500, 50, java.awt.Image.SCALE_SMOOTH); 
		back = new ImageIcon(sizedBack);
		
		backButton = new JButton(back);
		backButton.setBounds(100, 460, 520, 60);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		
		bg = new ImageIcon("home_background.png");
		p1 = new ImageIcon("WizSprite.png");
		p2 = new ImageIcon("MeguminSprite.png");
		
		buttonColour = new Color(255, 255, 255, 100);
		
		//Adding Listeners
		againButton.addActionListener(this);
		backButton.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
	    this.setLayout(null);
	    this.add(againButton);
	    this.setBackground(Color.CYAN);
		this.add(backButton);
		
	}
	 
	//Custom Events
	public void getWinner(int winner) {
		this.winner = winner;
	}
	
	//Key Events
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
					
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
					
	}
				
	public void keyPressed( KeyEvent e ) {
					  
			
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == againButton) 
			Main_Game.restartGameBool = true;
			Main_Game.cardsL.show(Main_Game.c, "Game");
     
		if (e.getSource() == backButton) 
			Main_Game.cardsL.show(Main_Game.c, "Home");

	}
	
	//Draw Component    
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			
			if(winner == 0) {
				g.drawImage(p1.getImage(), 300, 100, 112, 180, null);
				g.drawImage(p2.getImage(), 450, 100, 112, 180, null);
			}
			else if(winner == 1) {
				g.drawImage(p1.getImage(), 300, 100, 112, 180, null);
				g.drawImage(p2.getImage(), 920, 320, 50, 90, null);
			}
			else if(winner == 2) {
				g.drawImage(p2.getImage(), 300, 100, 112, 180, null);
				g.drawImage(p1.getImage(), 920, 320, 50, 90, null);
			}
			
			g.setColor(buttonColour);
			g.fillRoundRect(100, 390, 260, 55, 10, 10);
			g.fillRoundRect(100, 460, 520, 60, 10, 10);
		}

}
