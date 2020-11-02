
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



@SuppressWarnings("serial")
public class Game_Menu extends JPanel implements ActionListener, KeyListener{
	//Variables
	private JButton pauseButton;
	
	//Constructor
	public Game_Menu(){
		//Adding Buttons
		pauseButton = new JButton("     Pause     ");
		
		//Adding Listeners
		pauseButton.addActionListener(this);
		addKeyListener(this);
		
		//Adding Objects
		this.setLayout(new FlowLayout());
		this.add(pauseButton);
		this.setBackground(Color.RED);

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
		
		
	}
	
	
	//Draw Component
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));  // set a new font
	    g.drawString("---Game panel---",200,300);
	}

	
}
