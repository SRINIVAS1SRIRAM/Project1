<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<style type="text/css">
.background
{
   height: 700px;
   background-image: url("http://studinfo.edu.aris.ge/wp-content/uploads/2017/12/book.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}
</style>
<title>Display-Product</title>
</head>
<body>
<h3>Display Product</h3>
		<div class="row text-center text-lg-Left">
		<c:forEach items="${productlist}" var="product">
		<div class="col-lg-3 col-md-4 col-6">
		<a href="<c:url value="/productDetails/${product.productId}"/>" class="d-block mb-4 h-100">
		<img class="img-fluid img-thumbnail" src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="" width="100" height="100">
		<br>
		Price :: ${product.price}/-
		Stock :: ${product.stock}/-
		</a>
		</div>
		</c:forEach>
		<br>
		</div>
</body>
</html>