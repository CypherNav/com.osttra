<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.osttra.to.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gurukul Shiksha</title>
</head>
<body>

	<%
	User user = (User) session.getAttribute("user");
	String role = user.getRole();
	%>

	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark"
		aria-label="Main navigation">
		<div class="container-fluid">

			<div class="navbar-collapse offcanvas-collapse"
				id="navbarsExampleDefault">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">

					<li class="nav-item "><a class="nav-link active font-weight-bold" 
						aria-current="page">  <b class="text-danger">You Are Logged in As  ${ user.getRole()}</b></a></li>

					<li class="nav-item"><a class="nav-link active  font-weight-bold" style="color:red;"
						aria-current="page" href="/logout"><b>LOGOUT</b></a></li>
				</ul>
			</div>
		</div>

	</nav>
</body>
</html>