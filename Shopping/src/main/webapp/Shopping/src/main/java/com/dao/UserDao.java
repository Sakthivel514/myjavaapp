package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.DbCon;

import jakarta.servlet.http.HttpServletRequest;



public class UserDao {
	private Connection con;
	private String query;
	private String email;
	private  long phone;
	private String q1;
	private long p;
    private PreparedStatement pst;
    private ResultSet rs;
	public UserDao(Connection con) {
		this.con = con;
	}

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public User userLogin(String email, String password) {
		User user = null;
        try {
        
        	query = "select * from users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	user.setAddress(rs.getString("address"));
            	user.setPhone(rs.getInt("phone"));
            	user.setPassword(rs.getString("password"));
            
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	public int uregister(User al) throws ClassNotFoundException, SQLException {
		int n=0;
		   String email=(String) al.getEmail();
		   this.email=email;
	         long phone=( (long) al.getPhone());
	         this.phone=phone;
	     query = "select email,phone from  users ";
	     Connection con = DbCon.getConnection();
         pst = con.prepareStatement(query);

         rs = pst.executeQuery();
         while (rs.next()) {
        	String q1= rs.getString("email");
        	this.q1=q1;
        	
        		long p=rs.getLong("phone");
        		this.p=p;
         	if(!email.equals(q1) ) {
         		
         	
         	if(phone != p) {
		String q="insert into users (name,email,address,phone,password)values(?,?,?,?,?)";
		try {
		
		PreparedStatement pst=con.prepareStatement(q);
		pst.setString(1,al.getName());
		pst.setString(2,al.getEmail());
		pst.setString(3,al.getAddress());
		pst.setLong(4,al.getPhone());
		pst.setString(5,al.getPassword());
		n=pst.executeUpdate();
		}catch (SQLException e) {
            System.out.print(e.getMessage());
        }
         	
         	}}
         	}
         return n;
     
	}

	public  void someMethod(HttpServletRequest request) {
		if(email.equals(q1)) {
	    String message1 ="email alreay register";
		   request.setAttribute("message", message1);
		}else if(phone==(p)){
			  String message2="phone number  alreay register";
			request.setAttribute("message", message2);
		}else {
			  String message="error";
				request.setAttribute("message", message);
		}
	}

}
