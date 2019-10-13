<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New/Edit contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="save" method="post" modelAttribute="contact">
		<tr>
			<td>Name:</td>
			<td><form:input path="name"/></td>
		</tr>
		</form:form>
	</div>

</body>
</html>