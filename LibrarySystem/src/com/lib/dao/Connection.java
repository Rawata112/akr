package com.lib.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	public static java.sql.Connection getCon() {
		java.sql.Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost/library","root","root");
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		}
}
