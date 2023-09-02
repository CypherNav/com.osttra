<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.osttra.to.User, java.util.List"%>
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
	<%
	User user = (User) session.getAttribute("user");
	List<User> users = (List<User>) request.getAttribute("users");
	List<User> students = (List<User>) request.getAttribute("students");
	%>
	<jsp:include page="header.jsp" />
	<h1 style="margin-left: 500px; margin-top: 100px">School Management</h1>
	<br>
	<h4 style="margin-left: 500px">${updateMsg}</h4>
	<h3>Your Profile</h3>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Username</th>
				<th scope="col">Complete Name</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Delete</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${ user.getUsername() }</td>
				<td>${ user.getCompleteName() }</td>
				<td>${ user.getEmail() }</td>
				<td>${ user.getRole() }</td>
				<td><a href="delete/${ user.getUsername() }">Delete</a></td>
				<td><a href="updatePage/${ user.getUsername() }">Update</a></td>
			</tr>
		</tbody>
		</tbody>
	</table>

	<%
	if (users != null && user.getRole().equalsIgnoreCase("admin") && users.size() > 1) {
	%>
	<h3>Waiting Users</h3>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">S. No.</th>
				<th scope="col">Username</th>
				<th scope="col">Complete Name</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Allow</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<%
		int count = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getStatus().equals("0")) {
				count++;
		%>
		<tr>
			<td><%=count%></td>
			<td><%=users.get(i).getUsername()%></td>
			<td><%=users.get(i).getCompleteName()%></td>
			<td><%=users.get(i).getEmail()%></td>
			<td><%=users.get(i).getRole()%></td>
			<td><a href="/allow/<%=users.get(i).getUsername()%>">Allow</a></td>
			<td><a href="/delete/<%=users.get(i).getUsername()%>">Delete</a></td>
		</tr>
		<%
		}
		}
		%>
		</table>
	
	<h3>Other Users</h3>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">S. No.</th>
				<th scope="col">Username</th>
				<th scope="col">Complete Name</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
				<th scope="col">Delete</th>
				<th scope="col">Update</th>
				<th scope="col">Block</th>
			</tr>
		</thead>
		<%
		int count1 = 0;
		for (int i = 0; i < users.size(); i++) {
			if (!user.getUsername().equals(users.get(i).getUsername())&&users.get(i).getStatus().equals("1")) {
				count1++;
		%>
		<tr>
			<td><%=count1%></td>
			<td><%=users.get(i).getUsername()%></td>
			<td><%=users.get(i).getCompleteName()%></td>
			<td><%=users.get(i).getEmail()%></td>
			<td><%=users.get(i).getRole()%></td>
			<td><a href="/delete/<%=users.get(i).getUsername()%>">Delete</a></td>
			<td><a href="/updatePage/<%=users.get(i).getUsername()%>">Update</a></td>
			<td><a href="/block/<%=users.get(i).getUsername()%>">Block</a></td>
		</tr>
		<%
		}
		}
		}
		%>
		</tbody>
	</table>

	<%
	if (students != null && user.getRole().equalsIgnoreCase("teacher")) {
	%>
	<h3>Students</h3>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">S. No.</th>
				<th scope="col">Username</th>
				<th scope="col">Complete Name</th>
				<th scope="col">Email</th>
				<th scope="col">Role</th>
			</tr>
		</thead>
		<%
		int count = 0;
		for (int i = 0; i < students.size(); i++) {
			count++;
		%>
		<tr>
			<td><%=count%></td>
			<td><%=students.get(i).getUsername()%></td>
			<td><%=students.get(i).getCompleteName()%></td>
			<td><%=students.get(i).getEmail()%></td>
			<td><%=students.get(i).getRole()%></td>
		</tr>
		<%
		}
		}
		%>
		</tbody>
	</table>










</body>
</html>