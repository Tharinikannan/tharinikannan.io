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
</head>
<body>
	<div>
		<div class="topnav">
			<div class="home">Movie Cruiser</div>
			<img src="images/movielogo.png"> <a href="ShowFavorites">Favorites</a>
			<a href="ShowMoviesListCustomer">Movies</a>
		</div>
		<c:if test="${deleteFavoritesStatus}">
			<div class="success-message">
				<h3>Movies removed from favorites Successfully.</h3>
			</div>
		</c:if>
		<table class="body-content-colour">
			<tr>
				<th>Title</th>
				<th>Has Teaser</th>
				<th>Gross</th>
				<th></th>
			</tr>
			<tr>
				<c:forEach items="${favorites.moviesList}" var="movies">
					<tr>
						<td>${movies.title}</td>
						<td><c:choose>
								<c:when test="${movies.teaser eq 'true'}">Yes</c:when>
								<c:otherwise>No</c:otherwise>
							</c:choose></td>
						<td class="">$<fmt:formatNumber value="${movies.gross}"
								pattern="#,##,##,##,###" />
						</td>
						<td><a href="RemoveFavorites?id=${movies.id}"
							style="color: black">Delete</a></td>
					</tr>
				</c:forEach>
			</tr>
			<tr>
				<td></td>
				<td class=""><b>No. of Favorites:</b></td>
				<td><b>${favorites.total}</b></td>
				<td></td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>