<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="http://cdcnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-primary">
	<ul class="navbar-nav">
		

		<c:choose>
		<c:when test="${sessionScope.loggedIn}">
		<c:if test="${sessionScope.role=='USER'}">
		<li class="nav-item"><a class="nav-brand" href="<c:url value="/userhome"/>"><img alt="S" src=<c:url value="/resources/images/logo.jpg"/> width="75" height="50"></a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/displayProduct"/>">Product Display</a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/cart"/>">Cart</a></li>
		<div class="nav navbar-nav navbar-right">
		<div id="userdetail">
		<font color="blue">${sessionScope.username}</font>
		</div>
		</div>
		<div id="userdetail">
				<font color="white">
				Welcome ${sessionScope.username}
				<a href="<c:url value="/perform_logout"/>" class="btn btn-danger">Logout</a>
				</font>
			</div>
		</c:if>
		<c:if test="${sessionScope.role=='ADMIN'}">
		<li class="nav-item"><a class="nav-brand" href="<c:url value="/adminhome"/>"><img alt="S" src=<c:url value="/resources/images/logo.jpg"/> width="75" height="50"></a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/category"/>">Category</a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/product"/>">Product</a></li>
		<div class="nav-navbar right">
		<div id="userdetail">
		<font color="blue">${sessionScope.username}</font>
		</div>
		</div>
		<div id="userdetail">
				<font color="white">
				Welcome ${sessionScope.username}
				<a href="<c:url value="/perform_logout"/>" class="btn btn-danger">Logout</a>
				</font>
			</div>
		</c:if>
		</c:when>
		<c:otherwise>
		<li class="nav-item"><a class="nav-brand" href="<c:url value="/home"/>"><img alt="" src=<c:url value="/resources/images/logo.jpg"/> width="75" height="50"></a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/register"/>">Register</a></li>
		<li class="nav-item"><a class="nav-link" href="<c:url value="/aboutus"/>">About us</a></li>
		<div class = "nav navbar nav navbar right">
		<li class="nav-item"><a class="btn btn-success" href="<c:url value="/login"/>">Login</a></li>
		</div>
		</c:otherwise>
		</c:choose>
		
			
	</ul>
</nav>
</body>
</html>