package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;
	
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/INSTITUTO";
		String user = "root";
		String password = "c@tolic@";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	

}
