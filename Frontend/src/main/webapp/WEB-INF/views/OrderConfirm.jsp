<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Confirm</title>
</head>
<body>
	<h3 align="center">Your Orders</h3>
	
	<table class="table-bordered">
	<tr bgcolor="red">
		<td>ProductName</td>
		<td>Quantity</td>
		<td>Price</td>
		<td>Total price</td>
	</tr>
	<c:forEach items="${cartItems}" var="cart">
	<tr>
		<td>${cart.productName}</td>
		<td>${cart.quantity}</td>
		<td>${cart.price}</td>
		<td>${cart.quantity * cart.price}/-</td>	
	</tr>
	</c:forEach>
	<tr bgcolor="cyan">
		<td colspan="3">GrandTotal</td>
		<td colspan="2">Rs.${grandtotal}/-</td>
	</tr>
	
	<tr bgcolor="yellow">
		<td colspan="3"><a href="<c:url value="/cart"/>">Edit Cart</a></td>
	</tr>
	</table>
	<br>
	
	<div>
	<form action="payment" method="post">
	<table class="table-bordered">
	<tr bgcolor="Orange">
		<td>Payment Detail</td>
	</tr>
	<tr>
		<td>Payment Type</td>
		<td>
			<input type="radio" name="pmode" value="COD"/>Cash on Delivery
			<input type="radio" name="pmode" value="CC"/>Credit Card
		</td>
		</tr>
		
		<tr bgcolor="orange">
		<td> Credit Card</td>
		<td>
			<input type="text" name="creditcard"/>
		</td>
		</tr>
		
		<tr bgcolor="orange">
		<td>CVV<input type="text" name="CVV" /></td>
		<td>Valid Upto<input type="text" name="valid" /></td>
		</tr>
		
		<tr bgcolor="cyan">
		<td colspan="2"><input type="submit" value="pay" /></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>