public class Card implements Comparable<Card> {
	// IV suit and Value. Every Card has its own suit and value.
	private int suit;
	private int value;

	public Card(int v, int s) {
		suit = s;
		value = v;
	}

	// accessor method to get int of suit (0-Clubs, 1-Diamonds, 2-Hearts,
	// 3-Spades)
	public int getSuit() {
		return suit;
	}

	// accessor method to get value of Card (Ace, 2, 3, ...., King, (Ace))
	public int getValue() {
		return value;
	}

	// toString method so we can easily outprint the actual playing card. Note:
	// the index is 1 less than the actual facevalue of card since index starts
	// at 0
	public String toString() {

		String cardString;
		String[] arrayOfValues = { "Ace", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "Jack", "Queen", "King" };
		String[] arrayOfSuits = { "clubs", "diamonds", "hearts", "spades" };

		cardString = arrayOfValues[value] + " of " + arrayOfSuits[suit];
		return cardString;

	}

	// compareTo method so we can easily sort the hand by value and suit so we
	// finding results is easier.
	public int compareTo(Card other) {
		int p = -99;
		if (this.getValue() < other.getValue())
			p = -1;
		if (this.getValue() > other.getValue())
			p = 1;
		if (this.getValue() == other.getValue()) {
			if (this.getSuit() < other.getSuit())
				p = -1;
			if (this.getSuit() > other.getSuit())
				p = 1;

		}

		return p;

	}

}//end class
