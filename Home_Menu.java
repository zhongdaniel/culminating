import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton goGame;
	private JButton goRules;
	private ImageIcon bg, game, rules, header;
	private Image gameImg, sizedImg, rulesImg, sizeRules;
	
	//Constructor
	public Home_Menu(){
		//Creating the Objects
		game = new ImageIcon("Play_Button.png");
		gameImg = game.getImage();
		sizedImg = gameImg.getScaledInstance(150, 50, java.awt.Image.SCALE_SMOOTH); 
		game = new ImageIcon(sizedImg);
		
		goGame = new JButton(game);
		goGame.setBounds(150, 380, 150, 50);
		goGame.setOpaque(false);
		goGame.setContentAreaFilled(false);
		goGame.setBorderPainted(false);
		
		
		rules = new ImageIcon("Rules_Button.png");
		rulesImg = rules.getImage();
		sizeRules = rulesImg.getScaledInstance(175, 50, java.awt.Image.SCALE_SMOOTH); 
		rules = new ImageIcon(sizeRules);
		
		goRules = new JButton(rules);
		goRules.setBounds(145, 450, 175, 50);
		goRules.setOpaque(false);
		goRules.setContentAreaFilled(false);
		goRules.setBorderPainted(false);
		
		bg = new ImageIcon("home_background.png");
		header = new ImageIcon("Header.png");
		
		//Adding Listeners
		goGame.addActionListener(this);
		goRules.addActionListener(this);
		addKeyListener(this);
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
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			g.drawImage(header.getImage(), 100, 200, 600, 80, null);
			
			
			g.setFont(new Font("Garamond", Font.BOLD, 30));
			
			
		}

}
