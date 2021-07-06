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

		<h1>User action</h1>

		<form action="Controller" method="post">

			<input type="hidden" name="command" value="registration" />
			<button type="submit" name="action" value="registration">Registration</button>

		</form>

		<br />
		
		<%		
				User user = (User) request.getAttribute("user");
				if (user == null) {

					user = (User) session.getAttribute("user");
				}
		
				StringBuilder sb = new StringBuilder();
		
				if (user == null) {
			
					sb.setLength(0);
					sb.append("<form action=\"Controller\" method=\"post\">");
					sb.append("<button type=\"submit\" name=\"command\" value=\"authorization\">Authorization</button>");
					sb.append("</form>");
					sb.append("<br/>");

					out.println(sb.toString());
			
				}
		
			%>

		<!-- <form action="Controller" method="post">

			<input type="hidden" name="command" value="authorization" />
			<button type="submit" name="action" value="authorization">Authorization</button>

		</form> -->

		<br />
		
		<form action="Controller" method="post">

			<button type="submit" name="command" value="index">Back</button>

		</form>

	</div>

</body>
</html>