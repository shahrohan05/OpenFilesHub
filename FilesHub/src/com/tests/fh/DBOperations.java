package com.tests.fh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBOperations {
	
	public final static String DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL="jdbc:mysql://localhost/files_hub1";
	public final static String USER="root";
	public final static String PASS="";

	public static Statement getStatement() {
		Connection con=null;
		Statement stmt = null;
		try {
			Class.forName(DRIVER);
			con= DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return stmt;
		
	}
	
}
