import processing.core.PApplet;
import java.util.*;

public class SetCardGameGUI extends PApplet {
	// 0: Main menu
	//
	public static int state = 0; 
	public static void main(String args[]) {
	    PApplet.main(new String[] { "SetCardGameGUI" });
	  	Game game = new Game();
	}
	private int width = 1000, height = 700;
	private int textMainWelcomex = width/2, textMainWelcomey = height/10;
	private int boxMain01x = width*5/16, boxMain01y = height/3, boxMain01width = width*3/8, boxMain01height = height/12;
	private int textMainNewGamex = width*8/16, textMainNewGamey = height*13/32;
	//Scanner input = new Scanner(System.in);

	public void setup(){
		size(width, height);
		state = 0;
	}
	public void draw(){
		switch(state){
			case 0:
				drawMainMenu();
		}
	}
	public void drawMainMenu(){
		background(29, 83, 0);
		
		//Title of the menu
		fill(255);
		textSize(height/12);
		textAlign(CENTER);
		text("Welcome to the game of SET!", textMainWelcomex, textMainWelcomey);

		fill(133, 96, 136);

		Rectangle rectMain01 = Rectangle(boxMain01x, boxMain01y, boxMain01width, boxMain01height, this.canvas);
		//rect(boxMain01x, boxMain01y, boxMain01width, boxMain01height);

		fill(255);
		textAlign(CENTER);

		text("New Game", textMainNewGamex, textMainNewGamey);		
	}

	void mousePressed(){

	}

	void mouseMoved(){

	}
}
