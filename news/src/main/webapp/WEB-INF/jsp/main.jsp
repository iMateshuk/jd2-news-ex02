<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="by.http.news.bean.User" import="by.http.news.bean.News"
	import="by.http.news.bean.News" import="java.util.List" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<title>Insert title here</title>
<link href="CSS/styles.css" rel="stylesheet" type="text/css">

</head>
<body>


	<div class="header">

		<div class="headerLeft">

			<h1>NEWS</h1>

		</div>

		<div class="headerRight">

			<%
			User user = (User) request.getAttribute("user");
			if (user == null) {

				user = (User) session.getAttribute("user");
			}

			StringBuilder sb = new StringBuilder();

			if (user != null) {

				sb.setLength(0);

				sb.append("<form action=\"Controller\" method=\"post\">");
				sb.append("<button class=\"user\" type=\"submit\" name=\"command\" value=\"loggedout\">Logged out</button>");
				sb.append("</form><br/>");

				out.println(sb.toString());

			}

			if (user == null || user.getRole().equals("admin")) {

				sb.setLength(0);

				sb.append("<form action=\"Controller\" method=\"post\">");
				sb.append("<button class=\"user\" type=\"submit\" name=\"command\" value=\"user_action\">User</button>");
				sb.append("</form><br/>");

				out.println(sb.toString());

			}
			%>

			<!-- <form action="Controller" method="post">
				<input type="hidden" name="command" value="user_action" />
				<button class="user" type="submit" name="action" value="userAction">Login</button>
			</form> -->

		</div>

	</div>

	<div id="body">

		<!-- <p class="info">
			Soon there will be <strong>NEWS</strong> !!!
		</p> -->

		<%
		@SuppressWarnings({"unchecked"})
		List<News> newses = (List<News>) request.getAttribute("newses");
		
		sb.setLength(0);
		
		if (newses == null){
			
			sb.append("<p class=\"info\"> Soon there will be <strong>NEWS</strong> !!! </p>");
		} else {
			
			for (News news : newses) {
				
				sb.append("<i>Title:</i> <strong>" + news.getTitle() + "</strong> </br> ");
				sb.append("<button type=\"button\" class=\"collapsible\">"+ news.getBrief()+" ...</button>");
				sb.append("<div class=\"content\"> <p>" + news.getBody() + "</p> </div> </br>");
				
			}
			
		}
		
		out.println(sb.toString());

		%>

	</div>
	
	<script>
		var coll = document.getElementsByClassName("collapsible");
		var i;

		for (i = 0; i < coll.length; i++) {
  			
			coll[i].addEventListener("click", function() {
    		
				this.classList.toggle("active");
    			var content = this.nextElementSibling;
    			
    			if (content.style.display === "block") {
	      			content.style.display = "none";
    			} else {
	      			content.style.display = "block";
    			}
  			});
		}
	</script>

	<div class="clear"></div>

</body>
</html>