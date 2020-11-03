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
		goGame.setFont(new Font("Garamond", Font.BOLD, 16));
		goGame.setBounds(100, 375, 200, 25);
		goGame.setBackground(new Color(227, 88, 64));
		
		goRules = new JButton("     Go to rules panel     ");
		goRules.setFont(new Font("Garamond", Font.BOLD, 16));
		goRules.setBounds(100, 450, 200, 25);
		goRules.setBackground(new Color(227, 88, 64));
		bg = new ImageIcon("home_background.png");
		
		//Adding Listeners
		goGame.addActionListener(this);
		goRules.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
	    this.setLayout(null);
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
			
			
			g.setFont(new Font("Garamond", Font.BOLD, 30));
			g.drawString("Konosuba: The Game", 100, 300);
			
			
		}

}
