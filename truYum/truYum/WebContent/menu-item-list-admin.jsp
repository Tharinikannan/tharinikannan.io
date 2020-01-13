<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="page-title">
		<p style="margin-left: 118px">Menu Items</p>
	</div>
	<table class="body-content-colour">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>
		<tr>
			<c:forEach items="${menuItemList}" var="menuItem">
	<tr>
		<td>${menuItem.name}</td>
		<td>Rs.<fmt:formatNumber value="${menuItem.price }"
				pattern="#,##,##,##,###.00" /></td>
		<td><c:choose>
				<c:when test="${menuItem.active eq 'true'}">
 Yes
 <br />
				</c:when>
				<c:otherwise>
 No
  <br />
				</c:otherwise>
			</c:choose></td>
		<td><fmt:formatDate type="date" pattern='dd/MM/yyyy'
				value='${menuItem.dateOfLaunch }' /></td>
		<td>${menuItem.category}</td>
		<td><c:choose>
				<c:when test="${menuItem.freeDelivery eq 'true'}">
 Yes
 <br />
				</c:when>
				<c:otherwise>
 No
  <br />
				</c:otherwise>
			</c:choose></td>
		<td><a href="ShowEditMenuItem?id=${menuItem.id}"
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