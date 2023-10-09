package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.User;
import com.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		  PrintWriter out = response.getWriter();  
	 	User al = new User();
	 UserDao aa=new UserDao();
		
		
	 	  
	 	al.setName(request.getParameter("name"));  
	 	String e=(request.getParameter("email"));  
	 	al.setEmail(e);
	 	al.setAddress(request.getParameter("address")); 
	 	String str =(request.getParameter("phone")); 
	    long intValue = 0;

	      
	        if (str != null && str.matches("\\d+")) {
	            try {
	    
	                intValue = Long.parseLong(str);
	            } catch (NumberFormatException e1) {
	                out.println("Invalid input. Please enter a valid integer.");
	            }
	        } else {
	            out.println("Invalid input. Please enter a valid integer.");
	        }
	 
	 	al.setPhone(intValue);
		al.setPassword(request.getParameter("password"));
        		 int a = 0;
     			try {
     				try {
						a = aa.uregister(al);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
     			} catch (ClassNotFoundException e1) {
     				// TODO Auto-generated catch block
     				e1.printStackTrace();
     			}
     		
     	 	   if(a>=1) {
     	 		  RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
     		        rd.include(request,response);
     	 		   out.print("<h2>");
     	 		  out.print("Added success");
     	 		  out.print("</h2>");
     	 	   }else {
     	 		 aa.someMethod(request);
     	 		 String message1 = (String) request.getAttribute("message1");
     	 		String message2 = (String) request.getAttribute("message2");
     	 		String message = (String) request.getAttribute("message");
     	 	    if (message1 != null ) {
     	 	        request.setAttribute("message1", message1);
     	 	      RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
     	 	    dispatcher.forward(request, response);
     	 	    }else if(message2 !=null) {
     	 	      request.setAttribute("message2", message2);
     	 	    RequestDispatcher dispatcher =request.getRequestDispatcher("Register.jsp");
     	 	    		dispatcher.forward(request, response);
     	 	    }else if(message !=null) {
       	 	      request.setAttribute("message", message);
       	 	    RequestDispatcher dispatcher =request.getRequestDispatcher("Register.jsp");
       	 	    		dispatcher.forward(request, response);
       	 	    }
     	 	    else {
     	 	    
     	 	        response.getWriter().println("Message not found.");
     	 	    }
     	 	}

     	 	   }
     		


}
