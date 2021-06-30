package by.http.news.util;

import by.http.news.bean.User;
import jakarta.servlet.http.HttpServletRequest;

public class UserGenerator {
	
	public static User generator(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
				
		return name != null ? new User.UserBuilder(login, password).setName(name).build() : 
			new User.UserBuilder(login, password).setName("noName").build();
		
	}

}
