import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home_Menu extends JPanel implements ActionListener, KeyListener{
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
		goGame.setBounds(210, 360, 190, 90); //Setting button size and location
		goGame.setOpaque(false);
		goGame.setContentAreaFilled(false);
		goGame.setBorderPainted(false);
		
		//Creating the Rules Button
		rules = new ImageIcon("Rules_Button.png"); //Importing the Button's Image and Resizing
		rulesImg = rules.getImage();
		sizeRules = rulesImg.getScaledInstance(175, 50, java.awt.Image.SCALE_SMOOTH); 
		rules = new ImageIcon(sizeRules);
		
		goRules = new JButton(rules); //Turning the image into a button
		goRules.setBounds(220, 460, 190, 90); //Setting button size and location
		goRules.setOpaque(false);
		goRules.setContentAreaFilled(false);
		goRules.setBorderPainted(false);
		
		//Importing the Images for the Title and Background
		bg = new ImageIcon("home_background.png"); //Background
		header = new ImageIcon("Header.png"); //TItle
		
		//Add colour presets for buttons
		buttonColour = new Color(255, 255, 255, 100);
		
		//Adding Listeners
		goGame.addActionListener(this);
		goRules.addActionListener(this);
		goGame.addKeyListener(this);
		goRules.addKeyListener(this);
		
		
		//Adding Objects
	    this.setLayout(null);
	    this.add(goGame);
	    this.setBackground(Color.CYAN);
		this.add(goRules);
		
		//Resetting the game
		Main_Game.restartGameBool = true;
		
	}
	    	
	//Key Events
	public void keyTyped(KeyEvent e) {
					
	}

	public void keyReleased(KeyEvent e) {
					
	}
				
	public void keyPressed( KeyEvent e ) {
		if(e.getKeyCode()==13) { // 13 is enter
			Main_Game.cardsL.show(Main_Game.c, "Game"); 
	
		}
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == goRules) 
			Main_Game.cardsL.show(Main_Game.c, "Rules"); 
		    	
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
			g.setColor(buttonColour);
			g.fillRoundRect(220, 375, 170, 65, 10, 10);
			g.fillRoundRect(220, 470, 190, 65, 10, 10);
			
			
		}

}
