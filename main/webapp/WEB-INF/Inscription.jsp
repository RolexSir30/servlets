<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Inscris toi! </h1>
<form method=post action="Inscription">

<p>
<label for="name">Nom</label>
<input type=texte id="name" name="name">


</p>


<p>
<label for="mdp"}>PassWord</label>
<input type=password id="mdp" name="mdp">


</p>
<p><input type=submit></p>

</form>

<c:set var="f" value="f" />

<c:if test="${bool eq f}">
Utilisateur déjà dans la BDD changez de nom
</c:if>



<c:set var="OK" value="OK" />


</body>
</html>