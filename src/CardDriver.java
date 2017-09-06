/* FILE: CardDriver.java
 * Programmer: Brady Anderson
 * Purpose: Generates five unique cards and displays them and displays the remaining deck
 */

public class CardDriver {
	final int CARDS_IN_DECK = 52;
	
	public static void main(String[] args) {
		Deck theCards = new Deck();
		Card card1 = new Card(theCards.drawCard());
		Card card2 = new Card(theCards.drawCard());
		Card card3 = new Card(theCards.drawCard());
		Card card4 = new Card(theCards.drawCard());
		Card card5 = new Card(theCards.drawCard());
		
		for (int i = 0; i < 52; i++) {
			System.out.println(theCards.drawCard());
		}// end for
		
		card1.display();
		System.out.println("");
		card2.display();
		System.out.println("");
		card3.display();
		System.out.println("");
		card4.display();
		System.out.println("");
		card5.display(); 
		System.out.println("");

	}// end CardDriver

}
