package Source;

import java.util.ArrayList;

public class Play {
	
	private Player player;
	private boolean bust;
	public ArrayList<Card> hand;
	public ArrayList<Card> hand2;
	
public Play(Player player) {
	this.player = player;
}

	
	public void win(int amountWon) {
		this.player.getChips();
	}
	
	public void receiveCard(){
		
	}
	
	public boolean checkHand(){
		
		/* If sum of hand is over 21, change bust to true */
		return bust;
	}
	
	public void stand(){
		
	}
	
	
	public void buyInsurance(){
		
	}
	
	public int compareHand(Play player){
	
		return 0;
	}
	
	public boolean split(){
		return false;
	}
}
