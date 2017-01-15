<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>HTML Menu</title>
		<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/css/style-listing.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
	</head>
	<body>
		<form method="post" action="${pageContext.request.contextPath}/CartManager?action=add" onsubmit="return validateForm('fruit');">
			<table>
				<caption>Products table</caption>
				<tr>
					<th>ID</th>
					<th>Product</th> 
					<th>Price $</th>
					<th><input type="checkbox" id="cChart" onclick="checkAll(this, 'fruit');"></th>
				</tr>	
				
				<c:forEach var="arrayList" items="${arrayList}">
					<tr>
						<td>${arrayList.id}</td>
						<td>${arrayList.name}</td>
						<td>${arrayList.unitaryPrice}</td>
						<td><input type="checkbox" name="fruit" id="cFruit" value="${arrayList.id}"><label for="cFruit"></label></td>
					</tr>
				</c:forEach>
				<tr><td colspan="4"><input type="submit" name="submit" value="Press me!"></td></tr>
			</table>
		</form>
		<div class="goBack"><a href = "${pageContext.request.contextPath}/br.feevale.view/index-v2.jsp">Go back to Menu</a></div>
	</body>
</html>