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
	private int minBuyIn;			/** Minimum Buy In Allowed at the table **/
	private int maxBuyIn;			/** Maximum Buy In Allowed at the table **/
	private int	numOfDecks;			/** Number of decks ( single , double, six deck) **/
	
	
	private ArrayList<Player> listOfPlayers;
	
	public Table (int numOfDecks, int minBuyIn, int maxBuyIn) {
		this.numOfDecks = numOfDecks;
		this.minBuyIn = minBuyIn;
		this.maxBuyIn = maxBuyIn;
		
		switch (this.numOfDecks) {
		
			case 1:
				ArrayList<Integer> deck = new ArrayList<Integer>(52);
				System.out.println(deck.size());	
			case 2:
		}
	}
	
	public int getMinBuyIn() {
		return this.minBuyIn;
	}
	
	public int getMaxBuyIn() {
		return this.maxBuyIn;
	}
	
	public int getNumOfDecks() {
		return this.numOfDecks;
	}
	
	public static ArrayList<Integer> fillInDeck(ArrayList<Integer> deck){
		
		return deck;
	}
	
	public static ArrayList<Integer> shuffle(ArrayList<Integer> deck){
		
		return deck;
	
	}
	
	
}
