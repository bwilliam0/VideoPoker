/* Brady Anderson
 * File: Deck.java
 * Purpose: Creates a deck of randomly ordered cards to draw from. 
 */
import java.util.*;

public class Deck {
	
	//private boolean autoShuffle = true;// should the deck automatically shuffle when the cards run out?
	private int[] myCards = new int[52];// and array of every cards identifier
	private int topCard = 0;// stores the index of the top card
	
	Deck() {/**********************************************************
	Constructor for a deck object
	
	Preconditions: None
	Postconditions: A deck with 52 unique values has been generated.
	******************************************************************/
		topCard = 0;
		Random generator = new Random();
		for (int i = 0; i < 52; i++) {				
			do {				//continues to generate new random values until it generates a new value
				myCards[i] = generator.nextInt(52);
			} while (!isUnique(myCards[i], i));
		}// end for loop
	}// end Deck constructor
	
	public int drawCard() {/*******************************************
	draws the top card from the deck
	
	Preconditions: the deck has been created
	Postconditions: The deck returns the int at topCard. If the deck is
					empty the shuffle function will be called. 
	******************************************************************/
		topCard++;
		if (topCard > 52) {
			shuffle();
			topCard++;
			return myCards[topCard - 1];
		}// end if
		else
			return myCards[topCard - 1];
	}// end drawCard
	
	public void shuffle() {/*******************************************
	Creates a new deck and shuffles it
	
	Preconditions: None.
	Postconditions: A new deck has been created and filled with randomly
					ordered cards. 
	*******************************************************************/
		topCard = 0;
		Random generator = new Random();
		for (int i = 0; i < 52; i++) {				
			do {				//continues to generate new random values until it generates a new value
				myCards[i] = generator.nextInt(52);
			} while (!isUnique(myCards[i], i));
		}// end for loop
	}// end shuffle
	
	private boolean isUnique(int num, int pos) {/**********************
	Helper for the deck constructor
	
	Preconditions: pos must be a valid position in the array
	Postconditions: Tells you if the new card is unique
	******************************************************************/
		for (int i = 0; i < pos; i++) {		//scans all cards up to the new card to ensure there
			if (myCards[i] == num)			//are no duplicates
				return false;
		}// end for loop
		return true;
	}// end isUnique

	
}// end Deck class
