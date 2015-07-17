<html>
<head>
<style type="text/css">
li{
list-style-type: none;
margin: 5px;
}
</style>
</head>
<body>
	<h2>Please Login</h2>
	<form name="login" action="LoginServlet" method="post"
		accept-charset="utf-8">
		<ul>
			<li><label for="usermail">Username</label> <input type="text"
				name="username" placeholder="Username" required></li>
			<li><label for="password">Password</label> <input
				type="password" name="password" placeholder="password" required></li>
			<li><input type="submit" value="Login"></li>
		</ul>
	</form>
</body>
</html>
