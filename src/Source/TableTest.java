package Source;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import Source.Table;

public class TableTest{

	ArrayList<Table> tables; 
	ArrayList<Card> deck;
	Player player = new Player(1000, 1, "hello", 1);
	
	public void setUp() {
		tables = new ArrayList<Table>();
		
		/** Table(numOfDecks, MinimumBet, MaximumBet) **/
		TableSelector.tables.add(new Table(6, 5, 1000));		// table 1		index = 0 
		TableSelector.tables.add(new Table(6, 5, 1000));		// table 2		index = 1
		TableSelector.tables.add(new Table(2, 25, 5000));		// table 3		index = 2
		TableSelector.tables.add(new Table(1, 25, 5000));		// table 4		index = 3
		TableSelector.tables.add(new Table(2, 100, 10000));	// table 5		index = 4
		TableSelector.tables.add(new Table(1, 100, 99999999));	// table 6	index = 5
	}
	
	public void tearDown() {
		tables = null;
		
	}
	
	@Test
	public void testTableNumber() {
		
		setUp();
		
		
		TableView tableView = new  TableView(1, player);
		assertEquals(tableView.getTableNumber(), 2);
		
		tableView = new TableView(4, player);
		assertEquals(tableView.getTableNumber(), 5);
		
		try {
			tableView = new TableView(6, player);
			fail();	// should throw an indexOutOfBounds Exception when trying to access object does not exist
		} catch (IndexOutOfBoundsException e ) {
			
		}
		
		tearDown();
		
	}
	
	@Test
	public void testMinBet() {
		setUp();
		
		TableView tableView = new  TableView(1, player);
		assertEquals(tableView.getThisTable().getMinBet(), 5);
		
		tableView = new TableView(2, player);
		assertEquals(tableView.getThisTable().getMinBet(), 25);
		
		tearDown();
		
	}
	
	@Test
	public void testMaxBet() {
		setUp();
		
		TableView tableView = new  TableView(1, player);
		assertEquals(tableView.getThisTable().getMaxBet(), 1000);
		
		tableView = new TableView(2, player);
		assertEquals(tableView.getThisTable().getMaxBet(), 5000);
		
		tearDown();
		
	}
	@Test
	public void testNumOfDecks() {
		setUp();
		
		TableView tableView = new  TableView(1, player);
		assertEquals(tableView.getThisTable().getNumOfDecks(), 6);
		
		tableView = new TableView(2, player);
		assertEquals(tableView.getThisTable().getNumOfDecks(), 2);
		
		tearDown();
		
	}
	
	@Test
	public void testFillInDeck() {
		setUp();
		
		
		TableView tableView = new TableView(1, player);
		ArrayList<Card> deck = tableView.getThisTable().getDeck();
		assertTrue(deck.isEmpty());
		tableView.getThisTable().fillInDeck(deck);
		assertFalse(deck.isEmpty());
		
		tearDown();
	}
	
	
	
	@Test
	public void testShuffleDeck() {
		setUp();
		
		
		TableView tableView = new TableView(1, player);
		ArrayList<Card> deck = tableView.getThisTable().getDeck();
		
		ArrayList<Card> beforeShuffle = tableView.getThisTable().fillInDeck(deck);
		
		/**
		for (int i =0 ; i < 4; i++) {
			System.out.println(deck.get(i).toString());
		} **/
		
		ArrayList<Card> afterShuffle = tableView.getThisTable().shuffle(deck);
		
		/**for (int i =0 ; i < 4; i++) {
			System.out.println(deck.get(i).toString());
		}	**/	
		
		
		assertFalse(beforeShuffle.equals(afterShuffle));
		tearDown();
		
	} 
	
	
}
