
public class Card {
	//Number: 0 1   1 2   2 3
	//Shape: 0 oval 1 diamond 2 s shaped
	//Color: 0 red 1 green 2 purple/blue
	//Pattern: 0 void 1 striped 2 plain
	protected int color, shape, pattern, number;
	
	public Card(int newNumber, int newShape, int newColor, int newPattern){
		setColor(newColor);
		setShape(newShape);
		setPattern(newPattern);
		setNumber(newNumber);
	}
	public Card(String card){
		Card c = decodeCard(card);
		setNumber(c.getNumber());
		setShape(c.getShape());
		setColor(c.getColor());
		setPattern(c.getPattern());
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
	public boolean equals(Object obj){
		if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof Card)) return false;
	    Card c = (Card) obj;
		return(c.toString().equals(this.toString()))? true:false;
	}

	public static boolean isCard(String s){
		try{
			if(decodeCard(s).equals(new Card(3, 3, 3, 3))) return false;
		}catch(Exception e){}
		return true;
	}

	public static Card decodeCard(String card){
		int shape, color, pattern, number;
		if(card.length()!=4)return new Card(3, 3, 3, 3);
		
		number = (card.charAt(0)>'0' && card.charAt(0)<='3')?card.charAt(0)-'0'-1:3;

		switch(card.charAt(1)){
			case 's': shape = 2; break;
			case 'd': shape = 1; break;
			case 'o': shape = 0; break;
			default: shape = 3;
			
		}

		switch(card.charAt(2)){
			case 'r': color = 0; break;
			case 'g': color = 1; break;
			case 'p': 
			case 'b': color = 2; break;
			default: color = 3;
		}

		switch(card.charAt(3)){
			case 'f': pattern = 2; break;
			case 's': pattern = 1; break;
			case 'e': pattern = 0; break;
			default: pattern = 3;
		}
		
		return new Card(number, shape, color, pattern);
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
		if(color>2 || color<0) this.color = 3;
		else
			this.color = color;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		if(shape>2 || shape<0) this.shape = 3;
		else
			this.shape = shape;
	}

	public int getPattern() {
		return pattern;
	}

	public void setPattern(int pattern) {
		if(pattern>2 || pattern<0) this.pattern = 3;
		else
			this.pattern = pattern;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if(number>2 || number<0) this.number = 3;
		else
			this.number = number;
	}
	
}
