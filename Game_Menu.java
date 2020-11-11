import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class Game_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton pauseButton;
	private int p1HP, p2HP, p1XPos, p1YPos, p2XPos, p2YPos, p1JumpStrength, p2JumpStrength, p1ProjectileXPos, p1ProjectileYPos, p2ProjectileXPos, p2ProjectileYPos;
	private ImageIcon pause, p1Sprite, p2Sprite, projectileSpriteRight, projectileSpriteLeft, gif;
	private Image pauseImg, sizedImg;
	private Timer myTimer;
	private boolean aPressed, dPressed, jPressed, lPressed, p1Jumping, p2Jumping, p1IsShooting, p1ShootingLeft, p1ShootingRight, p2IsShooting, p2ShootingLeft, p2ShootingRight;
	private Rectangle p1Hitbox, p2Hitbox, p1ProjectileHitbox, p2ProjectileHitbox;
	
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
	    projectileSpriteRight = new ImageIcon("AquaSpriteRight.png");
	    projectileSpriteLeft = new ImageIcon("AquaSpriteLeft.png");
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
		p1XPos = 285;
		p1YPos = 400;
		
		//Player 2 stats
		p2HP = 300;
		p2XPos = 935;
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
		
		//P1 Jump
		if (e.getKeyCode() == 87) //W
					
			if (!p1Jumping) {
				p1JumpStrength = 7;
				p1Jumping = true;
			}
		
		//P1 Attack
		if (e.getKeyCode() == 81) { //Q
			p1ProjectileXPos = p1XPos;
			p1ProjectileYPos = p1YPos + 47;
			p1IsShooting = true;
			
		}
		
		//P1 Special
		if (e.getKeyCode() == 69) { //E
			
		} 
			
			
		//P2 Jump 
		if (e.getKeyCode() == 73) //I
					
			if (!p2Jumping) {
				p2JumpStrength = 7;
				p2Jumping = true;
			}
		
		//P2 Attack
			if (e.getKeyCode() == 85) { //U
				p2ProjectileXPos = p2XPos;
				p2ProjectileYPos = p2YPos + 47;
				p2IsShooting = true;	
			}
	}	
		
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
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
		
		
		if (e.getSource() == pauseButton) {
			Main_Game.cardsL.show(Main_Game.c, "Pause");
			aPressed = false;
			dPressed = false;
			jPressed = false;
			lPressed = false;
		}
		//Game Loop
		if (e.getSource() == myTimer ) {
			
			//Requesting Pause Button Focus
			pauseButton.requestFocus();
			
			//Checking for game end
			if (Main_Game.restartGameBool) 
				restartGame();

			
			//Hitboxes
			p1Hitbox = new Rectangle(p1XPos, p1YPos, 75, 120);
			p2Hitbox = new Rectangle(p2XPos, p2YPos, 75, 120);
			
			p1ProjectileHitbox = new Rectangle(p1ProjectileXPos, p1ProjectileYPos, 50, 25);
			p2ProjectileHitbox = new Rectangle(p2ProjectileXPos, p2ProjectileYPos, 50, 25);
			
			//Player 1 Movement
			if (aPressed)
				p1XPos -= 10;
			
			if (dPressed)
				p1XPos += 10;
			
			if (p1Jumping) {
				
				//Exponential Jump
				if (p1JumpStrength > 0) {
					p1YPos -= Math.pow(2.0, p1JumpStrength);
				}
					
				if (p1JumpStrength < 0) {
					p1YPos += Math.pow(2.0, -p1JumpStrength);
				}
				
				//Changing the jump Strength
				p1JumpStrength --;
				
				//Stopping the Jump
				if (p1JumpStrength < -7)
					p1Jumping = false;
				
			}
			
			//Player 2 X Movement
			if (jPressed)
				p2XPos -= 10;
			
			if (lPressed)
				p2XPos += 10;
			
			
			if (p2Jumping) {
				
				//Exponential Jump
				if (p2JumpStrength > 0) {
					p2YPos -= Math.pow(2.0, p2JumpStrength);
				}
					
				if (p2JumpStrength < 0) {
					p2YPos += Math.pow(2.0, -p2JumpStrength);
				}
				
				//Changing the jump Strength
				p2JumpStrength --;
				
				//Stopping the Jump
				if (p2JumpStrength < -7)
					p2Jumping = false;
				
			}
			//Adding Collision
			
			//Borders
			if (p1XPos < 0)
				p1XPos += 10;
			
			if (p1XPos >= 1205)
				p1XPos -= 10;
			
			if (p2XPos < 0)
				p2XPos += 10;
			
			if (p2XPos > 1205)
				p2XPos -= 10;
			
			//Characters
			if (p1Hitbox.intersects(p2Hitbox)) {
				
				//P1 on left, P2 on right
				if (p1XPos <= p2XPos) {
					p1XPos -= 10;
					p2XPos += 10;
					
				}
				
				//P2 on left, P1 on right
				if (p1XPos > p2XPos) {
					p1XPos += 10;
					p2XPos -= 10;
					
				}
				
				
			}
			
			//Taking Damage
			if (p1Hitbox.intersects(p2ProjectileHitbox))
				p1HP -= 100;
			
			if (p2Hitbox.intersects(p1ProjectileHitbox))
				p2HP -= 100;
			
			//Shooting
			
			if (p1IsShooting) {
				
				//P1 on left, P2 on right
				if (p1XPos <= p2XPos) {
					p1ProjectileXPos += 50;
					p1ShootingRight = true;
					p1ShootingLeft = false;
				}
				
				//P2 on left, P1 on right
				if (p1XPos > p2XPos) {
					p1ProjectileXPos -= 50;
					p1ShootingLeft = true;
					p1ShootingRight = false;
				}
				
			}
			
			if (p2IsShooting) {
				
				//P1 on left, P2 on right
				if (p1XPos >= p2XPos) {
					p2ProjectileXPos += 50;
					p2ShootingRight = true;
					p2ShootingLeft = false;
				}
				
				//P2 on left, P1 on right
				if (p1XPos < p2XPos) {
					p2ProjectileXPos -= 50;
					p2ShootingLeft = true;
					p2ShootingRight = false;
				}
				
			}
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
	    
	    //Bullets
	    if (p1ShootingRight)
	    	g.drawImage(projectileSpriteRight.getImage(), p1ProjectileXPos, p1ProjectileYPos, null);
	    
	    if (p1ShootingLeft)
	    	g.drawImage(projectileSpriteLeft.getImage(), p1ProjectileXPos, p1ProjectileYPos, null);
	    
	    if (p2ShootingRight)
	    	g.drawImage(projectileSpriteRight.getImage(), p2ProjectileXPos, p2ProjectileYPos, null);
	    
	    if (p2ShootingLeft)
	    	g.drawImage(projectileSpriteLeft.getImage(), p2ProjectileXPos, p2ProjectileYPos, null);
	    
	    g.drawImage(p1Sprite.getImage(), p1XPos, p1YPos, null);
	    g.drawImage(p2Sprite.getImage(), p2XPos, p2YPos, null);
	    g.drawImage(gif.getImage(), 100, 100, null);
	}

	
}
