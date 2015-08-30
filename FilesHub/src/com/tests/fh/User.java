package com.tests.fh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

public class User {
	String uname;
	String pass;
	String email;
	byte confirmed;
	
	public User(String name, String pass, String email, byte confirmed) {
		super();
		this.uname = name;
		this.pass = pass;
		this.email = email;
		this.confirmed = confirmed;
	}
		
	public User() {
		super();
	}

	public User(String name,String pass) {
		super();
		this.uname = name;
		this.pass = pass;
	}

	public int authenticate() {
		int result = 0;
		Statement stmt = DBOperations.getStatement();
		if(stmt==null) {
			result = 2;
		} else {
			String query="select * from users where uname=\'"+uname+"\' and pass=\'"+pass+"\';";
			try {
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) {
					result=1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				result=2;
				e.printStackTrace();
			}			
		}
		return result;
	
	}




	/* Getters & Setters */
	public String getUname() {
		return uname;
	}

	public void setUname(String name) {
		this.uname = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(byte confirmed) {
		this.confirmed = confirmed;
	}
	
	

}
