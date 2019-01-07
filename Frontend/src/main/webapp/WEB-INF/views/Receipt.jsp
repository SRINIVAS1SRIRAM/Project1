<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Receipt</title>
</head>
<body>
	<div class="container">
	<h3 align="center">Receipt</h3>
	
	<table class="table-bordered">
	<tr bgcolor="cyan">
		<td>Order Id</td>
		<td>${paymentDetail.orderId}</td>
		<td>Order Date</td>
		<td>${paymentDetail.orderDate}</td>
		</tr>
		
		<tr bgcolor="red">
			<td>customer</td>
			<td>${userdetail.username}</td>
			<td>Payment Mode</td>
			<td>${paymentDetail.tranType}</td>
		</tr>
		
		<tr bgcolor="green">
			<td>Address</td>
			<td colspan="3">${userdetail.address}</td>
		</tr>

	</table>
	
	<table class="table-bordered">
	<tr bgcolor="red">
		<td>OrderId</td>
		<td>Quantity</td>
		<td>Price</td>
		<td>TotalPrice</td>
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
		<td colspan="2">${paymentDetail.totalAmount}/-</td>
	</tr>
	</table>
	</div>
</body>
</html>