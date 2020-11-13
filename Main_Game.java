/*|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 * File: Main_Game.java
 * Date Created: Oct 27th
 * Co-Authors: Anton Qi and Daniel Zhong
 * Desc: This file's code is to create and organize all the files, and to set the windows
 * |-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main_Game extends JFrame{
	//Variables
	static CardLayout cardsL;
	static Container c;

	Home_Menu homeP;
	static Game_Menu gameP;  
	Rules_Menu rulesP;
	Pause_Menu pauseP;
	static Results_Menu resultsP;
	
	static boolean restartGameBool;
	
	//Constructor
	public Main_Game(){
		c = getContentPane();
		//make cards of files
		cardsL=new CardLayout();
		c.setLayout(cardsL);
		
		//initializing boolean
		restartGameBool = true;

		//making new files
		homeP = new Home_Menu();
		gameP = new Game_Menu();
		pauseP = new Pause_Menu();
		rulesP = new Rules_Menu();
		resultsP = new Results_Menu();
		
		//adding files to cards
	    c.add("Home", homeP);
	    c.add("Rules", rulesP);
	    c.add("Pause", pauseP);
	    c.add("Results", resultsP);
	    c.add("Game", gameP);
	  	    
	}
	
	public static void main(String[] args) {
		Main_Game f = new Main_Game();
		
		//creating window
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(1280,720);
	}
	

}
