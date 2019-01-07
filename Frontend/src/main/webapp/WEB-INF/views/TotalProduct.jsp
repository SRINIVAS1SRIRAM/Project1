<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Total-Product</title>
</head>
<body>
<form action="<c:url value="/addcart/${productlist.productId}"/>" method="get">
<div class="container">
	<div class="row">
		<div class="col-md-4">
			<img alt="" src=<c:url value="/resources/images/${productlist.productId}.jpg"/> width="200" height="200">
			<div class="caption">
				<h4>Price:Rs.${productlist.price}/-</h4>
				<div>
				<h4>Name:${productlist.productName}</h4>
				</div>
				<div>
				<h4>Stock:${productlist.stock}</h4>
				</div>
				<p data-th="quantity">
				<input name="quantity" type="number" class="form-control text-center" value="1">
				</p>
			</div>
			<div class="ratings">
				<p>
					<span class="glyphicon glyphicon-star"></span>
					<span class="glyphicon glyphicon-star"></span>
					<span class="glyphicon glyphicon-star"></span>
					<span class="glyphicon glyphicon-star"></span>
					<span class="glyphicon glyphicon-star"></span>
					(15 reviews)
				</p>
			</div>
			<div class="btn-ground text-center">
				<input type="submit" class="btn btn-success" value="ADD TO CART"/>
			</div>
		</div>
	</div>
</div>
</form>
</body>
</html>