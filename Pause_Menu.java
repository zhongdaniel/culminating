/*|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 * File: Pause_Menu.java
 * Date Created: Oct 28th
 * Co-Authors: Anton Qi and Daniel Zhong
 * Desc: This file's code diplays a screen when the game is paused, contains options to resume game, return
 * to home page, and to restart game.
 * |-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Pause_Menu extends JPanel implements ActionListener{
	//Variables
	private JButton resumeButton, restartButton, quitButton;
	private ImageIcon resume, quit, restart, bg;
	private Image resumeImg, sizedResume, quitImg, sizedQuit, restartImg, sizedRestart;
  
	public Pause_Menu(){  // constructor
		//Creating Buttons
		//making the resume button
		resume = new ImageIcon("Resume.png");//importing the image
		resumeImg = resume.getImage();
		sizedResume = resumeImg.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH); 
		resume = new ImageIcon(sizedResume);
		
		resumeButton = new JButton(resume); //making play symbol button
		resumeButton.setBounds(105, 250, 200, 50);
		resumeButton.setOpaque(false);
		resumeButton.setContentAreaFilled(false);
		resumeButton.setBorderPainted(false);
	
		//making the quit button
		quit = new ImageIcon("Quit_Button.png"); //import quit image
		quitImg = quit.getImage();
		sizedQuit = quitImg.getScaledInstance(120, 50, java.awt.Image.SCALE_SMOOTH); 
		quit = new ImageIcon(sizedQuit);
		
		//making the button
		quitButton = new JButton(quit);
		quitButton.setBounds(95, 325, 120, 50);
		quitButton.setOpaque(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setBorderPainted(false);
		
		//making the restart game button
		restart = new ImageIcon("Restart_Button.png");//import restart image
		restartImg = restart.getImage();
		sizedRestart = restartImg.getScaledInstance(350, 50, java.awt.Image.SCALE_SMOOTH); 
		restart = new ImageIcon(sizedRestart);
		
		//making the button
		restartButton = new JButton(restart);
		restartButton.setBounds(100, 400, 350, 50);
		restartButton.setOpaque(false);
		restartButton.setContentAreaFilled(false);
		restartButton.setBorderPainted(false);
		
		//add background image to a variable
		bg = new ImageIcon("pauseBg.png");
		
		//Adding Listeners to buttons
		resumeButton.addActionListener(this);
		quitButton.addActionListener(this);
		restartButton.addActionListener(this);
		
		//Adding Objects
		this.setLayout(null);
		
		//adding buttons to layout
		this.add(resumeButton);
		this.add(quitButton);
		this.add(restartButton);
	}
 
	//Action Events
	public void actionPerformed(ActionEvent e) { //define the actions of the buttons
     
		if (e.getSource() == resumeButton) //resumes game
			Main_Game.cardsL.show(Main_Game.c, "Game");
     
		if (e.getSource() == quitButton) //return to home page
			Main_Game.cardsL.show(Main_Game.c, "Home");
     
		if (e.getSource() == restartButton) { //restart game
			Main_Game.restartGameBool = true;
			Main_Game.cardsL.show(Main_Game.c, "Game");
     }
 }
    
	
	//Draw Component
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//add background
		g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}

