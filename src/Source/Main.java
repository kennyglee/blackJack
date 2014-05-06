package Source;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class Main {
// jdbc id cse110ucsd
	//	  pw kennyglee
	public static void main(String[] args) throws Exception {
		// Accessing driver from the JAR File
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("hello");
		String url3 = "jdbc:mysql://99.52.100.42:3306/testdb";
		String url = "jdbc:mysql://www.lineageuni.com/db_phpmyadmin/cse110.lineageuni.com";
		String url2 = "jdbc:mysql://OPENSHIFT_MYSQL_DB_HOST:OPENSHIFT_MYSQL_DB_PORT/cse110ucsd";
		String url4 = "jdbc:mysql://cse110ucsd-kennyglee.rhcloud.com/127.1.252.130:3306/cse110ucsd";
		String url5 = "jdbc:mysql://127.1.252.130:3306/cse110ucsd";
		//Creating a variable for the connection
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root", "password");
		Connection con = DriverManager.getConnection(url5 , "root" , "kennyglee");
		//DriverManager.getConnect 
	//	PreparedStatement statement = con.prepareStatement("select * from id");
		//PreparedStatement pstm = con.prepareStatement("SELECT PW from users WHERE PW=?");
				System.out.println("bye");
		/*ResultSet result = pstm.executeQuery();
		System.out.println("hi");
		while(result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2));
			
		}*/
		
	}

}
