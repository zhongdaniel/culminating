import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class Pause_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton playButton, restartButton, quitButton;
	private ImageIcon play, quit, restart, bg;
	private Image playImg, sizedImg, quitImg, sizedQuit, restartImg, sizedRestart;
  
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
	
		quit = new ImageIcon("Quit_Button.png");
		quitImg = quit.getImage();
		sizedQuit = quitImg.getScaledInstance(120, 50, java.awt.Image.SCALE_SMOOTH); 
		quit = new ImageIcon(sizedQuit);
		
		quitButton = new JButton(quit);
		quitButton.setBounds(95, 325, 120, 50);
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(false);
		
		restart = new ImageIcon("Restart_Button.png");
		restartImg = restart.getImage();
		sizedRestart = restartImg.getScaledInstance(350, 50, java.awt.Image.SCALE_SMOOTH); 
		restart = new ImageIcon(sizedRestart);
		
		restartButton = new JButton(restart);
		restartButton.setBounds(100, 400, 350, 50);
		restartButton.setOpaque(false);
		restartButton.setContentAreaFilled(false);
		restartButton.setBorderPainted(false);
		
		
		bg = new ImageIcon("pauseBg.png");
		
		//Adding Listeners
		playButton.addActionListener(this);
		quitButton.addActionListener(this);
		restartButton.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
		this.setLayout(null);
		this.setBackground(Color.GREEN);
		
		this.add(playButton);
		this.add(quitButton);
		this.add(restartButton);
	}
 
	//Action Events
	public void actionPerformed(ActionEvent e) {
     
		if (e.getSource() == playButton) 
			Main_Game.cardsL.show(Main_Game.c, "Game");
     
		if (e.getSource() == quitButton) 
			Main_Game.cardsL.show(Main_Game.c, "Home");
     
		if (e.getSource() == restartButton) {
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
		 
		g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

