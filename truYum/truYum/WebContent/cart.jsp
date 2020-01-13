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
		<img src="images/truyum-logo-light.png"> 
		<a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
		</div>
	<div>
		<c:if test="${deleteCartStatus}">
			<div class="success-message">
				<h3>Item removed from cart Successfully.</h3>
			</div>
		</c:if>
		<table class="body-content-colour">

			<tr>
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th> </th>
			</tr>
			<tr>
				<c:forEach items="${cart.menuItemList}" var="menuItem">
		
			<tr>
				<td>${menuItem.name}</td>
				<td><c:choose>
						<c:when test="${menuItem.freeDelivery eq 'true'}">
 Yes<br />
						</c:when>
						<c:otherwise>
 No<br />
						</c:otherwise>
					</c:choose></td>
				<td class="">Rs.<fmt:formatNumber value="${menuItem.price}"
						pattern="#,##,##,##,###.00" />
				</td>
				<td><a href="RemoveCart?id=${menuItem.id}"
							style="color: black">Delete</a></td>
			</tr>
			</c:forEach>
	</tr>
			<tr>
				<td></td>
				<td class=""><b>Total</b></td>
				<td class=""><b>Rs.<fmt:formatNumber value="${cart.total}"
							pattern="#,##,##,##,###.00" /></b></td>
				<td></td>
			</tr>
		</table>
	</div>
	<div class="footer">
		<p>Copyright @ 2019</p>
	</div>	
</body>
</html>