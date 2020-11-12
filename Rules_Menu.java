import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Rules_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton backButton;
	private ImageIcon bg, back;
	private Image backImg, sizedBack;
	
	public Rules_Menu(){  // constructor
		//Creating the Buttons
		back = new ImageIcon("Back_Button.png");
		backImg = back.getImage();
		sizedBack = backImg.getScaledInstance(150, 40, java.awt.Image.SCALE_SMOOTH); 
		back = new ImageIcon(sizedBack);
		
		backButton = new JButton(back);
		backButton.setBounds(100, 350, 150, 40);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
  
		bg = new ImageIcon("Rules_Background.png");
  
		//Adding Listeners
		backButton.addActionListener(this);
		addKeyListener(this);
  
		//Adding Objects
		this.setLayout(null);
		this.setBackground(Color.white);
		this.add(backButton);
         
	}    
  
	//Action Events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) 
			Main_Game.cardsL.show(Main_Game.c, "Home");
		
	}
  
	//Key Events
	public void keyPressed( KeyEvent e ) {
     
		if(e.getKeyCode() == 27)// 27 is escape
			Main_Game.cardsL.show(Main_Game.c, "Home");
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
  
		//add background
		g.drawImage(bg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
  
		g.fillRect(80, 175, 300, 140);

		g.fillRect(720, 175, 300, 140);
		g.setColor(java.awt.Color.black);
  
    
		g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC,  18));
		g.setColor(java.awt.Color.white);
  
  
		g.drawString("Instructions:",100,200);  
		g.drawString("Player 1 Controls:",100,225);   
		g.drawString("Move Left - A",100,250);  
		g.drawString("Move Right - D",100,275);   
		g.drawString("Attack - Q",100,300);   
		g.drawString("Player 2 Controls:",740,225);   
  		g.drawString("Move Left - J",740,250);   
  		g.drawString("Move Right - L",740,250);   
  		g.drawString("Attack - U",740,300);   
 
 }
 
 
}
