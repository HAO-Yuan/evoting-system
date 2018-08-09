<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<!--<link href="css/your-style.css" rel="stylesheet"> -->
<!-- For earlier than IE9  -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<div class="jumbotron">
		<h1 class="text-center">Addition of Voters for Election</h1>
		<hr>
		
		<form class="form-horizontal" role="form" action="<%= basePath%>/addvoter" method="post">
			
			<!-- select voters which to be added into one election -->
			<div class="form-group ">
				<label for="exampleInputEmail1 " class="col-sm-2 control-label">Add Voters:</label>
				<button class="btn btn-info " 	type="button"
				onclick="{window.location.href='<%=basePath%>/voterlist'}">Edit Voters</button>
				<div class="col-sm-10"> 
				<%
			
					if (request.getSession().getAttribute("votersListForAddToElection") != null) 
					{
				%>
				<%
					@SuppressWarnings("unchecked")
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
				<hr>
				</div>	
			</div>
			
			<!-- select one election into which add voters-->
			<div class="form-group ">
				<label for="exampleInputEmail1 " class="col-sm-2 control-label">Select Election:</label>
				<button class="btn btn-info " 	type="button"
				onclick="{window.location.href='<%=basePath%>/electionlist'}">Select Election</button>
				<div class="col-sm-10"> 
				<%
					if (request.getSession().getAttribute("electionForAddVoter") != null) 
					{
				%>
				<%
					ReferendumElections election = (ReferendumElections)request.getSession().getAttribute("electionForAddVoter");
					
				%>
					<button class="btn btn-primary btn-lg " style="width: 150px; height: 60px; margin: 20px" type="button"
					><%= election.getId() %><%= election.getTitle() %></button>
				<%
					}
				%>
				
				<hr>
				</div>	
			</div>
			
			
	
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" name="setup" class="btn btn-success btn-lg">Confirm</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>