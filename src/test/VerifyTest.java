package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyTest {
	

		
		public static boolean login(String first, char[] last) throws SQLException, ClassNotFoundException {
			
			
			// Accessing driver from the JAR File
			Class.forName("com.mysql.jdbc.Driver");
			
			//Creating a variable for the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "password");
			//DriverManager.getConnect
		
			
			
			System.out.println("in verifyTest");
			String string = new String(last);
			System.out.println("first = " + first);
			System.out.println("last = " + string);
			
		    try {	
		       if (first != null && last!=null) {
		    	   
			       String lastString = new String(last);
			       PreparedStatement stmt = con.prepareStatement("select * from names");
			       String sql = "Select * from names Where first='" + first + "' and last='"+ lastString + "'";
			       ResultSet rs = stmt.executeQuery(sql);
		       
			       if( rs.next()){
			            return true;
			       } else {
			           return false;
			       }
		   }
		    
		    } catch (SQLException err) {
	       // JOptionPane.showMessageDialog(this, err.getMessage());
		    }
			return false;
		}
}
