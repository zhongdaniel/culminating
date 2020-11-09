  
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Results_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton goHome;
	private JButton goGame;
	private ImageIcon bg;
	private String winner;
	
	//Constructor
	public Results_Menu(){
		//Creating the Objects
		goGame = new JButton("     Play Again     ");
		goHome = new JButton("    Back to Main Menu    ");
		bg = new ImageIcon("home_background.png");
		
		//Adding Listeners
		goGame.addActionListener(this);
		goHome.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
	    this.setLayout(new FlowLayout());
	    this.add(goGame);
	    this.setBackground(Color.CYAN);
		this.add(goHome);
		
	}
	 
	//Custom Events
	public void getWinner(String winner) {
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
		
		if (e.getSource() == goGame) 
			Main_Game.cardsL.show(Main_Game.c, "Game");
     
		if (e.getSource() == goHome) 
			Main_Game.cardsL.show(Main_Game.c, "Home");

	}
	
	//Draw Component    
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			
			
			g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
			g.drawString(winner, 540, 360);
			
			
		}

}
