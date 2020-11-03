import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Pause_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton playButton, goHome;
	private ImageIcon play;
	private Image playImg, sizedImg;
		
	public Pause_Menu(){  // constructor
		//Creating the Buttons
		play = new ImageIcon("Play.png");
		playImg = play.getImage();
		sizedImg = playImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); 
		play = new ImageIcon(sizedImg);
		playButton = new JButton(play);
		playButton.setBounds(1200, 10, 50, 50);
		playButton.setOpaque(false);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		goHome = new JButton("     Quit     ");
		goHome.setBounds(100, 350, 200, 35);
		goHome.setBackground(new Color(227, 88, 64));
		    
		//Adding Listeners
		playButton.addActionListener(this);
		goHome.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
		this.setLayout(null);
	    this.setBackground(Color.GREEN);
	    
	    this.add(playButton);
		this.add(goHome);
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {
	    
	    if(e.getSource() == playButton) 
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
