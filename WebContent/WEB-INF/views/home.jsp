<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<!--  <meta charset="UTF-8">-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<!-- <form action="index.do" method="GET">  -->
	<!--  <input type="submit" value="login" /> -->
	<!--  </form> -->

	<h1>Welcome to the Film Query Database</h1>
	<h4>Please choose from the following options</h4>

	<!--  Search for a film by ID searchFilmById.do-->
	<form action="searchFilmById.do" method="GET">
		Search film by Film ID: <input type="text" name=filmId required minlength="1" maxlength="4"><input
			type="submit"> <c:if test="${message.length() > 0}"><span>${message}</span></c:if>
			<c:if test="${sqlmessage.length() > 0 }"><span>${sqlmessage }</span></c:if>
	</form>

	<!--  Search for a film by keyword searchFilmByKeyword.do -->
	<form action="searchFilmByKeyword.do" method="GET">
		Search film by keyword: <input type="text" name=keyword required> <input
			type="submit">
	</form>

	<br />
	<br />

	<!-- User add film with all properties addFilm.do-->
	<h4>Add a film to the database:</h4>

	<form action="addFilm.do" method="POST">
		Film title: <input type="text" name="title" required minlength="1" maxlength="255"><br />
		<br /> Rating: <select name="rating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG13">PG13</option>
			<option value="R">R</option>
			<option value="NC17">NC17</option>
		</select> <br />
		<br /> Description: <input type="text" name="description" required><br />
		<br /> Run time: <input type="number" name="filmLength" required min="1" max="1000"><br />
		<br /> Release year: <input type="text" name="year" required minlength="4" maxlength="4"><br />
		<br /> Language: <select name="languageID">
			<option value="1">English</option>
			<option value="2">Italian</option>
			<option value="3">Japanese</option>
			<option value="4">Mandarin</option>
			<option value="5">French</option>
			<option value="6">German</option>
		</select> <br />
		<br /> Rental duration: <input type="number" name="rentalDuration" required min="1" max="127"><br />
		<br /> Rental rate: <input type="number" name="rentalRate" required min="0.01" max="100" step="0.01"><br />
		<br /> Replacement cost: <input type="number" name="replacementCost" required min="0" max="100" step="0.01"><br />
		<br /> Special Features: <select name="specialFeatures">
			<option value="Trailers">Trailers</option>
			<option value="Commentaries">Commentaries</option>
			<option value="Deleted Scenes">Deleted Scenes</option>
			<option value="Behind the Scenes">Behind the Scenes</option>
		</select> <br /> <input type="submit">
	</form>


	<!-- User can edit film -->


	<!-- JS files for Bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>