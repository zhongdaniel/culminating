import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Rules_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton goHome;
	
	public Rules_Menu(){  // constructor
		//Creating the Buttons
		goHome = new JButton("     Ok     ");
		
		//Adding Listeners
		goHome.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
		this.setLayout(new FlowLayout());
		this.setBackground(Color.white);

		this.add(goHome);
		       
	}	   
		
	//Action Events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == goHome) 
	    	Main_Game.cardsL.first(Main_Game.c);
			
	}
		
	//Key Events
	public void keyPressed( KeyEvent e ) {
			  
		if(e.getKeyCode()==27)// 27 is escape
		     Main_Game.cardsL.first(Main_Game.c);
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
		g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));  
		g.drawString("Instructions:",100,200);  
		g.drawString("Player 1 Controls:",100,225);   
		g.drawString("Move Character - WASD",100,250);   
		g.drawString("Attack - Q",100,275);   
		g.drawString("Use Special Ability - E", 100, 300);
		g.drawString("Player 2 Controls:",740,225);   
		g.drawString("Move Character - IJKL",740,250);   
		g.drawString("Attack - U",740,275);   
		g.drawString("Use Special Ability - O", 740, 300);
	}
	
	
}// end of MyMenuPanel class