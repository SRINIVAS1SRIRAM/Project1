<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Category</title>
</head>
<body>

<h3 align="center">Update Category Page</h3>

<form action="<c:url value="/updateCategory"/>" method="post">
<table align="center">
	<tr>
		<td>Category Id</td>
		<td><input type="text" id="categoryId" name="categoryId" value="${category.categoryId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" id="categoryName" name="categoryName" value="${category.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" id="categoryDesc" name="categoryDesc" value="${category.categoryDesc}"/></td>
	</tr>
	<tr>
		<center>
		<td colspan="2"><input type="submit" value="Update Category"/></td>
		</center>
	</tr>
</table>
</form>

</body>
</html>