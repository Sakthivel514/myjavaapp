package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		  String url="jdbc:mysql://localhost:3306/myshop";
		    String user="root";
		    String pass="";
		    try {
		    	 if(connection == null){
		    	 Class.forName("com.mysql.cj.jdbc.Driver");
		    connection=DriverManager.getConnection(url,user,pass);
		  
		    	 }
		    	
		    }catch(SQLException e) {
		    System.out.println(e);
		
		}
        return connection;
    }
}
