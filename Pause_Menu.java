import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Pause_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton playButton, goHome, restart;
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
		
		restart = new JButton("     Restart Game     ");
		restart.setFont(new Font("Garamond", Font.BOLD, 16));
		restart.setBounds(100, 400, 200, 35);
		restart.setBackground(new Color(227, 88, 64));
		
		//Adding Listeners
		playButton.addActionListener(this);
		goHome.addActionListener(this);
		restart.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
		this.setLayout(null);
		this.setBackground(Color.GREEN);
		
		this.add(playButton);
		this.add(goHome);
		this.add(restart);
	}
 
	//Action Events
	public void actionPerformed(ActionEvent e) {
     
		if (e.getSource() == playButton) 
			Main_Game.cardsL.show(Main_Game.c, "Game");
     
		if (e.getSource() == goHome) 
			Main_Game.cardsL.show(Main_Game.c, "Home");
     
		if (e.getSource() == restart) {
			Main_Game.restartGameBool = true;
			Main_Game.cardsL.show(Main_Game.c, "Game");
     }
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

