<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Updated Message</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>

	<h2>Below is the original information for "${origFilm.title}"</h2>
	<br>
	<h3>Please make any needed changes</h3>

	<form action="updateFilm.do" method="POST">
		Film ID: <input type="text" value="${origFilm.id }" name="id"
			readonly="readonly">
			<br/>
			<br/> 
		Film title: <input type="text" value="${origFilm.title }" name="title">
			<br /> 
			<br />
		Rating: <select name="rating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG13">PG13</option>
			<option value="R">R</option>
			<option value="NC17">NC17</option>
				</select> 
			<br /> 
			<br /> 
		Description: <input type="text" value="${origFilm.description }" name="description">
			<br /> 
			<br />
		Run time: <input type="number" value="${origFilm.filmLength }" name="filmLength" required min="1" max="1000">
			<br /> 
			<br /> 
		Release year: <input type="text" value="${origFilm.year.substring(0,4) }" name="year" required minlength="4" maxlength="4">
			<br />
			<br /> 
		Language: <select name="languageID">
			<option value="1">English</option>
			<option value="2">Italian</option>
			<option value="3">Japanese</option>
			<option value="4">Mandarin</option>
			<option value="5">French</option>
			<option value="6">German</option>
				</select> 
			<br /> 
			<br /> 
		Rental duration: <input type="number" value="${origFilm.rentalDuration }" name="rentalDuratation" required min="1" max="127">
			<br />
			<br /> 
		Rental rate: <input type="number" value="${origFilm.rentalRate }" name="rentalRate" required min="0.01" max="100" step="0.01">
			<br /> 
			<br />
		Replacement cost: <input type="number" value="${origFilm.replacementCost }" name="replacementCost" required min="0" max="100" step="0.01">
			<br />
			<br /> 
		Special Features: <select name="specialFeatures">
			<option value="Trailers">Trailers</option>
			<option value="Commentaries">Commentaries</option>
			<option value="Deleted Scenes">Deleted Scenes</option>
			<option value="Behind the Scenes">Behind the Scenes</option>
		</select> 
		<br /> 
		<input type="submit">
	</form>
	<br>
	<form action="home.do" method="GET">
		<input type="submit" value="Home Page"> <input type="hidden">
	</form>

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