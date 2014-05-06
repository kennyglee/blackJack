package Source;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayTest {
	
	ArrayList<Table> tables; 
	ArrayList<Card> deck;
	Player player = new Player(1000, 1, "hello", 1);
	Play player1  = new Play(player);
	TableView tableView = new TableView(1, player);
	
	public void setUp(){
		
        tables = new ArrayList<Table>();
		
		/** Table(numOfDecks, MinimumBet, MaximumBet) **/
		TableSelector.tables.add(new Table(6, 5, 1000));		// table 1		index = 0 
		TableSelector.tables.add(new Table(6, 5, 1000));		// table 2		index = 1
		TableSelector.tables.add(new Table(2, 25, 5000));		// table 3		index = 2
		TableSelector.tables.add(new Table(1, 25, 5000));		// table 4		index = 3
		TableSelector.tables.add(new Table(2, 100, 10000));	// table 5		index = 4
		TableSelector.tables.add(new Table(1, 100, 99999999));	// table 6	index = 5
		
		tableView = new TableView(1, player);
		deck = tableView.getThisTable().getDeck();
		tableView.getThisTable().fillInDeck(deck);
	}

	public void tearDown(){
		tables = null;
		tableView = null;
		deck = null;
		tableView = null;
	}
	
	@Test
	public void testReceiveCard(){
		
		setUp();
		
		player1.receiveCard();
		player1.receiveCard();
		assertFalse(player1.hand.isEmpty());
		assertTrue(player1.hand.size() == 2);
		
		player1.hand = new ArrayList<Card>();
		player1.hand.add(new Card(1,10));
		player1.hand.add(new Card(2,10));
		player1.hand.add(new Card(3, 10));
		
		assertTrue(player1.checkHand());
		
		tearDown();
		
	}
	
	
	@Test
	public void testStand() {
		
		setUp();
		
		Play player1copy = new Play(player);
		player1.hand = new ArrayList<Card>();
		player1copy.hand = new ArrayList<Card>();
		
		player1.receiveCard();
		player1.receiveCard();
		player1copy.receiveCard();
		player1copy.receiveCard();
		
		player1.stand();
		assertTrue(player1.hand.equals(player1copy.hand)); //player1 remains unchanged after stand
		
		tearDown();
	}
	
	@Test
	public void testSplit(){
		
		setUp();
		
		player1.hand = new ArrayList<Card>();
		
		player1.hand.add(new Card(1,1));
		player1.hand.add(new Card(1,1));
		
		player1.split();
		assertTrue(player1.hand2 != null);
		
		player1.hand = new ArrayList<Card>();
		player1.hand2 = new ArrayList<Card>();
		
		player1.hand.add(new Card(1, 2));
		player1.hand.add(new Card(1, 1));
		
		assertFalse(player1.split());
		
		tearDown();
		
	}
	
	@Test
	public void testCompareHand(){
		
		setUp();
		
		Play dealer = new Play(player);
		dealer.hand = new ArrayList<Card>();
		player1.hand = new ArrayList<Card>();
		
		player1.hand.add(new Card(1, 1));
		player1.hand.add(new Card(1, 10));
		
		dealer.hand.add(new Card(1, 2));
		dealer.hand.add(new Card(1, 10));
		
		assertTrue(player1.compareHand(dealer) == -1);
		
		dealer.hand = new ArrayList<Card>();
		player1.hand = new ArrayList<Card>();
		
		player1.hand.add(new Card(1, 3));
		player1.hand.add(new Card(1, 10));
		
		dealer.hand.add(new Card(1, 2));
		dealer.hand.add(new Card(1, 10));
		
		assertTrue(player1.compareHand(dealer) == 1);

		dealer.hand = new ArrayList<Card>();
		player1.hand = new ArrayList<Card>();
		
		player1.hand.add(new Card(1, 2));
		player1.hand.add(new Card(1, 10));
		
		dealer.hand.add(new Card(1, 2));
		dealer.hand.add(new Card(1, 10));
		
		assertTrue(player1.compareHand(dealer) == 0);
		
		
		tearDown();
		
	}

}
