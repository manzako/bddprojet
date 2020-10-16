<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des utilisateurs</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="bloc"><div id="bloc1" class="commune">
		<h2 id="form1">Formulaire</h2>
		<form action="/bddproject/test" method="post">
			<label for="login">login:</label> <input type="text" id="login"
				name="login" /> <label for="pwd">pwd:</label> <input type="text"
				id="pwd" name="pwd" /> <input type="submit" value="Envoyer" />
		</form>
	</div>
	<div id="bloc2" class="commune">
		<h2 id="first">Liste des utilisateurs</h2>
		<ul id="list">
			<c:forEach var="utilisateur" items="${ utilisateurs }">
				<li><c:out value="${ utilisateur.login}" /> <c:out
						value="${ utilisateur.pwd}" /></li>
			</c:forEach>
		</ul>
	</div></div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>