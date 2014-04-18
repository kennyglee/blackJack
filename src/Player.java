/**
 * 
 */

/**
 * @author Kenny
 *
 */

public class Player {
	
	// Final Constants,
	private final int MALE = 1 ; 	/** male is	1 **/
	private final int FEMALE = 2;	/** female is 2 **/
	
	// Instance Variables
	private int chips;		/** how much the player has **/
	private int level;		/** level of the player  **/
	private int sex;		/** 1 is male = one is female **/
	private String id;		/** userID **/
	private int totalHand;	/** addition of two cards **/
	
	
	public Player (int chips, int level, String id, int sex){
		this.sex = sex;
		this.chips = chips;
		this.level = 0;
		this.id = id;
	}
	
	public int getChips(){
		return this.chips;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getSex() {
		return this.sex;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String toString() {
		String whatToReturn;
		
		whatToReturn = " The player \" " + this.id + "\" ("+ this.level + ") has " + this.chips + ".";
		return whatToReturn;
	}
}
