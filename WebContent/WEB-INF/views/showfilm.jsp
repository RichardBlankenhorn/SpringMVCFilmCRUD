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


	<h1>Welcome to the Film Query Database</h1>
	<p>Here is the film information you requested:</p>

	<c:choose>
		<c:when test="${empty film}">


		</c:when>
		<c:otherwise>
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
						<c:if test="${category !=  null}">
							<li>Film Category: ${category }</li>
						</c:if>
						<c:if test="${category == null }">
							<li>Film Category: None</li>
						</c:if>
						<c:if test="${actors.size() != 0 }">
							<li>Cast:</li>
							<table>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
								</tr>
								<c:forEach items="${actors }" var="a">
									<tr>
										<td>${a.firstName }</td>
										<td>${a.lastName }</td>
								</c:forEach>
								</tr>
							</table>
						</c:if>
					</ul>
				</li>

			</ul>
		</c:otherwise>
	</c:choose>

	<c:forEach items="${films}" var="film" varStatus="status">

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
					<li>Cast:</li>
					<table>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
						</tr>

						<c:forEach items="${actorsList[status.index] }" var="a">
							<tr>
								<td>${a.firstName }</td>
								<td>${a.lastName }</td>
							</tr>
						</c:forEach>

					</table>
				</ul>
			</li>

		</ul>

	</c:forEach>

	<table>
		<tr>

			<c:if test="${film.id > 1000 }">
				<td>
					<form action="delete.do" method="POST">
						<input type="submit" value="Delete Film"> <input
							type="hidden" value="${film.id }" name="filmID">
					</form>
				</td>

				<br>
				<td>
					<form action="update.do" method="GET">
						<input type="submit" value="Update Film"> <input
							type="hidden" value="${film.id }" name="filmID">
					</form>
				</td>
			</c:if>

			<td>
				<form action="home.do" method="GET">
					<input type="submit" value="Home Page"> <input
						type="hidden">
				</form>
			</td>
		</tr>
	</table>

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