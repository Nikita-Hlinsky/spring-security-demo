<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Security test</title>
	
	<link rel="stylesheet"
		 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	
	<h2>Want some JAVA?</h2>
	
	<hr>
	
	<p>
	
		user: <security:authentication property="principal.username" /> <br>
		role: <security:authentication property="principal.authorities" />
	
	</p>
	
	<hr>

	<h3>Oh no, then u can leave our java party on link below</h3>
	
	<form:form action="${pageContext.request.contextPath}/logout" 
		method="POST">
		
		<input type="submit" value="Logout" />
		
	</form:form>
	
</body>

</html>