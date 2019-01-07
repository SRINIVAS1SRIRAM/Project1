<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>categoryjsp</title>
</head>
<body>
	<h3 align="center">Category Page</h3>
	
	<form action="<c:url value="/addCategory"/>" method="post">
	<table align="center">
		<tr>
			<td>Category Name</td>
			<td><input type="text" id="categoryName" name="categoryName"/></td>
		</tr>
		<tr>
			<td>Category Desc</td>
			<td><input type ="text" id="categoryDesc" name ="categoryDesc"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Add Categroy"/></td>
		</tr>
	</table>	
	</form>

	<table align="center" border="1">
		<tr>
			<td>Category Id</td>
			<td>Category Name</td>
			<td>Categroy Desc</td>
			<td>Operations</td>
		</tr>
		
		<c:forEach items="${listca}" var="category">
		<tr>
			<td>${category.categoryId}</td>
			<td>${category.categoryName}</td>
			<td>${category.categoryDesc}</td>
			<td>
				<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
				<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>