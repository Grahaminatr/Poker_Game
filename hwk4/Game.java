import java.util.Scanner;

public class Game {

	public Game() {
	}

	// public method that calls all the checks. Ensures no double counting by
	// working from top to bottom (Royal flush to High Card)
	public void check(Card[] h) {

		if (isRoyalFlush(h)) {
			System.out.println("YOU GOT A ROYAL FLUSH!!!!");
			return;
		} else if (isStraightFlush(h)) {
			System.out.println("YOU GOT A STRAIGHT FLUSH!!");
			return;
		} else if (isFourOfaKind(h)) {
			System.out.println("YOU GOT A FOUR OF A KIND!");
			return;
		} else if (isFullHouse(h)) {
			System.out.println("You got a Full House!!!");
			return;
		} else if (isFlush(h)) {
			System.out.println("You got a flush!!");
			return;
		} else if (isStraight(h)) {
			System.out.println("You got a straight!");
			return;
		} else if (isThreeOfaKind(h)) {
			System.out.println("You got a three of a kind!");
			return;
		} else if (isTwoPair(h)) {
			System.out.println("You got a Two Pair.");
			return;
		} else if (isPair(h)) {
			System.out.println("You got a pair.");
			return;
		} else {
			// Makes sure that there if an Ace in your hand, it is considered
			// the high card not low card
			if (h[0].getValue() == 0)
				System.out.println("You only got a high card: "
						+ h[0].toString());
			else
				System.out.println("You only got a high card: "
						+ h[4].toString());
		}
	}

	// method to check if hand is a royal flush (if hand is a straight, is a
	// flush, and the second card is a 10, it's a royal flush)
	private boolean isRoyalFlush(Card[] h) {

		boolean royalFlush = false;

		if (isStraight(h) && isFlush(h) && h[1].getValue() == 9)
			royalFlush = true;

		return royalFlush;
	}

	// method to check if hand is a straight flush (hand is a straight, a flush,
	// and NOT a royal flush)
	private boolean isStraightFlush(Card[] h) {
		boolean straightFlush = false;

		if (isStraight(h) && isFlush(h) && !(h[1].getValue() == 10))
			straightFlush = true;

		return straightFlush;
	}

	// method to check if hand is a four of a kind
	private boolean isFourOfaKind(Card[] h) {
		boolean fourOfaKind = false;
		Card[] hand;
		hand = h;
		// since my hand is in order, the middle card MUST be one of the four
		int commonValue = hand[2].getValue();
		int counter = 0;

		// for loop to count number of repeat values
		for (int i = 0; i < 5; i++) {
			if (hand[i].getValue() == commonValue)
				counter++;
		}

		if (counter == 4)
			fourOfaKind = true;

		return fourOfaKind;

	}

	// method to check if it's a full house (hand has three of a kind and the
	// other two cards are a pair)
	private boolean isFullHouse(Card[] h) {
		boolean fullHouse = false;
		Card[] hand = h;

		if (isThreeOfaKind(hand) && isPair(hand))
			fullHouse = true;

		return fullHouse;
	}

	// method to check if hand is a flush
	private boolean isFlush(Card[] h) {
		boolean flush = false;
		Card[] hand;
		hand = h;
		int commonSuit = hand[0].getSuit();
		int counter = 0;

		// for loop to count number of repeat suits (needs to be 5)
		for (int i = 0; i < 5; i++) {
			if (hand[i].getSuit() == commonSuit)
				counter++;
		}

		if (counter == 5)
			flush = true;

		return flush;

	}

	// method to check if hand is a straight
	private boolean isStraight(Card[] h) {
		boolean straight = false;
		Card[] hand;
		hand = h;
		int startValue = hand[0].getValue();

		// if statement to ensure that ace can be high or low (A2345 as well as
		// 10JQKA are straights)
		if (hand[0].getValue() == 0 && hand[1].getValue() == 9
				&& hand[2].getValue() == 10 && hand[3].getValue() == 11
				&& hand[4].getValue() == 12) {

			straight = true;
			return straight;

		} else {
			// for loop checks if each successive card is one higher (we can do
			// this because hand is sorted)
			for (int i = 1; i < 5; i++) {
				if (hand[i].getValue() == startValue + i)
					straight = true;

				else {
					straight = false;
					return straight;
				}
			}
		}

		return straight;
	}

	// method to check for three of a kind
	private boolean isThreeOfaKind(Card[] h) {
		boolean threeOfaKind = false;
		Card[] hand = h;
		// since hand is in order, middle card MUST be one of the 3
		int commonValue = hand[2].getValue();
		int counter = 0;

		for (int i = 0; i < 5; i++) {
			if (hand[i].getValue() == commonValue)
				counter++;
		}

		if (counter == 3)
			threeOfaKind = true;

		return threeOfaKind;
	}

	// method to check if there are two pairs
	private boolean isTwoPair(Card[] h) {
		boolean twoPair = false;
		Card[] hand = h;
		int counter = 0;

		for (int i = 0; i < 4; i++) {
			if (hand[i].getValue() == hand[i + 1].getValue())
				counter++;
		}

		if (counter == 2)
			twoPair = true;

		return twoPair;
	}

	// method to check if there is a pair
	private boolean isPair(Card[] h) {
		boolean pair = false;
		Card[] hand = h;
		int pairCounter = 0;

		for (int i = 0; i < 4; i++) {
			if (hand[i].getValue() == hand[i + 1].getValue())
				pairCounter++;
		}

		// Second part of or statement is to make sure when we are checking for
		// isFullHouse using isThreeOfaKind and isPair, isPair isn't true if
		// hand only has three of a kind
		if (!(pairCounter == 0 || pairCounter == 2))
			pair = true;

		return pair;
	}

	// play method that starts game by creating a deck, shuffling it, and
	// creating a player. Then it conducts the game
	public void play() {

		String repeat = "y";
		Scanner input = new Scanner(System.in);

		while (repeat.equals("y")) {
			Deck gameDeck = new Deck();
			Player user = new Player(gameDeck);
			gameDeck.shuffle();

			user.dealHand();
			user.sayHand();
			user.play();
			user.sayHand();
			check(user.getHand());// checks and prints results

			System.out
					.println("\n \nWould you like to play again? (y-yes/n-no)");
			do {
				repeat = input.next();
				if (!(repeat.equals("y") || repeat.equals("n")))
					System.out
							.println("That is an invalid response (y-yes/n-no)");
			} while (!(repeat.equals("y") || repeat.equals("n")));
		}

	}

}//end class
