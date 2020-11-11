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
		cardsL=new CardLayout();
		c.setLayout(cardsL);
		restartGameBool = true;

		homeP = new Home_Menu();
		gameP = new Game_Menu();
		pauseP = new Pause_Menu();
		rulesP = new Rules_Menu();
		resultsP = new Results_Menu();
		
		  
	    c.add("Home", homeP);
	    c.add("Rules", rulesP);
	    c.add("Pause", pauseP);
	    c.add("Results", resultsP);
	    c.add("Game", gameP);
	  	    
	}
	
	public static void main(String[] args) {
		Main_Game f = new Main_Game();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(1280,720);
	}
	

}
