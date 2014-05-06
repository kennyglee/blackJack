package Source;
/**
 * 
 */

/**
 * @author Kenny
 *
 */
public class Card {

	// final constants 
	private final int SPADE = 1;	/** SPADE **/
	private final int HEARTS = 2;	/** HEARTS **/
	private final int CLUBS = 3;	/** CLUBS **/
	private final int DIAMONDS = 4;	/** DIAMONDS **/
	
	// instance variables
	private int suit;				/** refer to final constants **/
	private int value;				/** A = 1 or 11;  J Q K 10  = 10 **/
	
	



public Card(int suit, int value) {
	
	this.suit = suit;
	this.value = value;
}

public String toString() {
	return ( "the suit is = " + this.suit + " the value is = " + this.value);
}
}



