import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class Game_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton pauseButton;
	private int p1HP, p2HP, p1XPos, p1YPos, p2XPos, p2YPos;
	private ImageIcon pause, p1Sprite, p2Sprite, projectileSprite, gif;
	private Image pauseImg, sizedImg;
	private Timer myTimer;
	private boolean aPressed, dPressed, jPressed, lPressed; // Keys in order are A, D, J, L
	
	//Constructor
	public Game_Menu() {
		//Creating the objects
		pause = new ImageIcon("Pause.png");
		pauseImg = pause.getImage();
		sizedImg = pauseImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		pause = new ImageIcon(sizedImg);
		
		myTimer = new Timer(60, this ); 
		
		p1Sprite = new ImageIcon("MeguminSprite.png");
		p2Sprite = new ImageIcon("WizSprite.png");
	    projectileSprite = new ImageIcon("home_background.png");
	    try {
			gif = new ImageIcon("MeguminExplosion.gif");
		}
		catch(Exception e){
			System.out.println("Oh no! There was an issue loadng the gif! However, the game will still run the game!");
		}
	    
		pauseButton = new JButton(pause);
		pauseButton.setBounds(1200, 10, 50, 50);
		pauseButton.setOpaque(false);
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		
		//Adding Listeners

		pauseButton.addActionListener(this);
		
		this.addKeyListener(this);
		pauseButton.setFocusable(true);
		pauseButton.requestFocus();
		pauseButton.addKeyListener(this);
		
		//Adding Objects
		
		this.setLayout(null);
		
		this.add(pauseButton);
		this.setBackground(Color.RED);
		
		myTimer.start();
		
	    
	}
	
	
	// Custom Events
	public void restartGame() {
		
		Main_Game.restartGameBool = false;
		
		//Player 1 stats
		p1HP = 300;
		p1XPos = 200;
		p1YPos = 400;
		
		//Player 2 stats
		p2HP = 300;
		p2XPos = 960;
		p2YPos = 400;
	}
	
	public void checkGame() {
		
		if (p1HP == 0 && p2HP == 0) { //tie
			Main_Game.restartGameBool = true;
			Main_Game.resultsP.getWinner("Tie Game!");
			Main_Game.cardsL.show(Main_Game.c, "Results");
		}
		
		else if (p1HP == 0) {
			Main_Game.restartGameBool = true;
			Main_Game.resultsP.getWinner("Good Game! Player 2 wins!");
			Main_Game.cardsL.show(Main_Game.c, "Results");
		}
		
		else if (p2HP == 0) {
			Main_Game.restartGameBool = true;
			Main_Game.resultsP.getWinner("Good Game! Player 1 wins!");
			Main_Game.cardsL.show(Main_Game.c, "Results");
		}
	}
	
	public void p1Jump() {
		
	}
	
	public void p2Jump() {
		
	}
	
	
	//Key Events
	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	
	@Override
	public void keyPressed( KeyEvent e ) {
		if (e.getKeyCode() == 27) // 27 is escape
			Main_Game.cardsL.show(Main_Game.c, "Pause");
		
		//P1 Movement
		if (e.getKeyCode() == 65) //A
			aPressed = true;	
		
		if (e.getKeyCode() == 68) //D
			dPressed = true;
		
		
		//P2 Movement
		if (e.getKeyCode() == 74) //J
			jPressed = true;
		
		if (e.getKeyCode() == 76) //L
			lPressed = true;
		
	}
		
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//P1 Jump and Attacks
		if (e.getKeyCode() == 87) //W
			p1Jump();
		
		
		//P2 Jump and Attacks
		if (e.getKeyCode() == 73) //I
			p2Jump();
		
		//P1 Movement
		if (e.getKeyCode() == 65) //A
			aPressed = false;	
		
		if (e.getKeyCode() == 68) //D
			dPressed = false;
		
		
		//P2 Movement
		if (e.getKeyCode() == 74) //J
			jPressed = false;
		
		if (e.getKeyCode() == 76) //L
			lPressed = false;
				
	}
	

	
	//Action Events
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == pauseButton) 
			Main_Game.cardsL.show(Main_Game.c, "Pause");
		
		//Game Loop
		if (e.getSource() == myTimer ) {
			
			//Checking for game end
			if (Main_Game.restartGameBool)
				restartGame();
			
			//Player 1 X Movement
			if(aPressed)
				p1XPos -= 10;
			
			if(dPressed)
				p1XPos += 10;
			
			//Player 2 X Movement
			if(jPressed)
				p2XPos -= 10;
			
			if(lPressed)
				p2XPos += 10;
			
			//Adding Borders
			if (p1XPos < 0)
				p1XPos += 10;
			
			if (p1XPos > 1180)
				p1XPos -= 10;
			
			if (p2XPos < 0)
				p2XPos += 10;
			
			if (p2XPos > 1180)
				p2XPos -= 10;
			
			//Check Game State
			checkGame();
			
			//Frame Update
			repaint();
		}
	}
	
	
	//Draw Component
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));  // set a new font
	    g.drawString("---Game panel---",200,300);
	    
	    g.drawImage(p1Sprite.getImage(), p1XPos, p1YPos, null);
	    g.drawImage(p2Sprite.getImage(), p2XPos, p2YPos, null);
	    g.drawImage(gif.getImage(), 100, 100, null);
	}

	
}
