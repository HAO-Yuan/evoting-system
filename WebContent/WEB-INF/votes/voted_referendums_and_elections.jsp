<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View My Votes</title>
</head>
<body>
	<div>
		<h1>View My Votes</h1>
		<hr>
		<c:choose>
			<c:when test="${ not empty votedElectionList}">

				<c:forEach items="${ votedElectionList }" var="votedElectionList" varStatus="boucle">
					<div>
						<h2>Details of ${ votedElectionList.title}</h2>
						<hr>
						<table>
							<tr>
								<td><B>Description:</B> ${ votedElectionList.description}</td>
							</tr>
							<tr>
								<td><B>Location:</B> ${ votedElectionList.location}</td>
							</tr>
							<tr>
								<td><B>Your option:</B>${ votedElectionList.options}</td>
							</tr>
						</table>
					</div>
				</c:forEach>
			</c:when>


			<c:otherwise>
				<div>
					<b>No elections.</b>
				</div>
			</c:otherwise>
		</c:choose>
	</div>


</body>
</html>