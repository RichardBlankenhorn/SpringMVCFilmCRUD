<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<!-- <form action="index.do" method="GET">  -->
	<!--  <input type="submit" value="login" /> -->
	<!--  </form> -->

	<h1>Welcome to the Film Query Database</h1>
	<h4>Please choose from the following options</h4>

	<!--  Search for a film by ID searchFilmById.do-->
	<!--  Search for a film by keyword searchFilmByKeyword.do -->
	
	<form action="searchFilmById.do" method="GET">
		<select name="filmsById" size="1">
			<option value="SelectFilmById">Select film by ID</option>
		</select> 
		<br /> 
		<input type="submit">
	</form>
	
	<br />

	<form action="searchFilmByKeyword.do" method="GET">
		<select name="filmsByKeyword">
			<option value="SelectFilmByKeyword">Select film by keyword</option>
		</select> 
		<br /> 
		
		<input type="submit">
	</form>
	<br />
	<br />

	<!-- User add film with all properties addFilm.do-->
	<h4>Add a film to the database:</h4>
	<form action="addFilm.do" method="POST">
		Film title: <input type="text" name="filmname"><br /> Rating:
		<input type="text" name="filmrating"><br /> Description:<input
			type="text" name="filmdescription"><br /> <input
			type="submit">
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