<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
		<img src="img/logo.png" style="float: left; width: 108px; padding-top: 2px;">
	</div>
	<div class="jumbotron">

		<div>

			<h1 class="text-center">Welcome to E-Voting System</h1>
			<hr>
		</div>

		<div class="text-center">
			<p style="font-size:20px">You Are:</p>

			<button class="btn btn-primary btn-lg "
				style="width: 100px; height: 60px" type="button"
				onclick="{window.location.href='<%=basePath%>/loginchoice?choice=admin'}">Admin</button>

			<button class="btn btn-danger btn-lg " style="width: 100px; height: 60px"
				type="button"
				onclick="{window.location.href='<%=basePath%>/loginchoice?choice=voter'}">Voter</button>
		</div>

	</div>


	<!-- jQuery -->
	<script src="https://www.imooc.com/static/lib/jquery/1.9.1/jquery.js"></script>
	<!-- js plugin　-->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
</body>
</html>