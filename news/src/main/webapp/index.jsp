<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="CSS/styles.css" rel="stylesheet" type="text/css">

</head>

<body>

	<div class="header">

		<div class="headerLeft">

			<h1>NEWS</h1>

		</div>

		<div class="headerRight">

			<form action="Controller" method="post">
				<input type="hidden" name="command" value="user_action" />
				<button class="user" type="submit" name="action" value="userAction">Login</button>
			</form>

		</div>

	</div>

	<div id="body">

		<p class="info">Soon there will be <strong>NEWS</strong> !!!</p>

	</div>

	<div class="clear"></div>

</body>


</html>

