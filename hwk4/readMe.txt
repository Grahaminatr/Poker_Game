

	I divided my Video Poker program into five different classes: Card, Deck, Player, Game, and a Test class.  
My Card class has two instance variables, suit and value.  Every card in a 52 card deck has a value from 1-13
(Ace, 2, 3, … , Jack, Queen, King)  and a suit 1-4 (Clubs, Diamonds, Hearts, Spades).  My constructor's parameters 
are therefore value and suit.  In the Card class I make two accessor methods getSuit(), which returns the integer 
representation of the suit (0-Clubs, 1-Diamonds, 2-Hearts, 3-Spades), and getValue(), returning the integer 
representation of the value (1-13).  I have a toString() method with arrays for suits and values so that printing 
actual face values of the card is simple.  I also have a compareTo() method returning a negative number if the 
implicit parameter is less than the explicit parameter and a positive number if the implicit is greater than the 
explicit.  If they are equal, it orders the two cards by suits (alphabetically).  
	
	My deck class has two IVs: an ArrayList and and int top (top of the deck).  I made it an ArrayList because 
the size of the array varies since we do not know how many cards the player is going to exchange.  The constructor 
creates a 52 card deck in order by value and suit.  The shuffle() method takes two random cards and swaps them.  
This process is iterated 1000 times, which shuffles the deck well.  I also have a getTop() method which returns a 
Card so that we can deal hands as well as cards if the player wants to exchange cards.  
	
	In my Player class, every player is given a 5 card hand (array) and a 52 card deck.  I have a dealHand() 
method when fills the 5 card array up with the top five cards of the deck.  I have a sort() which sorts the cards 
by their Values and Suits.  The sort method is private because only the sayHand() method calls it.  Therefore, the 
sayHand() method sorts the hand and then out prints the face values of the hand.   My play method gives the player 
an opportunity to exchange up to 5 cards after seeing the hand.  I have two private methods that return booleans: 
hasDuplicates() and containCharacters().  The combination of these two methods in the play method ensures that the 
user input is valid (contains only numbers 1-5 with no characters, spaces, or repeats).  My last method is getHand(), 
which just returns the players hand so that later the Game class can check the results.  
	
	The Game class main purpose is to create a game using the Card, Deck, and Player class and then checking the 
results of the hand.  The play() method starts a game by creating a deck, shuffling it, and creating a player.   Then 
it begins to conduct the game by dealing hand, showing the hand, ask the player if they want to exchange any card, and 
so forth.  Eventually the final hand is set, and that's when we call the check() method which calls all individual 
checks in order (best to worst) so that there are no double counts.  For example, if a player gets a royal flush, you 
would not want to out put that they got a straight and a flush as well.  I explain briefly in my code what each of the 
10 checks do (isRoyalFlush, isStraightFlush, isFourOfaKind, isFullHouse, isFlush, isStraight, isThreeOfaKind, isTwoPair, 
isPair, or else just a high card).
	
	Finally, my last class is just a TestClass.  This contains the main class which simply creates a new instance of 
a game which calls the method play.  It's always nice to keep the TestClass simple and with object-oriented programing, 
bugs are easier to locate.  
