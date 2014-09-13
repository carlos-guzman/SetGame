import java.util.ArrayList;
import java.lang.Math;
public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	public Deck(){
		resetDeck();
	}
	public Card[] deal(int n){
		if(deck.isEmpty()) return new Card[]{};
		if(n>deck.size())n=deck.size();
		Card[] dealt = new Card[n];
		for(int i=0;i<n;i++)
			dealt[i] = removeRandom();
		return dealt;
	}
	private Card removeRandom(){
		return deck.remove((int)(Math.random()*deck.size()));
	}
	public Card remove(Card c){
		deck.remove(c);
		return c;
	}
	private void resetDeck(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				for(int k=0;k<3;k++)
					for(int l=0;l<3;l++)
						deck.add(new Card(i, j, k, l));
	}
	public boolean isEmpty(){
		return deck.isEmpty();
	}
	public String toString(){
		String s = "";
		for(Card c : deck)
			s+=c+"\n";
		return s;
	}
}
