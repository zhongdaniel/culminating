import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home_Menu extends JPanel implements ActionListener{
	//Variables
	private Color buttonColour;
	private JButton goGame;
	private JButton goRules;
	private ImageIcon bg, game, rules, header;
	private Image gameImg, sizedImg, rulesImg, sizeRules;
	
	//Constructor
	public Home_Menu(){
		
		//Creating the Play Button
		game = new ImageIcon("Play_Button.png"); //Importing the Button's Image and Resizing
		gameImg = game.getImage();
		sizedImg = gameImg.getScaledInstance(150, 50, java.awt.Image.SCALE_SMOOTH); 
		game = new ImageIcon(sizedImg);
		
		goGame = new JButton(game); //Turning the image into a button
		goGame.setBounds(210, 400, 190, 90); //Setting button size and location
		goGame.setOpaque(false);
		goGame.setContentAreaFilled(false);
		goGame.setBorderPainted(false);
		
		//Creating the Rules Button
		rules = new ImageIcon("Rules_Button.png"); //Importing the Button's Image and Resizing
		rulesImg = rules.getImage();
		sizeRules = rulesImg.getScaledInstance(175, 50, java.awt.Image.SCALE_SMOOTH); 
		rules = new ImageIcon(sizeRules);
		
		goRules = new JButton(rules); //Turning the image into a button
		goRules.setBounds(220, 500, 190, 90); //Setting button size and location
		goRules.setOpaque(false);
		goRules.setContentAreaFilled(false);
		goRules.setBorderPainted(false);
		
		//Importing the Images for the Title and Background
		bg = new ImageIcon("home_background.png"); //Background
		header = new ImageIcon("Header.png"); //TItle
		
		//Add colour presets for buttons
		buttonColour = new Color(153, 238, 255, 150);
		
		//Adding Objects
	    this.setLayout(null);
	    this.add(goGame);
	    this.setBackground(Color.CYAN);
		this.add(goRules);
		
		//listens for mouse clicks on buttons
		goGame.addActionListener(this);
        goRules.addActionListener(this);
		
		//Resetting the game
		Main_Game.restartGameBool = true;
		
	}
	    	
	//Action Events
	public void actionPerformed(ActionEvent e) {

		//if the rules button is clicked, goes to the rules
		if(e.getSource() == goRules) 
			Main_Game.cardsL.show(Main_Game.c, "Rules"); 
		
		//if the play button is clicked, goes to the game
		if(e.getSource() == goGame) {
			Main_Game.cardsL.show(Main_Game.c, "Game");
		}
	}
	
	//Draw Component    
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			//Add the background image
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			
			//Add the title
			g.drawImage(header.getImage(), 70, 100, 800, 100, null);
			
			//Create backgrounds for the buttons
			g.setColor(buttonColour); //set 
			g.fillRoundRect(220, 400, 170, 90, 50, 50);
			g.fillRoundRect(220, 500, 190, 90, 50, 50);
			
			
		}

}
