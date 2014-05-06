package Source;
/**
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kenny
 *
 */

public class Table {
	
	// final constants
	private final int maxSeat = 6;  /** Maximum of 6 people per table **/
	
	//instance variables
	private int minBet;							/** Minimum Bet Allowed at the table **/
	private int maxBet;							/** Maximum Bet Allowed at the table **/
	private int	numOfDecks;					/** Number of decks ( single , double, six deck) **/
	private ArrayList<Card> deck; 
	
	private ArrayList<Player> listOfPlayers;
	
	public Table (int numOfDecks, int minBet, int maxBet) {
		this.numOfDecks = numOfDecks;
		this.minBet = minBet;	
		this.maxBet = maxBet;
		
		switch (this.numOfDecks) {
		
			case 1:
				deck = new ArrayList<Card>(52);
				break;
			case 2:				
				deck = new ArrayList<Card>(104);
				break;
			case 6:
				deck = new ArrayList<Card>(312);
				break;
		}
	}
	
	/**
	 * Getter method for minimum Bet for this table
	 * @return minimum Bet for this table
	 */
	public int getMinBet() {
		return this.minBet;
	}
	
	/**
	 * Getter method for maximum Bet for this table
	 * @return maximum Bet for this table
	 */
	public int getMaxBet() {
		return this.maxBet;
	}
	
	/**
	 * Getter method for getting the number of decks
	 * @return numOfDecks for this table
	 */
	public int getNumOfDecks() {
		return this.numOfDecks;
	}
	
	/** 
	 * Getter method for getting the Deck
	 * 	@return Deck for this table
	 */
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public static ArrayList<Card> fillInDeck(ArrayList<Card> deck){
		
		Card card1 = new Card(1,1);
		Card card2 = new Card(1,2);
		Card card3 = new Card(1,3);
		Card card4 = new Card(1,4);
		deck.add(card1);
		deck.add(card2);
		deck.add(card3);
		deck.add(card4);
		// not complete
		return deck;
	}
	
	public static ArrayList<Card> shuffle(ArrayList<Card> deck){
		//****** not completeeeeee ***//
		
		
		Collections.shuffle(deck);
		return deck;
		
	}
	
	public ArrayList<Player> getPlayers() {
		return listOfPlayers;
	}
	
	
}
