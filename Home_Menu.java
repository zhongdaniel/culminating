import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton goGame;
	private JButton goRules;
	private ImageIcon bg;
	
	//Constructor
	public Home_Menu(){
		//Creating the Objects
		goGame = new JButton("     Go to game panel     ");
		goRules = new JButton("     Go to rules panel     ");
		bg = new ImageIcon("home_background.png");
		
		//Adding Listeners
		goGame.addActionListener(this);
		goRules.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
	    this.setLayout(new FlowLayout());
	    this.add(goGame);
	    this.setBackground(Color.CYAN);
		this.add(goRules);
		
	}
	    	
	//Key Events
	public void keyTyped(KeyEvent e) {
					
	}

	public void keyReleased(KeyEvent e) {
					
	}
				
	public void keyPressed( KeyEvent e ) {
					  
		if(e.getKeyCode()==13) // 13 is enter
			Main_Game.cardsL.last(Main_Game.c); //Game Frame
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == goRules) 
			Main_Game.cardsL.next(Main_Game.c); 
		    	
		if(e.getSource() == goGame) 
			Main_Game.cardsL.last(Main_Game.c);
	}
	
	//Draw Component    
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			
			
			g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
			g.drawString("Welcome to ~~Summoner's Rift~~ Konosuba: the ripoff", 100, 200);
			
			
		}

}