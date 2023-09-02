<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.osttra.to.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<%-- <%
	User user = (User) session.getAttribute("user");

%> --%>
	<h1 style="margin-left: 450px">School Management</h1>
	<h3 style="margin-left: 450px;">Provide your Details</h3>

	<div style="margin-left: 450px; margin-right: 500px">
		<form action="/update" method="post">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Username</label>
				<input type="text" name="username" readonly
					value="${updatinguser.getUsername() }" class="form-control">
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Complete
					Name</label> <input type="text" name="completeName"
					value="${updatinguser.getCompleteName() }" class="form-control">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Email</label>
				<input type="text" name="email" value="${updatinguser.getEmail() }"
					class="form-control">
			</div>
			<%-- <%= user %> --%>


			<button style="margin-left: 130px" type="submit"
				class="btn btn-primary">Update</button>
			<br>
		</form>
		<a href="/">Back to Home Page</a>
	</div>
</body>
</html>