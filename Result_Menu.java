import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Result_Menu extends JPanel implements ActionListener, KeyListener{
	private JButton goMain;
	private JButton goGame;
		
		
	public Result_Menu() {
		//Adding Buttons
		goMain = new JButton(" Return to Main Menu ");
	    goGame = new JButton("     Play Again     ");
	        
	    
	    //Adding Listeners
		goMain.addActionListener(this);
	    goGame.addActionListener(this);
	    this.setLayout(new FlowLayout());
	        
	    //Adding Objects
	    this.add(goGame);
	    this.add(goMain);
	    this.setBackground(Color.GREEN);
		
	}
	
	//Key Events
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
					
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
					
	}
				
	public void keyPressed( KeyEvent e ) {
				
				
	}
	
	//Action Events
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//Draw Component
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));
		g.drawString("Welcome to ~~Summoner's Rift~~ Konosuba: the ripoff",100,200);
   }

	

}
