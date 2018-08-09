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
		<h1 class="text-center">Setup an election</h1>
		<hr>
		<p class="text-xl-left">Please input the information of election.</p>
		<form class="form-horizontal" role="form" action="<%= basePath%>/setupelection" method="post">
			
			<div class="form-group ">
				<label for="exampleInputEmail1 " class="col-sm-2 control-label">Title of election:</label>
				<div class="col-sm-10"> 
				<input type="text" class="form-control" name="title" style="width: 30%">
				</div>	
			</div>
			
			<div class="form-group ">
				<label for="exampleInputEmail1 " class="col-sm-2 control-label">Description of election: </label>
				<div class="col-sm-10"> 
				<textarea  class="textarea form-control" name="description" style="width: 30%" ></textarea>
				</div>	
			</div>
			
			<div class="form-group ">
				<label for="exampleInputEmail1 " class="col-sm-2 control-label">Location of election: </label>
				<div class="col-sm-10"> 
				<input type="text" class="form-control" name="location" style="width: 30%">
				</div>	
			</div>
			
			<div class="form-group ">
				<label for="exampleInputEmail1 " class="col-sm-2 control-label">Add Candidates:</label>
				<button class="btn btn-info " 	type="button"
				onclick="{window.location.href='<%=basePath%>/candidatelist'}">Edit Candidates</button>
				<div class="col-sm-10"> 
				<%
					if (request.getSession().getAttribute("candidatesSet") != null) 
					{
				%>
					<%
						CandidatesSet candidatesSet = (CandidatesSet)request.getSession().getAttribute("candidatesSet");
						for(Candidates candidate: candidatesSet.getCandidatesSet())
						{
					%>
						<button class="btn btn-primary btn-lg " style="width: 150px; height: 60px; margin: 20px" type="button"
						><%= candidate.getId() %><%= candidate.getName() %></button>
					<%
						}
					%>
				<%
					}
				%>
				</div>	
			</div>
	
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" name="setup" class="btn btn-success btn-lg">Confirm</button>
				</div>
			</div>
		</form>
	</div>









	<%-- <h1>Setup an election</h1>
	<hr>
	<p>Please input the information of election.</p>
	<form action="<%= basePath%>/setupelection" method="post">
		<table>
			<tr>
				<td>Title of election:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Description of election: </td>
				<td><input type="text" name="description"/></td>
			</tr>
			<tr>
				<td>Location of election: </td>
				<td><input type="text" name="location"/></td>
			</tr>
			<tr>
				<td>Number of options: </td>
				<td><input type="text" name="options"/></td>
			</tr>
			<tr>
				<td colspan ="2"><input type="submit" name="setup" value="Confirm"/></td>
			</tr>
		</table>
	</form> --%>
</body>
</html>