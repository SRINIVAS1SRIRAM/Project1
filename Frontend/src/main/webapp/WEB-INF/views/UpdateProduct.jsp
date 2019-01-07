<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<h3>Update Product Page</h3>

<form action="<c:url value="/updateProduct"/>" method="post">
<table align="center">
	<tr>
		<td>Product Id</td>
		<td><input type="text" id="productId" name="productId" value="${product.productId}" readonly/></td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td><input type="text" id="productName" name="productName" value="${product.productName}"/></td>
	</tr>
	<tr>
		<td>Product Desc</td>
		<td><input type="text" id="productDesc" name="productDesc" value="${product.productDesc}"/></td>
	</tr>
	<tr>
		<td>Category Id</td>
		<td><input type="text" id="categoryId" name="categoryId" value="${product.categoryId}"/></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><input type="text" id="stock" name="stock" value="${product.stock}"/></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input type="text" id="price" name="price" value="${product.price}"/></td>
	</tr>
	<tr>
		<td>Supplier Id</td>
		<td><input type="text" id="supplierId" name="supplierId" value="${product.supplierId}"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Update Product"/></td>
	</tr> 
</table>
</form>
</body>
</html>