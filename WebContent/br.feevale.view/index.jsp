<!DOCTYPE html>
<html lang="en-US">
<head>
	<title>Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/Login">
			<fieldset>
				<legend>Log in</legend>
				<input type="text" name="username" placeholder="Username" size="12" maxlength="30" autofocus="autofocus"/><br/>
				<input type="password" name="password" placeholder="Password" size="12" />
			</fieldset>
			<input type="submit" value="Submit"/>
		</form>
	</div>
	<span>${message}</span>
</body>
</html>