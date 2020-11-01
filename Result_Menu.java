import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Result_Menu extends JPanel implements ActionListener{
		private JButton goMain;
		private JButton goRules;// variables: button
		
		public Result_Menu(){  // constructor
               goMain=new JButton(" Return to Main Menu ");
	           goMain.addActionListener(this);
	           this.setLayout(new FlowLayout());
	           this.add(goMain);     // add the button
			   this.setBackground(Color.GREEN);
		}	   
	    public void actionPerformed(ActionEvent e) {
	    	
	    	if(e.getSource() == goMain) 
		    	  Main_Game.cardsL.last(Main_Game.c);


	}
	public void paintComponent(Graphics g){
	   super.paintComponent(g);
	   g.setFont(new Font("Arial", Font.BOLD+Font.ITALIC, 18));  // set a new font
	   g.drawString("Welcome to ~~Summoner's Rift~~ Konosuba: the ripoff",100,200);   // display the string starting at the coordinate (100, 200)
   }//end of paint   

}// end of MyMenuPanel class