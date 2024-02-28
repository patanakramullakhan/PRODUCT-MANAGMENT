<%@page import="com.akram.project.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ page import="com.akram.project.*" %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of products</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

	<h1>LIST OF PRODUCTS</h1>
	<table border="2">
		<thead>
		
			<th>PRODUCT ID</th>
			<th>PRODUCT NAME</th>
			<th>PRODUCT PRICE</th>
			<th>PRODUCT BRAND</th>
			<th>PRODUCT MADE IN</th>
			<th>PRODUCT MFG DATE</th>
			<th>PRODUCT EXP DATE</th>
			<th>PRODUCT IMAGE</th>
			<th>ACTION</th>
	
		</thead>
	
		<tbody>
			<c:forEach items="<%=new ProductDao().listOfData() %>" var="product">
			
				<tr>
					<td>${product.proId}</td>
					<td>${product.proName}</td>
					<td>${product.proPrice}</td>
					<td>${product.proBrand}</td>
					<td>${product.proMadeIn}</td>
					<td>${product.proMfgDate}</td>
					<td>${product.proExpDate}</td>
			
			
					<td>
   						<img src="data:image/jpeg;base64,${product.base64ProductImage}" alt="Product Image" style="max-width: 100px; max-height: 100px;">
					</td>
			
					<td>
						<a href="./DeleteProductServlet?proId=${product.proId}">DELETE</a>
						<a href="./EditProductServlet?proId=${product.proId}">EDIT</a>
					</td>
			
			
				</tr>
				
			</c:forEach>

		</tbody>
	

	</table>
	
	
	<button onclick="window.location.href='home.html'" class="btn btn-success">HOME</button>
	

	

</body>
</html>