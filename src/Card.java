/* Brady Anderson
 * File: Card.java
 * Purpose: Definition for the playing Card class in Java.
 */
import java.util.*;

public class Card {
	
	private final int MAX_CARD = 13;// there are 13 cards in a suit.
	private final int MAX_SUIT = 4;// there are 4 suits in a deck
	private final int HEARTS = 0;
	private final int CLUBS = 1;
	private final int SPADES = 2;
	private final int DIAMONDS = 3;
	
	private int mySuit, myValue, masterValue;
	// master value is a unique identifier for every card in a standard deck
	
	Card() {/*********************************************************
	Constructor for the Card class.
	
	Preconditions: 	None.
	Postconditions: A card with a random value and
					suit has been generated. 
	*****************************************************************/
		Random generator = new Random();
		masterValue = generator.nextInt(52);
		myValue = masterValue % 13;
		mySuit = masterValue % 4;
		
	}
	
	Card(int num) {/***************************************************
	Explicit value constructor for a card
	
	Preconditions: receives an int value between 1 and 52 inclusive.
	Postconditions: returns a card with the value generated from the int.
	******************************************************************/
		myValue = num % 13;
		mySuit = num % 4;
		masterValue = num;
		
	}// end constructor
	
	public int getSuit() {
		return mySuit;
	}// end suit getter
	
	public int getValue() {
		return myValue;
	}// end myValue getter
	
	public int getMasterValue() {
		return masterValue;
	}// end masterValue getter
	
	public void display() { // displays the suit and value of the card object

		
		System.out.print("Suit: ");
		switch (mySuit) {
		case HEARTS:
			System.out.println("hearts.");
			break;
		case CLUBS:
			System.out.println("clubs.");
			break;
		case SPADES:
			System.out.println("spades.");
			break;
		case DIAMONDS:
			System.out.println("diamonds.");
			break;
		}// end switch
		
		System.out.print("My value is: ");
		if (myValue == 0)
			System.out.println("ace.");
		else if (myValue > 0 && myValue < 10)
			System.out.println((myValue + 1) + ".");
		else
			switch (myValue) {
			case 10:
				System.out.println("jack.");
				break;
			case 11:
				System.out.println("queen.");
				break;
			case 12:
				System.out.println("king.");
				break;
			default:
				System.out.println("... CHEATER!");
				break;
			}// end else
		
	}// end display
	
	
	
}// end class Card
