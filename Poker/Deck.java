import java.util.ArrayList;

//Deck class has IVs ArrayList deck and int top.  top keeps track of the top 
//card which is the next card to be dealt.  Note: deck is an ArrayList because 
//we don't always know deck size-it will vary depending on player's exchanges
public class Deck {
	private ArrayList<Card> deck;
	private int top;

	public Deck() {
		deck = new ArrayList<Card>(52);
		top = -1;
		int counter = 0;

		// for loop creates a deck with 52 cards, Ace-King and for suits Clubs,
		// Diamonds, Hearts, and Spades
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {

				Card temp = new Card(j, i);
				deck.add(counter, temp);
				counter++;

			}//end inner for loop (value)

		}//end outer for loop (suit)

	}

	// mutator method to shuffle the deck. Takes two random cards (1-52) and
	// swaps them, iterates 1000 times
	public void shuffle() {

		for (int i = 0; i < 1000; i++) {

			int j = (int) (Math.random() * 52);
			int k = (int) (Math.random() * 52);

			Card temp = deck.get(j);
			deck.set(j, deck.get(k));
			deck.set(k, temp);

		}//end for loop

	}

	// accessor method to grab top card. Used when dealing hand and exchanging
	// cards.
	public Card getTop() {
		top++;
		return deck.get(top);
	}

}//end class
