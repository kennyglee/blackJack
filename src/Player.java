import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */

/**
 * @author Kenny
 * 
 */

public class Player {

	// Final Constants,
	private final int MALE = 1;
	/** male is 1 **/
	private final int FEMALE = 2;
	/** female is 2 **/

	// Instance Variables
	private int chips;					/** how much the player has **/
	private int level;						/** level of the player **/
	private int sex;						/** 1 is male = one is female **/
	private String id;					/** userID **/
	private int totalHand;				/** addition of two cards **/
	private String password;			/** userPassword **/	
	private boolean isValid=false;		/** used for checking ID and PW **/

	public Player(int chips, int level, String id, int sex) {
		this.sex = sex;
		this.chips = chips;
		this.level = level;
		this.id = id;
	}

	public Player() {

	}

	public int getChips() {
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
	
	public void setChips(int chips) {
		this.chips = chips;
	}

	public String toString() {
		String whatToReturn;

		whatToReturn = " The player \" " + this.id + "\" (" + this.level
				+ ") has " + this.chips + ".";
		return whatToReturn;
	}

	/**
	 * creating account method
	 * @param id
	 * @param password
	 * @param chips
	 * @param sex
	 * @param level
	 * @return
	 * @throws SQLException
	 */
	public static Player createPlayer(final String id, final String password,
			final int chips, final int sex, final int level)
			throws SQLException {
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/blackJack", "root", "password");
		
		PreparedStatement pstm = null;
		try {

			String sqlStr = "INSERT INTO users SET ID=? , PW=?, CHIPS=?, SEX=?, LEVEL=?";
			pstm = con.prepareStatement(sqlStr);
			pstm.setString(1, id);
			pstm.setString(2, password);
			pstm.setInt(3, chips);
			pstm.setInt(4, sex);
			pstm.setInt(5, level);
			pstm.execute();
			System.out.println("fsdafd");
			Player player = new Player();
			player.id = id;
			player.password = password;
			player.chips = chips;
			player.sex = sex;
			player.level = level;

			return player;
		} catch (SQLException e) {
			System.out.println("Creating Account Error");
		} finally {

		}
		return null;

	}
	
	/**
	 *  comparing with the password in the DB
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean validatePassword(String id, final String password) {
		try { 
			isValid = (this.password.equals(password) || checkPassword(id, this.password, password));
			if (isValid) {
				this.password = null;		// after checking for validity destroy the pw
			}
			return isValid;
		} catch (Exception e) {
			System.err.println("error is validatePassword");
		}
		return false;
	}

	
	public static boolean checkPassword(String id, String typedPassword, String password) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackJack", "root", "password");
		PreparedStatement pstm = null;
		ResultSet rs =null;

		try {
			
			pstm = con.prepareStatement("SELECT PW from users WHERE PW=?");
			pstm.setString(1,  password);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				typedPassword = rs.getString("pwd");
			}
		
			
			if(password.equals(typedPassword)) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in checkPassword");
		} finally {
			
		}

		return false;
	}

	
	public static Player load(final String id) throws ClassNotFoundException, SQLException {

		
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blackjack", "root", "password");
		PreparedStatement pstm = null;
		ResultSet rs =null;
		Player player = null;
		
		
		try {
			String sqlstr = "SELECT * FROM users WHERE ID=?";
			pstm = con.prepareStatement(sqlstr);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			if(!rs.next()){
				return null; // if nothing is found
			}
			player = new Player();// initialized a new Player instance
			player.id = rs.getString("ID");
			player.password = rs.getString("PW");
			player.chips = rs.getInt("CHIPS");
			player.level = rs.getInt("LEVEL");
			player.sex = rs.getInt("SEX");
			
			
		} catch (SQLException e) {
			System.err.println("Error in Player load method");
		}
		
		return player;
		
	}
	
}
