
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class Game_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton pauseButton;
	private static int p1HP, p2HP, p1XPos, p1YPos, p2XPos, p2YPos;
	private ImageIcon pause, p1Sprite, p2Sprite, projectileSprite;
	private Image pauseImg, sizedImg;
	
	//Constructor
	public Game_Menu(){
		//Creating the objects
		pause = new ImageIcon("Pause.png");
		pauseImg = pause.getImage();
		sizedImg = pauseImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); 
		pause = new ImageIcon(sizedImg);
		
		p1Sprite = new ImageIcon("Megumin_Sprite.png");
		p2Sprite = new ImageIcon("Megumin_Sprite.png");
	    projectileSprite = new ImageIcon("home_background.png");
		
		pauseButton = new JButton(pause);
		pauseButton.setBounds(1200, 10, 50, 50);
		pauseButton.setOpaque(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		

		//Adding Listeners
		pauseButton.addActionListener(this);
		addKeyListener(this);
		pauseButton.addKeyListener(this);
		
		//Adding Objects
		this.setLayout(null);
		this.add(pauseButton);
		this.setBackground(Color.RED);
		
		//The Game Loop
		
		/*
		 while (true) {
			
			//Ending the game
			if ((p1HP == 0) || p2HP == 0) {
				endGame();
				break;
			}
		}
		 */
	}
	
	// Custom Events
	public void restartGame() {
		//Player 1 stats
		p1HP = 300;
		p1XPos = 320;
		p1YPos = 360;
		
		//Player 2 stats
		p2HP = 300;
		p2XPos = 960;
		p2YPos = 360;
	}
	
	public void endGame() {
		restartGame();
		Main_Game.cardsL.previous(Main_Game.c);
	}
	
	//Key Events
	public void keyTyped(KeyEvent e) {
		System.out.println("Escape");
		if(e.getKeyCode()== 27) { // 27 is escape
			Main_Game.cardsL.previous(Main_Game.c);
			Main_Game.cardsL.previous(Main_Game.c);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
				
	}
			
	public void keyPressed( KeyEvent e ) {
			
			
	}

	
	//Action Events
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == pauseButton) {
			Main_Game.cardsL.previous(Main_Game.c);
			Main_Game.cardsL.previous(Main_Game.c);
		}

	}
	
	
	//Draw Component
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));  // set a new font
	    g.drawString("---Game panel---",200,300);
	    
	    g.drawImage(p1Sprite.getImage(), p1XPos, p1YPos, null);
	    g.drawImage(p2Sprite.getImage(), p2XPos, p2YPos, null);
	}

	
}
