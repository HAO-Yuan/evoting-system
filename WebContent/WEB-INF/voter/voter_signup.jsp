<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bl.evoting.bean.*"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Election Setting up</title>
<!-- Bootstrap -->
<link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!--DIY CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- For earlier than IE9  -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<div class="container">
			<h1 class="text-center">Sign up For E-Voting System</h1>
			<hr>
			<p class="text-center">Please input your information.</p>
			<form class="form-horizontal" role="form" action="<%= basePath%>/signup" onsubmit= "return formCheck() "method="post">
				
				<div class="form-group ">
					<label for="exampleInputEmail1 " class="col-sm-2 control-label">Username:</label>
					<div class="col-sm-10"> 
					<input type="text" class="form-control" name="username" style="width: 30%">
					</div>	
				</div>
				
				<div class="form-group ">
					<label for="signuppassword " class="col-sm-2 control-label">Password: </label>	
					<div class="col-sm-10"> 
					<input type="password" class="form-control" name="password" style="width: 30%" id = "pwd2">
					</div>
					
				</div>
				
				<div class="form-group ">
					<label for="signuppassword " class="col-sm-2 control-label">Repeat Password: </label>	
					<div class="col-sm-10"> 
					<input type="password" class="form-control" name="repeatpassword" style="width: 30%" id = "pwd1" >
					</div>	
				</div>
				
				<div class="form-group ">
					<label for="exampleInputEmail1 " class="col-sm-2 control-label">Email: </label>
					<div class="col-sm-10"> 
					<input type="text" class="form-control" name="email" style="width: 30%" >
					</div>	
				</div>
				
				
		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" name="setup" class="btn btn-success btn-lg">Sign Up</button>
					</div>
				</div>
			</form>
			
		</div>
		
		<!-- DIY js -->
		<script type="text/javascript" src="js/script.js"></script>
</body>
</html>