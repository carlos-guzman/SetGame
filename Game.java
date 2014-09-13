import java.util.ArrayList;
//1ore
//2dgs
//3spf
public class Game {
	int setCount, score;
	ArrayList<Card> table = new ArrayList<Card>();
	String[] setArray;

	protected String rules;
	public Game(){
		this("");
	}
	public Game(String preset){
		newGame(preset);
		setRules();
	}
	public void newGame(String preset){
		setCount = 0;
		if(!preset.equals(""))addCard(decodeString(preset));
		findSetCount();
	}
	public void findSetCount(){
		String str = "";
		setCount = 0;
		for(int i = 0; i<table.size();i++){
			for(int j = i+1; j<table.size(); j++){
				for(int k = j+1; k<table.size(); k++){
					if(checkSet(table.get(i), table.get(j), table.get(k))){
						setCount++;
						str+=table.get(i).toString()+"/"+table.get(j).toString()+"/"+table.get(k).toString()+"-";
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
		return "There are not that many sets";
	}
	public boolean submitSet(String s){
		Card[]cA = decodeString(s);
		// if(s.matches("[1-"+(setArray.length-1)+"]")) {
		// 	System.out.println(getValidSet(Integer.parseInt(s)-1));
		// 	return false;
		// }
		if(cA.length!=3)return false;
		return submitSet(cA[0], cA[1], cA[2]);
	}
	public boolean submitSet(int n){
		if(submitSet(getValidSet(n))) return true;
		return false;
	}
	public boolean submitSet(Card c1, Card c2, Card c3){
		if(!(checkSet(c1, c2, c3) && removeCard(c1) && removeCard(c2) && removeCard(c3))) return false;
		score++;
		return true;
	}
	public boolean removeCard(Card c){
		return table.remove(c);
	}
	public void addCard(Card c){
		table.add(c);
	}
	public void addCard(String c){
		addCard(new Card(c));
	}
	public void addCard(String c, Deck d){
		addCard(d.remove(new Card(c)));
	}
	public void addCard(Card[] newArray){
		for(int i=0;i<newArray.length;i++)
			if(!table.contains(newArray[i]))
				table.add(newArray[i]);
	}
	public Card[] decodeString(String str){
		String[] strArray = str.split("/");
		Card[] cArray = new Card[strArray.length];
		for(int i = 0; i<strArray.length; i++){
			cArray[i] = new Card(strArray[i]);
		}
		return cArray;
	}
	public static boolean isSet(String str){
		String[] strArray = str.split("/");
		if(strArray.length!=3) return false;
		for(String c : strArray)
			if(!Card.isCard(c)) return false;
		return true;
	}
	private boolean checkSet(Card c1, Card c2, Card c3){
		return (c1.compareColor(c2, c3) && c1.compareShape(c2, c3) && c1.comparePattern(c2, c3) && c1.compareNumber(c2, c3)
				&& !(c1.equals(c2) || c1.equals(c3) || c2.equals(c3))); 
	}
	public void deal(int n, Deck d){
		this.addCard(d.deal(n));

		System.out.println(toString());
	}
	public void deal(Card c, Deck d){
		this.addCard(d.remove(c));
	}
	public String toString(){
		findSetCount();
		String str = "Score: "+getScore()+"\n";//+" Sets: "+getSetCount()+" Cards: ("+table.size()+")";
		for(int i = 0; i<table.size(); i++){
			str+=" "+table.get(i).toString();
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
