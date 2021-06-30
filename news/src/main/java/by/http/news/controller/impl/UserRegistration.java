package by.http.news.controller.impl;

import java.io.IOException;

import by.http.news.bean.User;
import by.http.news.controller.Command;
import by.http.news.controller.CommandName;
import by.http.news.service.ServiceException;
import by.http.news.service.ServiceProvider;
import by.http.news.service.UserService;
import by.http.news.util.UserCreator;
import by.http.news.util.View;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserRegistration implements Command {

	private final static UserService userService = ServiceProvider.getInstance().getUserService();

	final static String PATH = "/WEB-INF/jsp/" + CommandName.ANSWER.toString().toLowerCase() + ".jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new UserCreator().create(request);

		View.print(user);

		try {

			userService.registration(user);

			request.setAttribute("user", user);

		} catch (ServiceException e) {
			// LogWriter.writeLog(e);
			request.setAttribute("errorMessage", e.getMessage());
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH);
		requestDispatcher.forward(request, response);

	}

}
