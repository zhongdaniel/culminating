
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main_Game extends JFrame{
	//Variables
	static CardLayout cardsL;
	static Container c;

	Home_Menu homeP;
	Game_Menu gameP;  
	Rules_Menu rulesP;
	Pause_Menu pauseP;
	Result_Menu resultP;
	
	//Constructor
	public Main_Game(){
		c = getContentPane();
		cardsL=new CardLayout();
		c.setLayout(cardsL);
		   
		homeP = new Home_Menu();
		gameP = new Game_Menu();
		pauseP = new Pause_Menu();
		rulesP = new Rules_Menu();
		resultP = new Result_Menu();
		  
	    c.add("Konosuba: The Ripoff- Home", homeP);
	    c.add("Konosuba: The Ripoff- Rules", rulesP);
	    c.add("Konosuba: The Ripoff- Pause", pauseP);
	    c.add("Konosuba: The Ripoff- Results", resultP);
	    c.add("Konosuba: The Ripoff", gameP);
	  	    
	}
	
	public static void main(String[] args) {
		Main_Game f = new Main_Game();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(1280,720);
	}
	
	

}



