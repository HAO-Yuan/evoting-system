<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bl.evoting.bean.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
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
<!--<link href="css/your-style.css" rel="stylesheet"> -->
<!-- For earlier than IE9  -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div>
		<h1>Selected Voters</h1>
		<hr>
		<div class="col-lg-10 offset-lg-1">
		<%
			if (request.getSession().getAttribute("votersListForAddToElection") != null) 
			{
		%>
			<%
				Set<Voters> votersSet = (Set<Voters>)request.getSession().getAttribute("votersListForAddToElection");
				for(Voters voter: votersSet)
				{
			%>
					<button class="btn btn-primary btn-lg " style="width: 150px; height: 60px; margin: 20px" type="button"
					><%= voter.getId() %><%= voter.getUsername() %></button>
			<%
				}
			%>
		<%
			}
		%>
	</div>
	</div>

	

</body>
</html>