//1ore
//2dgs
//3spf
public class Game {
	int setCount, score;
	int sizeArray = 0;
	Card[] cardArray = new Card[sizeArray];
	String[] setArray;
	Card[] fullDeck = new Card[81];
	protected String rules;
	public Game(){
		this("");
	}
	public Game(String preset){
		newGame(preset);
		setRules();
		getFullDeck();
	}
	public void newGame(String preset){
		setCount = 0;
		addCard(decodeString(preset));
		findSetCount();
	}
	public void findSetCount(){
		String str = "";
		setCount = 0;
		for(int i = 0; i<sizeArray;i++){
			for(int j = i+1; j<sizeArray; j++){
				for(int k = j+1; k<sizeArray; k++){
					if(checkSet(cardArray[i], cardArray[j], cardArray[k])){
						setCount++;
						str+=cardArray[i].toString()+"/"+cardArray[j].toString()+"/"+cardArray[k].toString()+"-";
					}
				}
			}
		}
		setArray = str.split("-");
	}
	public String setArrayToString(){
		String s ="";
		for(int i = 0;i<setArray.length;i++){
			System.out.println(setArray[i]);
			if(setArray[i]!=null)s+=setArray[i]+"\n";
		}
		return s;
	}
	public String getValidSet(int s){
		if(s>=0 && s<setArray.length) return setArray[s];
		return "1333/1333/1333";
	}
	public boolean submitSet(String s){
		Card[]cA = decodeString(s);
		if(s.matches("[1-"+(setArray.length-1)+"]")) {
			System.out.println(getValidSet(Integer.parseInt(s)-1));
			return false;
		}
		if(cA.length!=3)return false;
		return submitSet(cA[0], cA[1], cA[2]);
	}
	public boolean submitSet(Card c1, Card c2, Card c3){
		if(!checkSet(c1, c2, c3)) return false;
		removeCard(c1);
		removeCard(c2);
		removeCard(c3);
		score++;
		return true;
	}
	public boolean removeCard(Card c){
		for(int i = 0; i<sizeArray;i++){
			if(cardArray[i].equals(c)){
				cardArray[i] = cardArray[sizeArray-1];
				sizeArray--;
				return true;
			}
		}
		return false;
	}
	public void addCard(String c){
		addCard(new Card[]{decodeCard(c)});
	}
	public void addCard(Card[] newArray){
		int newSize = newArray.length;
		for(int i = 0; i<sizeArray;i++){
			for(int j = 0; j<newSize;j++){
				if(cardArray[i].equals(newArray[j])){
					newArray[j] = newArray[newSize-1];
					newSize--;
				}
			}
		}
		while(cardArray.length<sizeArray+newArray.length) cardArray = expandCardArray(cardArray);
		for(int i = 0;i<newArray.length;i++){
			cardArray[i+sizeArray] = newArray[i];
		}
		sizeArray +=newArray.length;
	} 
	public Card[] expandCardArray(Card[] array){
		Card[] newArray = new Card[(int)(array.length*1.5+1)];
		for(int i = 0; i<array.length;i++){
			newArray[i] = array[i];
		}
		return newArray;
	}
	public Card[] decodeString(String str){
		String[] strArray = str.split("/");
		Card[] cArray = new Card[strArray.length];
		for(int i = 0; i<strArray.length; i++){
			cArray[i] = decodeCard(strArray[i]);
		}
		return cArray;
	}
	public Card decodeCard(String card){
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
	public boolean checkSet(Card c1, Card c2, Card c3){
		return (c1.compareColor(c2, c3) && c1.compareShape(c2, c3) && c1.comparePattern(c2, c3) && c1.compareNumber(c2, c3)
				&& !(c1.equals(c2) || c1.equals(c3) || c2.equals(c3))); 
	}
	public String toString(){
		findSetCount();
		String str = "Score: "+getScore()+" Sets: "+getSetCount()+" Cards: ("+sizeArray+")";
		for(int i = 0; i<sizeArray; i++){
			str+=" "+cardArray[i].toString();
		}
		return str;
	}
	public int getSetCount(){
		return setCount;
	}
	public boolean hasSets(){
		return (setCount!=0);
	}
	public int getScore(){
		return score;
	}
	public Card[] getFullDeck(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					for(int l=0;l<3;l++){
						fullDeck[l+3*k+9*j+27*i] = new Card(i, j, k, l);
					}
				}
			}
		}
		return fullDeck;
	}
	protected void setRules(){
		rules = "Enter groups of cards in the format (NumberShapeColorPattern) separated by \"/\" \n"
				+ "Numbers can be 1, 2 or 3\n"
				+ "Shapes can be c(circular), d(diamond) or s(squiggle)\n"
				+ "Colors can be r(red), g(green) or p(purple)/b(blue)\n"
				+ "Patterns can be f(filled), s(striped) or e(empty)";
	}
	public String getRules(){
		return rules;
	}
}
