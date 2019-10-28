<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
	<%@ include file="parts/header.jsp" %>
	<title>Welcome Page</title>
</head>

<c:url var="toPrintOdd" value="printOdd"/>


<c:url var="toFibonacci" value="fibonacci"/>

<c:url var="courseForm" value="courseForm"/>

<body class="bg-secondary">
	<div class="container">
		<h1 class="text-info text-center font-weight-bold">Welcome please choose a page to go to</h1>
		<hr>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col"><a href="${toPrintOdd}" class="text-white">To printOdd</a></th>
					<th scope="col"><a href="${toFibonacci}" class="text-white">To Fibonacci</a> </th>
					<th scope="col"><a href="${courseForm}" class="text-white">To Course Form</a> </th>																																																																																																																																													
				</tr>
			</thead>
		</table>
	</div>
	
		<%@ include file="parts/footer.jsp" %>
</body>
</html>

