package hotel.managment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn
{
	Connection c;
	Statement stmt;
	Conn() throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","alok");
			stmt = c.createStatement();
			
			
		}
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	 

}
