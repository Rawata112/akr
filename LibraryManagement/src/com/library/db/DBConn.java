package com.library.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConn {
	public static Connection connect() {
	Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/library","root","root");
	} catch (ClassNotFoundException e) {
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return con;
	}
}