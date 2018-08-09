<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<div class= "jumbotron">
	<div class="text-right ">
	
	</div>
		
		<h1 class = "text-center">Elections List </h1>
		
		<hr>
		<div class="col-lg-10 offset-lg-1">
		<c:choose>
		<c:when test="${ not empty electionListForAddVoterIntoElection}">

			<c:forEach items="${ electionListForAddVoterIntoElection }" var="election" varStatus="boucle">
				
					<button class="btn btn-primary btn-lg " style="width: 150px; height: 60px; margin: 20px" type="button"
					onclick="{window.location.href='<%=basePath%>/selectelectionforaddvoters?id=${ election.id}'}">${ election.title}</button>
				
			</c:forEach>
		</c:when>


		<c:otherwise>
			<div>
				<b>No elections.</b>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
	</div>

	<%-- <div>
		<h1>Elections currently open</h1>
		<a href="<%=basePath%>/votedreferendumsandelections">View my votes</a>
		<hr>
		
		<c:choose>
		<c:when test="${ not empty electionList}">

			<c:forEach items="${ electionList }" var="electionList" varStatus="boucle">
				<div>
					<dl>
						<dt>
							<a href="<%=basePath%>/votesdetailsforvoting?id=${ electionList.id}">${ electionList.title}</a>
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


	<div>
		<h1>Elections coming soon</h1>
		<hr>
	</div>

	<c:choose>
		<c:when test="${ not empty electionList}">

			<c:forEach items="${ electionList }" var="electionList"
				varStatus="boucle">
				<div>
					<dl>
						<dt>
							<a href="<%=basePath %>/votesdetails?id=${ electionList.id}">${ electionList.title}</a>
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
	</c:choose> --%>

</body>
</html>