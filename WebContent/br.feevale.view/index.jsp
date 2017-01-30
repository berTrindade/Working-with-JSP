<!DOCTYPE html>
<html lang="en-US">
<head>
	<title>Login</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css" media ="(max-width: 320px)">
	
	<meta name="author" content="Bernardo T. de Abreu">
	<meta name="description" content="Shopping Cart Web project">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<div id="container">
	
		<header class="header grid-element"> 
			<h1 class="title">Shopping Cart</h1>
		</header> <!-- End of the Header -->
		
		<main id="main-subgrids" class="main grid-element"> 
			<div id="login">
				<h1 class="header title">Log in</h1>
				<form class="main" id="form" method="post">
					<fieldset>
						<input type="text" name="username" placeholder="Username" size="12" maxlength="30"/><br/>
						<input type="password" name="password" placeholder="Password" size="12" />
					</fieldset>
					<input type="submit" value="Submit"/>
				</form>
				<div id="login-help" class="footer">
					<p>Forgot your password ? <a href=""> Click here.</a></p>
				</div>
			</div>
		</main> <!-- End of the Main -->
		
		<footer class="grid-element footer"> 
			<p>Copyright &copy; <script type="text/javascript">document.write((new Date()).getFullYear()); </script> - by Bernardo T. de Abreu<br/></p>
			<ul>
				<li><a href="https://www.linkedin.com/in/berTrindade" target="_blank">Linkedin</a></li>
				<li><a href="https://github.com/berTrindade/" target="_blank">Github</a></li>
			</ul>
		</footer> <!-- End of the Footer -->
		
	</div> <!-- End of the Container -->
	
	<!-- <span>${message}</span> -->
</body>
</html>




	

	