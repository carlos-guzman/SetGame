import processing.core.*;
import java.util.*;

public class SetCardGameGUI extends PApplet {
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "SetCardGameGUI" });
	  	// Game game = new Game();
	}
 //  		PApplet p = new PApplet();
	// 	p.init();
	// 	p.size(700, 480);
	// 	p.background(0,0,0);
	// }
// }

// class Processing extends PApplet{
	private int width = 700, height = 480;
	// Scanner input = new Scanner(System.in);

	public void setup(){
		size(width, height);
		// if (frame != null) {
		// 	frame.setResizable(true);
		frame.setSize(width, height);
		// }
		drawMainMenu();
	}
	public void draw(){
		background(29, 83, 0);
	}
	public void drawMainMenu(){
		background(29, 83, 0);
		fill(255);
		textSize(40);
		textAlign(CENTER);
		text("Welcome to the game of SET!", 240, 50);
	}
}