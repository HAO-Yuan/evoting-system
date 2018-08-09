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
<title>Open an Election</title>
</head>
<body>
	<div>
		<h1>Please Choose an election you want to close</h1>
		<hr>
		<c:choose>
		<c:when test="${ not empty electionList}">

			<c:forEach items="${ electionList }" var="election"
				varStatus="boucle">
				<div>
					<dl>
						<dt>
							<a href="<%=basePath %>closeelection?id=${ election.id}">${ election.title}</a>
						</dt>
					</dl>
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