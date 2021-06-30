<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Выберите действие</h1>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="jsp" />

		<button type="submit" name="action" value="registration">Регистрация</button>
		<br /> <br />

		<button type="submit" name="action" value="authorization">Авторизация</button>
		<br /> <br />
		
	</form>
	
	
	<form action="Controller" method="post">
	
		<button type="submit" name="command" value="back">Вернуться</button>
		
	</form>
	

</body>
</html>