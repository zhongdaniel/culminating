import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Pause_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton goGame, goHome;
		
	public Pause_Menu(){  // constructor
		//Creating the Buttons
		goGame = new JButton("     Resume     ");
		goHome = new JButton("     Quit     ");
		    
		//Adding Listeners
		goGame.addActionListener(this);
		goHome.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
		this.setLayout(new FlowLayout());
	    this.setBackground(Color.GREEN);
	    
	    this.add(goGame);
		this.add(goHome);
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {
	    
	    if(e.getSource() == goGame) 
	    	Main_Game.cardsL.last(Main_Game.c);
	    
	    if(e.getSource() == goHome) 
	    	Main_Game.cardsL.first(Main_Game.c);
	}
	    
	//Key Events
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//Draw Component
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
		g.drawString("Game is paused",200,300);
	}
}
