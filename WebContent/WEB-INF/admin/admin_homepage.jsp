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
<link href="style.css" rel="stylesheet">
<!-- For earlier than IE9  -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">Please Choose an Operation</h1>
		<hr>
		<div class="col-lg-6 offset-lg-3">
			<button class="btn btn-primary btn-lg btn-block" onclick="{window.location.href='<%=basePath%>/operationchoice?choice=add'}">Add a voter</button>
			<button class="btn btn-info btn-lg btn-block"  onclick="{window.location.href='<%=basePath%>/operationchoice?choice=setup'}">Setup an election</button>
			<button class="btn btn-success btn-lg btn-block"  onclick="{window.location.href='<%=basePath%>/operationchoice?choice=open'}">Open an election</button>
			<button class="btn btn-danger btn-lg btn-block"  onclick="{window.location.href='<%=basePath%>/operationchoice?choice=close'}">Close an election</button>
		</div>
	</div>
</body>

</html>