<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit product</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

	<h2 class="text-center font-italic mb-5 mt-5">Edit PRODUCT DATA</h2>
	
		<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateform()"  style="text-align: center;">
			
			<div class="form-group mb-2">
				<label class="font-italic font-weight-bold" for="proId">PRODUCT ID</label>
				<input type="text" name="proId" id="proId" class="form-control-sm" value="${existingProduct.proId}" readonly="readonly">
			</div>
			
			<div class="form-group mb-2">
				<label class="font-italic font-weigtht-bold" for="proName">PRODUCT NAME:</label>
				<input type="text" name="proName" id="proName" class="form-control-sm" value="${existingProduct.proName}" required>
			</div>
			
			<div class="form-group mb-2">
				<label class="font-italic font-weight-bold" for="proPrice">PRODUCT PRICE:</label>
				<input type="number" name="proPrice" id="proPrice" class="form-control-sm"  value="${existingProduct.proPrice}" required>
			</div>
			
			
			<div class="form-group mb-2">
				<label class="font-italic font-weight-bold" for="proBrand">PRODUCT BRAND:</label>
				<input type="text" name="proBrand" id="proBrand" class="form-control-sm"  value="${existingProduct.proBrand}" required>
			</div>
			
			<div class="form-group mb-2">
				<label class="font-arial font-weight-bold" for="proMadeIn">PRODUCT MADE IN:</label>
				<input type="text" name="proMadeIn" id="proMadeIn" class="form-control-sm"  value="${existingProduct.proMadeIn}" required>
			</div>
			
			<div class="form-group mb-2">
				<label class="font-italic font-weight-bold" for="proMfgDate">PRODUCT MFG DATE:</label>
				<input type="date" name="proMfgDate" id="proMfgDate" class="from-control-sm"  value="${existingProduct.proMfgDate}" required>
			</div>
			
			<div class="form-group mb-2">
				<label class="font-italic font-weight-bold" for="proExpDate">PRODUCT EXP DATE:</label>
				<input type="date" name="proExpDate" id="proExpDate" class="form-control-sm"  value="${existingProduct.proExpDate}" required>
			</div>
			
			<div class="form-group mt-3 ">
				<label class="font-italic font-weight-bold" for="proImage">PRODUCT IMAGE</label>
				<input type="file" name="proImage" id="proImage" accept="image/*" class="form-control-sm"  value="${existingProduct.proImage}" >
			</div>
			
			<input type="submit" class="btn btn-success mb-3 mt-4" value="update PRODUCT">
			
			
			
			
		
		</form>


	

</body>
</html>