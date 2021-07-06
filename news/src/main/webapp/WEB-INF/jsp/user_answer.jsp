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
			if (user == null) {

				user = (User) session.getAttribute("user");
			}
			
			String action = (String) session.getAttribute("action");
			if (action == null) {

				action = (String) request.getParameter("action");
			}
			if (action == null) {
				action = "unknown";
			}

			String errorMessage = (String) request.getAttribute("errorMessage");
			if (errorMessage == null) {

					errorMessage = request.getParameter("errorMessage");
			}
			
			
			StringBuilder answer = new StringBuilder(action.toUpperCase()).append("<br/>");

			if (user == null || user.getLogin().isEmpty()) {
				
				if (!action.toLowerCase().equals("loggedout")) {

					answer.append("<font color=\"red\">").append("Failed").append("</font>").append("<br/> <br/>");
				}
				
			}

			if (errorMessage != null) {

					answer.append(errorMessage).append("<br/> <br/>");
			}

			if (user != null && errorMessage == null) {

				answer.append("<font color=\"#ff8000\">").append("success").append("</font>").append("<br/>").append("<br/>");
				
				if (user.getName() != null && !(user.getName().equals("noName") || user.getName().isEmpty())) {

					answer.append("name: " + user.getName()).append("<br/>");

				}

				answer.append("login: " + user.getLogin()).append("<br/> <br/>");

			}
			
			out.println(answer.toString());
			
			if (user == null || user.getRole().equals("admin")) {

				answer.setLength(0);

				answer.append("<form action=\"Controller\" method=\"post\">");
				answer.append("<input type=\"hidden\" name=\"command\" value=\"user_action\" />");
				answer.append("<button class=\"user\" type=\"submit\" name=\"action\" value=\"userAction\">User page</button>");
				answer.append("</form><br/>");

				out.println(answer.toString());
			}
			%>

		</div>

		<form action="Controller" method="post">

			<button type="submit" name="command" value="main">Main Page</button>

		</form>

	</div>

</body>
</html>