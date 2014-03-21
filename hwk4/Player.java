import java.util.Scanner;
import java.util.Arrays;

//Every Player has an five card array (hand), input, and a deck
public class Player {
	private Card[] hand;
	private Scanner input;
	private Deck playersDeck;

	public Player(Deck d) {
		hand = new Card[5];
		playersDeck = d;
		input = new Scanner(System.in);

	}

	// Give the array hand five cards from the top of the deck
	public void dealHand() {
		for (int i = 0; i < 5; i++) {
			hand[i] = playersDeck.getTop();
		}
	}

	// method to sort the hand by value/suit and then out print contents
	// of hand.
	public void sayHand() {
		System.out.println("Here is your hand: ");
		System.out.println("");
		sort();
		for (int i = 1; i < 6; i++) {
			System.out.println(i + ": " + hand[i - 1]);
		}
	}

	// method to sort hand
	private void sort() {
		Card[] temp = new Card[5];
		for (int i = 0; i < 5; i++)
			temp[i] = hand[i];

		Arrays.sort(temp);

		for (int i = 0; i < 5; i++)
			hand[i] = temp[i];

	}

	// method that returns true if the given string
	// contains characters or spaces. Use to check if user's
	// exchange input only contains numbers with no characters or spaces.
	private boolean containsCharacters(String n) {

		boolean isCharacter = false;
		String temp;
		for (int i = 0; i < n.length(); i++) {

			temp = n.substring(i, i + 1);
			// checks to see if all characters are digits
			if (!Character.isDigit(n.charAt(i)))
				isCharacter = true;
			// ensures than only numbers 1-5 are inputted
			if (temp.equals("6") || temp.equals("7") || temp.equals("8")
					|| temp.equals("9") || temp.equals("0"))
				isCharacter = true;
		}// end for loop

		return isCharacter;
	}

	// method to check if user's input has any duplicate exchanges. This should
	// not be allowed, you cannot exchange a card twice.
	private boolean hasDuplicates(String check) {
		int counter = 0;
		String temp;
		String compare;

		// Very similar to last problem on midterm 1. For each element in the
		// user's input, I check to see if there are repeats of that value.
		for (int i = 0; i < check.length(); i++) {
			temp = check.substring(i, i + 1);
			for (int j = 0; j < check.length(); j++) {
				compare = check.substring(j, j + 1);
				if (temp.equals(compare)) {
					counter++;
				}

			}
		}
		if (counter == check.length())
			return false;
		else
			return true;

	}

	// The Play method outprints instructions on how to play and allows them to
	// exchange cards by their position number
	public void play() {
		int[] positionsList;
		String exchange = "";

		System.out.println("");
		int error = 0;

		// while loop to ensure we get a valid response
		
			System.out.println("Please enter the position of the cards to be" +
					" EXCHANGED. Do not put spaces in between \nnumbers.  For " +
					"example, if you would like to exchange the " + hand[1] + 
					" and " + hand[3] + " enter 24. \nIf you don't want to " +
					"exchange any cards," + " just press enter");
			while (error == 0) {
				exchange = input.nextLine();
			if (containsCharacters(exchange))
				System.out
						.println("Please do enter any characters, spaces, or invalid numbers.  Only enter numbers 1-5");
			else if (hasDuplicates(exchange))
				System.out
						.println("You cannot exchange a number more than once");
			else
				error++;

		}// end while loop

		// Once we get a valid exchange input, an array is created
		positionsList = new int[exchange.length()];
		for (int i = 0; i < exchange.length(); i++) {
			positionsList[i] = Integer.parseInt(exchange.substring(i, i + 1));
		}

		// for loop so we can discard unwanted cards and deal new ones using
		// getTop()
		for (int i = 0; i < positionsList.length; i++) {
			hand[positionsList[i] - 1] = playersDeck.getTop();
		}

	}

	// accessor method to get hand array for the game to check results
	public Card[] getHand() {
		return hand;
	}

}//end class
