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
<div class="topnav">
			<div class="home">Movie Cruiser</div>
			<img src="images/movielogo.png"> <a href="ShowFavorites">Favorites</a>
			<a href="ShowMoviesListCustomer">Movies</a>
		</div>
	<h4 style="color: grey; margin-left: 118px">
		No Movies in favorites. Use 'Add to Favorite' option in <a
			href="ShowMoviesListCustomer">Movies List.</a>
	</h4>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>