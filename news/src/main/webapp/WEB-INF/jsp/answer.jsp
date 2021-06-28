<%@ page language="java" contentType="text/html; charset=utf-8"
	import="by.http.news.bean.User" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="CSS/userPageStyle.css" rel="stylesheet" type="text/css">

</head>
<body>

	<div id='wrapper'>

		<div id="answer">

			<%
			User user = (User) request.getAttribute("user");

			StringBuilder answer = new StringBuilder(request.getParameter("action").toUpperCase()).append("<br/>");

			if (user == null || user.getLogin().isEmpty() || user.getPassword().isEmpty()) {

				answer.append("<font color=\"red\">").append(" failed").append("</font>");

			} else {

				answer.append("<font color=\"#ff8000\">").append(" success").append("</font>").append("<br/>").append("<br/>");

				if (!(user.getName().equals("noName") || user.getName().isEmpty())) {

					answer.append("name: " + user.getName()).append("<br/>");

				}

				answer.append("login: " + user.getLogin()).append("<br/>");

				answer.append("password: " + request.getParameter("password")).append("<br/>");

			}

			out.println(answer.toString());
			%>
		</div>

		<br /> <br />

		<form action="Controller" method="post">

			<button type="submit" name="command" value="index">На
				главную</button>

		</form>

	</div>

</body>
</html>