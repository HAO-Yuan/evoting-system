<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.bl.evoting.bean.ReferendumElections"%>
<%@ page import="com.bl.evoting.dao.ElectionsDisplayDAO"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>${ electionDetailsForVoting.title}</title>
</head>
<body>
	<h1>Details of ${ electionDetailsForVoting.title}</h1>
	<hr>
	<table>
		<tr>
			<td><B>Description:</B> ${ electionDetailsForVoting.description}</td>
		</tr>
		<tr>
			<td><B>Location:</B> ${ electionDetailsForVoting.location}</td>
		</tr>
		<tr>
			<td><B>Options:</B> 
			<form action="<%=basePath %>/votingsubmission?e_id=${electionDetailsForVoting.id} " method="post">
			<c:choose>
			<c:when test="${ not empty candidatesForElectionToBeVoted}">
				<c:forEach items="${candidatesForElectionToBeVoted}" var="candidate" varStatus="boucle">
						<dl>
							<dt>
								<input type="radio" value="${candidate.id}" name="options" /> 
								${candidate.id}${candidate.name}
							</dt>
						</dl>
				</c:forEach>
				</c:when>


		<c:otherwise>
			<div>
				<b>No candidates.</b>
			</div>
		</c:otherwise>
	</c:choose>
				<input type="submit" value="Submit my option"/>
			</form> 
			</td>
		</tr>
	</table>
</body>
</html>