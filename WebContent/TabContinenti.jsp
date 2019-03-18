<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style type="text/css">
body {
	background-image:
		url(https://i.etsystatic.com/5979725/d/il/8b2f9b/https://i.etsystatic.com/5979725/d/il/8b2f9b/1217688291/il_340x270.1217688291_iwsu.jpg?version=0/il_340x270.1217688291_iwsu.jpg?version=0);
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>TabContinenti</title>
</head>
<body>
	<center>
		<c:forEach items="${continenti}" var="c">
			<a
				href="http://localhost:8080/WebAppDataBase/secondo?continente=${c.continent}">${c.continent}</a>
		</c:forEach>
	</center>
</body>
</html>