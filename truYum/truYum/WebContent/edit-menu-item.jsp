<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Menu Item</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="eating">
		<h1>Edit Menu Item</h1>
		<div class="body-content-color">
			<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
				name="menuItemForm" method="post">
				<div class="form-field-spacing">
					<label for="name1">Name</label><br> <input type="text"
						class="text-box  text-box-title" name="name" size="165"
						value="${menuItem.name}">
				</div>
				<br>
				<div class="form-field-spacing">
					<label for="price">Price(Rs.)</label><br> <input type="text"
						class="text-box" name="price" id="price" value="${menuItem.price}">
				</div>
				<div class="form-field-spacing">
					<label for="inStock">Active</label><br> <input class="radio"
						type="radio" name="inStock" id="inStock" value="yes"
						<c:if test ="${menuItem.active}">checked</c:if>>Yes
					<input class="radio" type="radio" name="inStock" id="inStock"
						value="no"
						<c:if test ="${!menuItem.active}">checked</c:if>>No

				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label><br> <input
						type="text" class="text-box" name="dateOfLaunch"
						value="<fmt:formatDate type = "date" pattern = 'dd/MM/yyyy' value = '${menuItem.dateOfLaunch}'/>">
				</div>
				<div class="form-field-spacing"></div>
				<label for="category">Category</label> <select name="category"
					class="dropdown">
					<option value="${menuItem.category}">${menuItem.category}</option>
					<option value="Starters">Starters</option>
					<option value="Main course">Main course</option>
					<option value="Desserts">Desserts</option>
					<option value="Drinks">Drinks</option>
				</select>		
				<br>
		<div class="form-field-spacing">
			<label for="freeDelivery">Free Delivery </label> <input
				type="checkbox" name="freeDelivery"
				<c:if test = "${menuItem.freeDelivery}">checked</c:if>>
		</div>
		<br> <br> <div>
		<input type="hidden" name="id"
			value="${menuItem.id}"> <input type="submit"
			class="button success-button" value="Save">
</div>
		</form>
		</div>
		</div>

	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>
</body>
</html>