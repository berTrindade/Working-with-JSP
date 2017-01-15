<!DOCTYPE html>
<html>
	<head>
		<title>HTML Menu</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-index-v2.css">
	</head>
	<body>
		<span id="user-type">Ol&aacute; <b><i>${user.username}</i></b></span>
		<div>
			<ol>
				<li><a href="${pageContext.request.contextPath}/ProductManager">Products list</a></li>
				<li><a href="cart.jsp">Cart list</a></li>
				<li><a href="crud.jsp">CRUD</a></li>
				<li><a href="clean-product-listing.jsp">Cart cleaning</a></li>
			</ol>
		</div>
	</body>
</html>