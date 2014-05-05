/**
 * 
 */

import java.util.ArrayList;

/**
 * @author Kenny
 *
 */

public class Table {
	
	// final constants
	private final int maxSeat = 6;  /** Maximum of 6 people per table **/
	
	//instance variables
	private int minBet;			/** Minimum Bet Allowed at the table **/
	private int maxBet;			/** Maximum Bet Allowed at the table **/
	private int	numOfDecks;			/** Number of decks ( single , double, six deck) **/
	
	
	private ArrayList<Player> listOfPlayers;
	
	public Table (int numOfDecks, int minBet, int maxBet) {
		this.numOfDecks = numOfDecks;
		this.minBet = minBet;	
		this.maxBet = maxBet;
		
		switch (this.numOfDecks) {
		
			case 1:
				ArrayList<Integer> deck = new ArrayList<Integer>(52);
			//	System.out.println(deck.size());	
			case 2:				// not complete
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
	
	public static ArrayList<Integer> fillInDeck(ArrayList<Integer> deck){
		// not complete
		return deck;
	}
	
	public static ArrayList<Integer> shuffle(ArrayList<Integer> deck){
		// not complete
		return deck;
	}
	
	public ArrayList<Player> getPlayers() {
		return listOfPlayers;
	}
	
	
}
