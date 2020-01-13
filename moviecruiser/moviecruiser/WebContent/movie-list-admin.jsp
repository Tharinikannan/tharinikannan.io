<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
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
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movielogo.png"> <a href="ShowMoviesListAdmin">Movies</a>
	</div>
	<div class="page-title">
		<p style="margin-left: 118px">Movies</p>
	</div>
	<table class="body-content-colour">
		<tr>
			<th>Title</th>
			<th>Gross</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<tr>
			<c:forEach items="${moviesList}" var="movies">
				<tr>
					<td>${movies.title}</td>
					<td>Rs.<fmt:formatNumber value="${movies.gross}"
							pattern="#,##,##,##,###" /></td>
					<td><c:choose>
							<c:when test="${movies.active eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern='dd/MM/yyyy'
							value='${movies.dateOfLaunch}' /></td>
					<td>${movies.genre}</td>
					<td><c:choose>
							<c:when test="${movies.teaser eq 'true'}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a href="ShowEditMovies?id=${movies.id}"
						style="color: black">Edit</a></td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>