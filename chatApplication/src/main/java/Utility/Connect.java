package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public static Connection getConnect() {
		Connection con = null;
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapplication", "root","Squ@d123");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;		
	}


}
