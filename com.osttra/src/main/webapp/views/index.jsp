<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="margin-left: 450px"> School Management System</h1><br>
	<div style="margin-left: 450px">${ errorMessage } ${ deleteSucessMsg } ${logoutMessage }</div>
	<form class="px-4 py-3" action="login" method="post">
	<div style="margin-left: 450px;margin-right:500px">
	    <div class="mb-3">
	      <label for="exampleDropdownFormEmail1" class="form-label">Username</label>
	      <input type="text" class="form-control" name=username placeholder="username">
	    </div>
	    <div class="mb-3">
	      <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
	      <input type="text" class="form-control" name=password placeholder="Password">
	    </div>
	    <button type="submit" class="btn btn-primary">Sign in</button>
	  </form>
	  <a href="/Registeration_page">New around here? Sign up</a>
  </div>
</body>
</html>