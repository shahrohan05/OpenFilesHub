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
		this.confirmed = 0;
		this.email = "";
	}

	public int authenticate() {
		int result = 0;
		Statement stmt = DBOperations.getStatement();
		if(stmt==null) {
			result = 2;
		} else {
			String query="select * from users where uname=\'"+uname+"\';";
			try {
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()) {
					result=1;
					confirmed = (byte) rs.getInt("confirmed");
					String q_pass = rs.getString("pass");
					if(confirmed==0)
						result=3;
					else if(!pass.equals(q_pass)) {
						result=0;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				result=2;
				e.printStackTrace();
			}			
		}
		return result;
	
	}

	public int addUser() {
		int result=0;
		Statement stmt = DBOperations.getStatement();
		
		String query = "insert into users values(\""+uname+"\",\""+pass+"\",\""+email+"\",0);";
		try {
			int vals=stmt.executeUpdate(query);
			if(vals>0) 
				result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
