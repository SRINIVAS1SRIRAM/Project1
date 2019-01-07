<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product-JSP</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body>
<div class="container">
<form:form action="addProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
	<table align="center" class="table table-bordered">
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td>Stock</td>
			<td><form:input path="stock" /></td>
		</tr>
		<tr>
			<td>Category Name</td>
			<td><form:select path="categoryId">
					<form:option value="0" label="--Select List--" />
					<form:options items="${categoryList}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Supplier Name</td>
			<td><form:select path="supplierId">
					<form:option value="0" label="--Select List--" />
					<form:options items="${supplierList}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc" /></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="pimage" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Insert" /></td>
		</tr>	
	</table>
</form:form>

<table align="center" class="table table-bordered">
	<tr>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Category</td>
		<td>Price</td>
		<td>Supplier</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${productlist}" var="product">
	<tr>
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.categoryId}</td>
		<td>${product.price}</td>
		<td>${product.supplierId}</td>
		<td>
			<a class="btn btn-success" href="<c:url value="/editProduct/${product.productId}"/>">Edit</a>
			<a class="btn btn-danger" href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>

</div>

</body>
</html>