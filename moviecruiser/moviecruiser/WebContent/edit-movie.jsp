<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/movie.css">
<script src="js/cruiser.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movielogo.png"> <a
			href="ShowMoviesListAdmin">Movies</a>
	</div>
	<div class="eating">
		<h1>Edit Movie</h1>
		<div class="body-content-color">
			<form action="EditMovies" onsubmit="return validateMovieForm()"
				name="movieForm" method="post">
				<div class="form-field-spacing">
					<label for="title">Title</label><br> <input type="text"
						class="text-box  text-box-title" name="title" size="160"
						value="${movies.title}">
				</div>
				<br>
				<div class="form-field-spacing">
					<label for="gross">Gross($)</label><br> <input type="text"
						class="text-box" name="gross" id="gross" value="${movies.gross}">
				</div>
				<div class="form-field-spacing">
					<label for="inStock">Active</label><br> <input class="radio"
						type="radio" name="inStock" id="inStock" value="yes"
						<c:if test ="${movies.active}">checked</c:if>>Yes <input
						class="radio" type="radio" name="inStock" id="inStock" value="no"
						<c:if test ="${!movies.active}">checked</c:if>>No
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label><br> <input
						type="text" class="text-box" name="dateOfLaunch"
						value="<fmt:formatDate type = "date" pattern = 'dd/MM/yyyy' value = '${movies.dateOfLaunch}'/>">
				</div>
				<div class="form-field-spacing"></div>
				<label for="genre">Genre</label> <select name="genre"
					class="dropdown">
					<option value="${movies.genre}">${movies.genre}</option>
					<option value="Superhero">Superhero</option>
					<option value="Science Fiction">Science Fiction</option>
					<option value="Romance">Romance</option>
					<option value="Comedy">Comedy</option>
					<option value="Adventure">Adventure</option>
					<option value="Thriller">Thriller</option>
				</select> <br>
				<div class="form-field-spacing">
					<label for="teaser">Has Teaser </label> <input type="checkbox"
						name="teaser" <c:if test = "${movies.teaser}">checked</c:if>>
				</div>
				<br> <br>
				<div>
					<input type="hidden" name="id" value="${movies.id}"> <input
						type="submit" class="button success-button" value="Save">
				</div>
			</form>
		</div>
	</div>

	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>