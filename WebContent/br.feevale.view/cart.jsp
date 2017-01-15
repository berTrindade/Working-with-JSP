<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>HTML Menu</title>
		<link rel = "stylesheet" type = "text/css" href = "${pageContext.request.contextPath}/css/style-listing.css">
	</head>
	<body>
	<span id="user-type">Ol&aacute; <b><i>${user.username}</i></b></span>
		<table>
			<caption>Products table</caption>
			<tr>
				<th>ID</th>
				<th>Product</th> 
				<th>Price $</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
			<c:forEach var="item" items="${cart.items}">
				<tr>
					<td>${item.id}</td>
					<td>${item.product.name}</td>
					<td>${item.product.unitaryPrice}</td>
					<td>${item.quantity}</td>
					<td>${item.total}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="goBack"><a href = "${pageContext.request.contextPath}/CartManager?action=payment">Buy</a></div><br/>
		<div class="goBack"><a href = "${pageContext.request.contextPath}/br.feevale.view/index-v2.jsp">Go back to Menu</a></div>
	</body>
</html>