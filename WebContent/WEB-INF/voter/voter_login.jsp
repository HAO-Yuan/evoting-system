<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
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
<title>E-voting System</title>
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
		<h1 class="text-center">Welcome Voter</h1>
			<hr>
			<div>
			<form class="form-horizontal" role="form" action="<%=basePath%>/voterlogin?action=login" method="post">
				<div class="form-group ">
					<label for="exampleInputEmail1 " class="col-sm-2 control-label">Username: </label>
					<div class="col-sm-10"> 
					<input type="text" class="form-control" name="username" style="width: 25%" 
						placeholder="Please input your username">
					</div>	
				</div>
				<div class="form-group ">
					<label for="exampleInputEmail1 " class="col-sm-2 control-label">Password: </label>
					<div class="col-sm-10"> 
					<input type="password" class="form-control" name="password" style="width: 25%" 
						placeholder="Please input your password">
					</div>	
				</div>
		
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-2">
						<button type="submit" name="submit" class="btn btn-success btn-block">Log In</button>
						
					</div>
				</div>
			</form>
				<div class="col-sm-offset-2 col-sm-2">
					<button class="btn btn-info btn-block" onclick="{window.location.href='<%=basePath%>/voterlogin?action=signup'}">Sign Up</button>
				</div>
			</div>
	
	
		<%-- <h1>Welcome Voter</h1>
		<hr>
		<form action="<%= basePath%>/voterlogin" method="post">
			<table>
				<tr>
					<td>Username: </td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan ="2"><input type="submit" name="submit" value="login"/></td>
				</tr>
			</table>
		</form> --%>
		</div>
</body>
</html>