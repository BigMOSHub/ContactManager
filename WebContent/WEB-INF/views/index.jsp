<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager Home</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<h3><a href="new" >New Contact</a></h3>
		<table border ="1" >
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>email</th>
				<th>address</th>
				<th>phone</th>
			</tr>
			
			<c:forEach items="$(listContact)" var="contact" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${contact.name}</td>
				<td>${contact.email}</td>
				<td>${contact.address}</td>
				<td>${contact.phone}</td>
			</tr>
			</c:forEach>
			
		</table>
	
	</div>

</body>
</html>