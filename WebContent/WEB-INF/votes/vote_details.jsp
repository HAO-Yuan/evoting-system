<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bl.evoting.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
	ReferendumElections election;
	CandidatesSet candidatesSet;
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>${ electionForDetails.title}</title>
</head>
<body>
	
	<hr>
	<%
		if (request.getSession().getAttribute("electionForDetails")!=null){
			election = (ReferendumElections) request.getSession().getAttribute("electionForDetails");
		
	%>
	<h1>Details of <%=election.getTitle() %></h1>
	<hr>
	Description:<%=election.getDescription() %><br>
	Location:<%=election.getLocation() %><br>
	Option:
		<%
			if (request.getSession().getAttribute("candidatesSetForElection") != null) 
			{
		%>
			<%
				candidatesSet = (CandidatesSet)request.getSession().getAttribute("candidatesSetForElection");
				for(Candidates candidate: candidatesSet.getCandidatesSet())
				{
			%>
					<button class="btn btn-primary btn-lg " style="width: 150px; height: 60px; margin: 20px" type="button"
					><%= candidate.getId() %><%= candidate.getName() %></button>
			<%
				}
			%>
		<%
			}else{
		%>
			<p>No Options</p>
		<%
			}
		%>
	<%
		}else{
		%>
		<p>No election</p>
	<%
	}
	%>
</body>
</html>