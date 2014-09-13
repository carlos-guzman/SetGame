import processing.core.PApplet;
import processing.core.PGraphics;

public class Rectangle{
	private int x, y, width, height;
	public Rectangle(int x, int y, int width, int height, Canvas c){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean over(int mouseX, int mouseY){
		if(mouseX>x && mouseX<x+width && mouseY>y && mouseY<y+height)
			return true;
		return false;
	}
}