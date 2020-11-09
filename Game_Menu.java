import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class Game_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton pauseButton;
	private int p1HP, p2HP, p1XPos, p1YPos, p2XPos, p2YPos;
	private ImageIcon pause, p1Sprite, p2Sprite, projectileSprite;
	private Image pauseImg, sizedImg;
	private boolean run;
	
	//Constructor
	public Game_Menu() {
		//Creating the objects
		pause = new ImageIcon("Pause.png");
		pauseImg = pause.getImage();
		sizedImg = pauseImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		pause = new ImageIcon(sizedImg);
		
		p1Sprite = new ImageIcon("MeguminSprite.png");
		p2Sprite = new ImageIcon("WizSprite.png");
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

	}
	
	try {
			ImageIcon gif = new ImageIcon("MeguminExplosion.gif");
		}
		catch(Exception e){
			System.out.println("Oh no! There was an issue loadng the gif! However, the game will still run the game!");
		}
	
	// The Game Loop
	
	public void gameLoop() {
		
		run = true;
		
		while (run) {
			checkGame();
			
		}
		
	}
	
	
	// Custom Events
	public void restartGame() {
		//Player 1 stats
		p1HP = 300;
		p1XPos = 200;
		p1YPos = 400;
		
		//Player 2 stats
		p2HP = 0;
		p2XPos = 960;
		p2YPos = 400;
	}
	
	public void checkGame() {
		
		if (p1HP == 0 && p2HP == 0) { //tie
			restartGame();
			Main_Game.resultsP.getWinner("Tie Game!");
			Main_Game.cardsL.show(Main_Game.c, "Results");
		}
		
		else if (p1HP == 0) {
			restartGame();
			Main_Game.resultsP.getWinner("Good Game! Player 2 wins!");
			Main_Game.cardsL.show(Main_Game.c, "Results");
		}
		
		else if (p2HP == 0) {
			restartGame();
			Main_Game.resultsP.getWinner("Good Game! Player 1 wins!");
			Main_Game.cardsL.show(Main_Game.c, "Results");
		}
	}
	
	public void p1Jump() {
		
	}
	
	public void p2Jump() {
		
	}
	
	//Key Events
	public void keyTyped(KeyEvent e) {
		
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		//P1 Jump and Attacks
		if (e.getKeyCode() == 87) //W
			p1Jump();
		
		
		//P2 Jump and Attacks
		if (e.getKeyCode() == 73) //I
			p2Jump();
				
	}
			
	public void keyPressed( KeyEvent e ) {
		System.out.println("Escape");
		
		if (e.getKeyCode() == 27) // 27 is escape
			Main_Game.cardsL.show(Main_Game.c, "Pause");
		
		//P1 X Movement
		while (e.getKeyCode() == 65) //A
			p1XPos --;
		
		while (e.getKeyCode() == 68) //D
			p1XPos ++;
		
		
		//P2 X Movement
		while (e.getKeyCode() == 74) //J
			p1XPos --;
				
		while (e.getKeyCode() == 76) //L
			p1XPos ++;
		
	}

	
	//Action Events
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == pauseButton) 
			Main_Game.cardsL.show(Main_Game.c, "Pause");
		
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
