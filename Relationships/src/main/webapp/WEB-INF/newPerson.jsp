<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>

	<h1>New Book</h1>
	<form:form action="/persons/new" method="post" modelAttribute="person">
		<p>
			<form:label path="firstName">First Name: </form:label>
			<form:errors path="firstName" />
			<form:input path="firstName" />
		</p>
		<p>
			<form:label path="lastName">Last Name: </form:label>
			<form:errors path="lastName" />
			<form:input path="lastName" />
		</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>