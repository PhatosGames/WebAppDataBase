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
	<form action="ricerca">
		<select name="countrycode">
			<c:forEach items="${codicenazione}" var="n">
				<option value="${n}">${n}</option>
			</c:forEach>
		</select> Nome città: <input type="text" name="capitale" size="20px">
		Popolazione Massima: <input type="text" name="maxpopulation"
			size="20px"> Popolazione Minima: <input type="text"
			name="minpopulation" size="20px"> <input type="checkbox"
			name="checkbox">Capitale<br>
		<button type="submit" name="cerca" formaction="ricerca">Cerca</button>

		<center>
			<font color="white"> <c:forEach items="${continenti}" var="c">
					<a href="http://localhost:8080/WebAppDataBase/secondo?continente=${c.continent}">${c.continent}</a>
				</c:forEach>
			</font>
		</center>
	</form>
</body>
</html>