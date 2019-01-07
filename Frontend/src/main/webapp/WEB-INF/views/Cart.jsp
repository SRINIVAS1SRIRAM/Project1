<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Jsp</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="http://cdcnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>
	<h3 align="center">Cart</h3>
	
	<table class="table table-responsive">
	<tr>
		<td>Product Name</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>Operation</td>
		<td>TotalPrice</td>
	</tr>
	
	<c:forEach items="${cartItems}" var="cart">
	<form action="<c:url value="/updateCart/${cart.cartId}"/>" method="get">
	
	<tr>
		<td>${cart.productName}</td>
		<td><input type="text" name="quantity" value="${cart.quantity}"/></td>
		<td>${cart.price}</td>
		<td>${cart.quantity * cart.price}/-</td>
		
		<td>			
			<input type="submit" value="update" class="btn btn-success"/>
			<a class="btn btn-danger" href="<c:url value="/deleteCart/${cart.cartId}"/>" method="get">Delete</a>
		</td>
	</tr>
	</form>
	</c:forEach>
	<tr bgcolor="yellow">
	<td colspan="3">Grand Total</td>
	<td colspan="2">${grandtotal}/-</td>
	</tr>
	<tr bgcolor="cyan">
	<td colspan="3"><a href="<c:url value="/displayProduct"/>">Continue Shopping</a></td>
	<td colspan="3"><a href="<c:url value="/checkout"/>">Checkout</a></td>
	</tr>
	</table>
</body>
</html>