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
<title>TabCitta</title>
</head>
<body>
	<p>Puoi eliminare una citt&agrave; cliccandogli sopra!</p>
	<c:forEach items="${citta}" var="c">
		<a href="http://localhost:8080/WebAppDataBase/eliminacitta?citta=${c.nomeCitta}&citid=${c.idCitta}&countrycode=${c.codiceNazione}">${c.nomeCitta}</a>
		<br>
		<font color="red"><p>${c.codiceCitta}</p> </font>
		<font color="blue"><p>${c.popolazioneCitta}</p> </font>
	</c:forEach>
</body>
</html>