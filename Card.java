
public class Card {
	//Color: 0 red 1 green 2 purple/blue
	//Shape: 0 circle 1 diamond 2 s shaped
	//Pattern: 0 void 1 striped 2 plain
	protected int color, shape, pattern, number;
	
	public Card(int newNumber, int newShape, int newColor, int newPattern){
		setColor(newColor);
		setShape(newShape);
		setPattern(newPattern);
		setNumber(newNumber);
	}
	
	public boolean compareColor(Card c){
		if(this.getColor()==c.getColor()) return true;
		return false;
	}
	public boolean compareColor(Card c, Card cc){
		if((this.compareColor(c) && this.compareColor(cc)) || 
				(!this.compareColor(c) && !this.compareColor(cc) && !c.compareColor(cc))) return true;
		return false;
	}
	public boolean compareShape(Card c){
		if(this.getShape()==c.getShape()) return true;
		return false;
	}
	public boolean compareShape(Card c, Card cc){
		if((this.compareShape(c) && this.compareShape(cc)) || 
				(!this.compareShape(c) && !this.compareShape(cc) && !c.compareShape(cc))) return true;
		return false;
	}
	public boolean comparePattern(Card c){
		if(this.getPattern()==c.getPattern()) return true;
		return false;
	}
	public boolean comparePattern(Card c, Card cc){
		if((this.comparePattern(c) && this.comparePattern(cc)) || 
				(!this.comparePattern(c) && !this.comparePattern(cc) && !c.comparePattern(cc))) return true;
		return false;
	}
	public boolean compareNumber(Card c){
		if(this.getNumber()==c.getNumber()) return true;
		return false;
	}
	public boolean compareNumber(Card c, Card cc){
		if((this.compareNumber(c) && this.compareNumber(cc)) || 
			(!this.compareNumber(c) && !this.compareNumber(cc) && !c.compareNumber(cc)) ) return true;
		return false;
	}
	public boolean equals(Card c){
		return(c.toString().equals(this.toString()))? true:false;
	}
	public String toString(){
		String str = getNumber()+1+"";
		switch(getShape()){
			case 0: str +="o"; break;
			case 1: str +="d"; break;
			case 2: str +="s"; break;
		}
		switch(getColor()){
			case 0: str +="r"; break;
			case 1: str +="g"; break;
			case 2: str +="p"; break;
		}
		switch(getPattern()){
			case 0: str +="e"; break;
			case 1: str +="s"; break;
			case 2: str +="f"; break;
		}
		return str;
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public int getPattern() {
		return pattern;
	}

	public void setPattern(int pattern) {
		this.pattern = pattern;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
