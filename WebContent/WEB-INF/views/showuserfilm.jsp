<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Information</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<h1>Film Query Database</h1>
	
	<p>Your film was successfully added to the database.</p>

	<ul>
		<li>Film title: ${film.title}
			<ul>
				<li>Description: ${film.description}</li>
				<li>Rating: ${film.rating}</li>
				<li>Run time: ${film.filmLength}</li>
				<li>Release year: ${film.year}</li>
				<li>Language: ${film.languageID}</li>
				<li>Rental duration: ${film.rentalDuration}</li>
				<li>Rental rate: ${film.rentalRate}</li>
				<li>Replacement cost: ${film.replacementCost}</li>
				<li>Special features: ${film.specialFeatures}</li>
				
			</ul>
			</ul>
		</li>
	</ul>
	<br><br>
	<p>Would you like to delete this film?</p>
	<form action="delete.do" method="POST">
	<input type="text" name="filmID"><br/>
	<input type="submit" value="Delete Film">
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