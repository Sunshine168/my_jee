package org.db;
import java.sql.*;
public class DBConn{
	public static Connection conn;			
	public static Connection getConn(){
		String url = "jdbc:mysql://localhost/MBOOK";
		   String user = "root";
		   String password = "168496714";
		   try {
			     Class.forName("com.mysql.jdbc.Driver");
			     conn = DriverManager.getConnection(url,user,password);
		   }
		   catch(Exception exception ){exception.printStackTrace();}
		   return conn;
	}
	public static void CloseConn(){
		try{
			conn.close();					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
