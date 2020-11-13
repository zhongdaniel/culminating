/*|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 * File: Results_Menu.java
 * Date Created: Oct 30th
 * Co-Authors: Anton Qi and Daniel Zhong
 * Desc: This file's displays to the user the result of the game, and who won/lost
 * |-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Results_Menu extends JPanel implements ActionListener{
	//Variables
	private Color buttonColour;
	private JButton againButton, backButton;
	private ImageIcon bg, playAgain, back, p1, p2, winImg, loseImg;
	private Image againImg, sizedAgain, backImg, sizedBack;
	private int winner;
	
	//Constructor
	public Results_Menu(){
		//Creating Buttons
		playAgain = new ImageIcon("Again_Button.png"); //importing play again image
		againImg = playAgain.getImage();
		sizedAgain = againImg.getScaledInstance(250, 50, java.awt.Image.SCALE_SMOOTH); 
		playAgain = new ImageIcon(sizedAgain);
		
		againButton = new JButton(playAgain); //making play again button
		againButton.setBounds(100, 390, 260, 60);
		againButton.setOpaque(false);
		againButton.setContentAreaFilled(false);
		againButton.setBorderPainted(false);
		
		//making return to home screen button
		back = new ImageIcon("BackMain_Button.png"); //import image
		backImg = back.getImage();
		sizedBack = backImg.getScaledInstance(500, 50, java.awt.Image.SCALE_SMOOTH); 
		back = new ImageIcon(sizedBack);
		
		//make the actual button
		backButton = new JButton(back);
		backButton.setBounds(100, 460, 520, 60);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		
		//import all non-button images
		bg = new ImageIcon("home_background.png");
		p1 = new ImageIcon("WizSprite.png");
		p2 = new ImageIcon("MeguminSprite.png");
		winImg = new ImageIcon("Winner.png");
		loseImg = new ImageIcon("Loser.png");
		
		//define the button's background colour
		buttonColour = new Color(255, 255, 255, 100);
		
		//Adding Listeners
		againButton.addActionListener(this);
		backButton.addActionListener(this);
		
		//Adding Objects
	    this.setLayout(null);
	    this.add(againButton);
	    this.setBackground(Color.CYAN);
		this.add(backButton);
		
	}
	 
	//Custom Events
	public void getWinner(int winner) { //checks and saves winner
		this.winner = winner;
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {
		
		//determines fuctions of buttons
		if (e.getSource() == againButton) 
			Main_Game.restartGameBool = true;
			Main_Game.cardsL.show(Main_Game.c, "Game");
     
		if (e.getSource() == backButton) 
			Main_Game.cardsL.show(Main_Game.c, "Home");

	}
	
	//Draw Component    
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null); //Add Background
			
			g.drawImage(winImg.getImage(), 275, 140, 200, 47, null); //Add Winner Text
			g.drawImage(loseImg.getImage(), 905, 300, 80, 25, null); //Add Loser Text
			
			//determines which sprite to put under winner and loser
			if(winner == 0) { //tie, both sprites are winners
				g.drawImage(p1.getImage(), 300, 200, 112, 180, null);
				g.drawImage(p2.getImage(), 450, 100, 112, 180, null);
			}
			
			else if(winner == 1) { //wiz wins
				g.drawImage(p1.getImage(), 300, 200, 112, 180, null);
				g.drawImage(p2.getImage(), 920, 320, 50, 90, null);
			}
			
			else if(winner == 2) { //megumin wins
				g.drawImage(p2.getImage(), 300, 200, 112, 180, null);
				g.drawImage(p1.getImage(), 920, 320, 50, 90, null);
			}
			
			//adds background for buttons
			g.setColor(buttonColour);
			g.fillRoundRect(100, 390, 260, 55, 10, 10);
			g.fillRoundRect(100, 460, 520, 60, 10, 10);
		}

}
