import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class Game_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton pauseButton;
	private int p1HP, p2HP, p1XPos, p1YPos, p2XPos, p2YPos, p1JumpStrength, p2JumpStrength;
	private int p1Projectile1XPos, p1Projectile1YPos, p2Projectile1XPos, p2Projectile1YPos;
	private int p1Projectile2XPos, p1Projectile2YPos, p2Projectile2XPos, p2Projectile2YPos;
	private int p1Projectile3XPos, p1Projectile3YPos, p2Projectile3XPos, p2Projectile3YPos;
	private ImageIcon pause, p1Sprite, p2Sprite, projectileSpriteRight, projectileSpriteLeft, hp1, hp2;
	private Image pauseImg, sizedImg;
	private Timer myTimer;
	private boolean aPressed, dPressed, jPressed, lPressed, p1Jumping, p2Jumping;
	private boolean p1ShootingLeft, p1ShootingRight, p2ShootingLeft, p2ShootingRight;
	private boolean p1Projectile1Used, p1Projectile2Used, p1Projectile3Used, p2Projectile1Used, p2Projectile2Used, p2Projectile3Used;
	private Rectangle p1Hitbox, p2Hitbox, p1Projectile1Hitbox, p1Projectile2Hitbox, p1Projectile3Hitbox, p2Projectile1Hitbox, p2Projectile2Hitbox, p2Projectile3Hitbox;
	
	//Constructor
	public Game_Menu() {
		//Variable Assignment
		p1Projectile1XPos = 200;
        p1Projectile1YPos = 650;
        p2Projectile1XPos = 1000;
        p2Projectile1YPos = 650;
        p1Projectile2XPos = 200;
        p1Projectile2YPos = 620;
        p2Projectile2XPos = 1000;
        p2Projectile2YPos = 620;
        p1Projectile3XPos = 200;
        p1Projectile3YPos = 590;
        p2Projectile3XPos = 1000;
        p2Projectile3YPos = 590;
        p1ShootingRight = true;
        p2ShootingLeft = true;

		
		//Creating the objects
		pause = new ImageIcon("Pause.png");
		pauseImg = pause.getImage();
		sizedImg = pauseImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		pause = new ImageIcon(sizedImg);
		
		myTimer = new Timer(60, this ); 
		
		p1Sprite = new ImageIcon("MeguminSprite.png");
		p2Sprite = new ImageIcon("WizSprite.png");
		
		hp1 = new ImageIcon("P1hp.png");
		hp2 = new ImageIcon("P2hp.png");
		
	    projectileSpriteRight = new ImageIcon("AquaSpriteRight.png");
	    projectileSpriteLeft = new ImageIcon("AquaSpriteLeft.png");
	    
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
		
		aPressed = false;
		dPressed = false;
		jPressed = false;
		lPressed = false;
		
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
			
			if (!p1Projectile1Used) {
				p1Projectile1XPos = p1XPos;
				p1Projectile1YPos = p1YPos + 47;
				p1Projectile1Used = true;
			}
			
			else if (!p1Projectile2Used) {
				p1Projectile2XPos = p1XPos;
				p1Projectile2YPos = p1YPos + 47;
				p1Projectile2Used = true;
			}
			
			else if (!p1Projectile3Used) {
				p1Projectile3XPos = p1XPos;
				p1Projectile3YPos = p1YPos + 47;
				p1Projectile3Used = true;
			}
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
				
				if (!p2Projectile1Used) {
					p2Projectile1XPos = p2XPos;
					p2Projectile1YPos = p2YPos + 47;
					p2Projectile1Used = true;
				}
				
				else if (!p2Projectile2Used) {
					p2Projectile2XPos = p2XPos;
					p2Projectile2YPos = p2YPos + 47;
					p2Projectile2Used = true;
				}
				
				else if (!p2Projectile3Used) {
					p2Projectile3XPos = p2XPos;
					p2Projectile3YPos = p2YPos + 47;
					p2Projectile3Used = true;
				}
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
			
			p1Projectile1Hitbox = new Rectangle(p1Projectile1XPos, p1Projectile1YPos, 50, 25);
			p2Projectile1Hitbox = new Rectangle(p2Projectile1XPos, p2Projectile1YPos, 50, 25);
			
			p1Projectile2Hitbox = new Rectangle(p1Projectile2XPos, p1Projectile2YPos, 50, 25);
			p2Projectile2Hitbox = new Rectangle(p2Projectile2XPos, p2Projectile2YPos, 50, 25);
			
			p1Projectile3Hitbox = new Rectangle(p1Projectile3XPos, p1Projectile3YPos, 50, 25);
			p2Projectile3Hitbox = new Rectangle(p2Projectile3XPos, p2Projectile3YPos, 50, 25);
			
			//Player 1 Movement
			if (aPressed)
				p1XPos -= 15;
			
			if (dPressed)
				p1XPos += 15;
			
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
				p2XPos -= 15;
			
			if (lPressed)
				p2XPos += 15;
			
			
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
				p1XPos += 15;
			
			if (p1XPos >= 1205)
				p1XPos -= 15;
			
			if (p2XPos < 0)
				p2XPos += 15;
			
			if (p2XPos > 1205)
				p2XPos -= 15;
			
			//Characters
			if (p1Hitbox.intersects(p2Hitbox)) {
				
				//P1 on left, P2 on right
				if (p1XPos <= p2XPos) {
					p1XPos -= 15;
					p2XPos += 15;
					
				}
				
				//P2 on left, P1 on right
				if (p1XPos > p2XPos) {
					p1XPos += 15;
					p2XPos -= 15;
					
				}
				
			}
			
			//Taking Damage
		
			if (p1Hitbox.intersects(p2Projectile1Hitbox)) {
				p1HP -= 15;
				p2Projectile1Used = false;
				p2Projectile1XPos = 1000;
				p2Projectile1YPos = 650;

			}
			
			if (p1Hitbox.intersects(p2Projectile2Hitbox)) {
				p1HP -= 15;
				p2Projectile2Used = false;
				p2Projectile2XPos = 1000;
				p2Projectile2YPos = 620;

			}
			
			if (p1Hitbox.intersects(p2Projectile3Hitbox)) {
				p1HP -= 15;
				p2Projectile3Used = false;
				p2Projectile3XPos = 1000;
				p2Projectile3YPos = 590;

			}
				
			if (p2Hitbox.intersects(p1Projectile1Hitbox)) {
				p2HP -= 15;
				p1Projectile1Used = false;
				p1Projectile1XPos = 200;
				p1Projectile1YPos = 650;
			}
			
			if (p2Hitbox.intersects(p1Projectile2Hitbox)) {
				p2HP -= 15;
				p1Projectile2Used = false;
				p1Projectile2XPos = 200;
				p1Projectile2YPos = 620;
			}
			
			if (p2Hitbox.intersects(p1Projectile3Hitbox)) {
				p2HP -= 15;
				p1Projectile3Used = false;
				p1Projectile3XPos = 200;
				p1Projectile3YPos = 590;
			}
			
			
			//Shooting
			
				
			//P1 on left, P2 on right
			if (p1XPos <= p2XPos) {
					
				p1ShootingRight = true;
				p1ShootingLeft = false;
				
				p2ShootingRight = false;
				p2ShootingLeft = true;
				
				
				if (p1Projectile1Used) 
					p1Projectile1XPos += 50;
				
				if (p1Projectile2Used) 
					p1Projectile2XPos += 50;
						
				if (p1Projectile3Used)
					p1Projectile3XPos += 50;		
	
			
				if (p2Projectile1Used) 
					p2Projectile1XPos -= 50;
				
				if (p2Projectile2Used) 
					p2Projectile2XPos -= 50;
						
				if (p2Projectile3Used) 
					p2Projectile3XPos -= 50;		
				
			}
				
			//P2 on left, P1 on right
			if (p1XPos > p2XPos) {
				
				p1ShootingLeft = true;
				p1ShootingRight = false;
				
				p2ShootingLeft = false;
				p2ShootingRight = true;

				
				if (p1Projectile1Used) 
					p1Projectile1XPos -= 50;
				
				if (p1Projectile2Used) 
					p1Projectile2XPos -= 50;
						
				if (p1Projectile3Used)
					p1Projectile3XPos -= 50;		
						
			
				if (p2Projectile1Used) 
					p2Projectile1XPos += 50;
				
				if (p2Projectile2Used) 
					p2Projectile2XPos += 50;
						
				if (p2Projectile3Used) 
					p2Projectile3XPos += 50;	
			}
			
			
			//Reloading upon missing
			
			if (p1Projectile1XPos <= 0 || p1Projectile1XPos >= 1280) {
				p1Projectile1XPos = 200;
				p1Projectile1YPos = 650;
				p1Projectile1Used = false;
			}
			
			if (p1Projectile2XPos <= 0 || p1Projectile2XPos >= 1280) {
				p1Projectile2XPos = 200;
				p1Projectile2YPos = 620;
				p1Projectile2Used = false;
			}

			if (p1Projectile3XPos <= 0 || p1Projectile3XPos >= 1280) {
				p1Projectile3XPos = 200;
				p1Projectile3YPos = 590;
				p1Projectile3Used = false;
			}
			
			if (p2Projectile1XPos <= 0 || p2Projectile1XPos >= 1280) {
				p2Projectile1XPos = 1000;
				p2Projectile1YPos = 650;
				p2Projectile1Used = false;
			}
			
			if (p2Projectile2XPos <= 0 || p2Projectile2XPos >= 1280) {
				p2Projectile2XPos = 1000;
				p2Projectile2YPos = 620;
				p2Projectile2Used = false;
			}
			if (p2Projectile3XPos <= 0 || p2Projectile3XPos >= 1280) {
				p2Projectile3XPos = 1000;
				p2Projectile3YPos = 590;
				p2Projectile3Used = false;
				
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
	    
	    //Bullets
	    if (p1ShootingRight) {
	    	g.drawImage(projectileSpriteRight.getImage(), p1Projectile1XPos, p1Projectile1YPos, null);
	    	g.drawImage(projectileSpriteRight.getImage(), p1Projectile2XPos, p1Projectile2YPos, null);
	    	g.drawImage(projectileSpriteRight.getImage(), p1Projectile3XPos, p1Projectile3YPos, null);
	    
	    }
	    
	    if (p1ShootingLeft) {
	    	g.drawImage(projectileSpriteLeft.getImage(), p1Projectile1XPos, p1Projectile1YPos, null);
	    	g.drawImage(projectileSpriteLeft.getImage(), p1Projectile2XPos, p1Projectile2YPos, null);
	    	g.drawImage(projectileSpriteLeft.getImage(), p1Projectile3XPos, p1Projectile3YPos, null);
	    
	    }
	    
	    if (p2ShootingRight) {
	    	g.drawImage(projectileSpriteRight.getImage(), p2Projectile1XPos, p2Projectile1YPos, null);
	    	g.drawImage(projectileSpriteRight.getImage(), p2Projectile2XPos, p2Projectile2YPos, null);
	    	g.drawImage(projectileSpriteRight.getImage(), p2Projectile3XPos, p2Projectile3YPos, null);
	    }
	    
	    if (p2ShootingLeft) {
	    	g.drawImage(projectileSpriteLeft.getImage(), p2Projectile1XPos, p2Projectile1YPos, null);
	    	g.drawImage(projectileSpriteLeft.getImage(), p2Projectile2XPos, p2Projectile2YPos, null);
	    	g.drawImage(projectileSpriteLeft.getImage(), p2Projectile3XPos, p2Projectile3YPos, null);
	    }	
	    
	    //Characters
	    g.drawImage(p1Sprite.getImage(), p1XPos, p1YPos, null);
	    g.drawImage(p2Sprite.getImage(), p2XPos, p2YPos, null);
	    
	    //HP Bar
	    g.drawImage(hp1.getImage(), 10, 550, 200, 40, null);
	    g.drawImage(hp2.getImage(), 1050, 550, 200, 40, null);
	    
	    g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
	    g.drawString(p1HP + "", 10, 650);
	    g.drawString(p2HP + "", 1050, 650);
	    
	}
}
