<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.connection.DbCon"%>
<%@page import="com.dao.UserDao"%>

<%@page import="com.dao.User"%>
<%@page import="com.model.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>

<%@include file="/includes/head.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <script>
        function validateMobileNumber(input) {
            var cleaned = input.value.replace(/\D/g, '');
            if (cleaned.length < 10) {
                alert("Please enter a valid 10-digit mobile number.");
                input.value = "eg-8976347645";
            } else if (cleaned.length === 10) {
                alert("Mobile number is valid. It contains 10 digits.");
            } else {
                alert("Mobile number is too long. It contains more than 10 digits.");
                input.value = "eg-8976347645";
            }
        }
    </script>
</head>
<body>


	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Registration</div>
			<div class="card-body">
				<form action="UserRegister" method="post">
				<div class="form-group">
						<label>Name</label> 
						<input type="text" name="name" class="form-control" placeholder="Enter Name" required>
					</div>
					<div class="form-group">
						<label>Email address</label> 
						<input type="email" name="email" class="form-control" placeholder="Enter email" required>
					</div>
					<div class="form-group">
						<label>Address</label> 
						<input type="text" name="address" class="form-control" placeholder="Enter Address" required>
					</div>
					<div class="form-group">
						<label>phone</label> 
						<input type="text" name="phone" class="form-control" placeholder=" Enter Mobile Number" onchange="validateMobileNumber(this)" required>
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Enter Password" aria-describedby="passwordHelpInline" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Register</button>
			       <a class="btn btn-sm btn-danger" href="login.jsp">Login</a>

					</div>
					 
  
                
				</form>
			</div>
		</div>
	</div> 
	                 
	    <%
          String message1 = (String) request.getAttribute("message1");
	       String message2 = (String) request.getAttribute("message2");
	      String message = (String) request.getAttribute("message");
	   
        if (message1 != null) {
        	 %>
              <div class="alert alert-danger" role="alert" align="center">
        <p>${message1}</p>
    </div>
    <% } else if(message2 !=null)
    { %>
         <div class="alert alert-danger" role="alert" align="center">
        <p>${message2}</p>
    </div>
     <% } else if(message !=null){ %>
         <div class="alert alert-danger" role="alert" align="center">
        <p>${message}</p>
    </div>
    <%
        } else {
    %> <div class="alert alert-danger" role="alert" align="center">
            <p>No message available.</p>
             </div>
    <% }
        %>

	<%@include file="/includes/footer.jsp"%>

</body>
</html>