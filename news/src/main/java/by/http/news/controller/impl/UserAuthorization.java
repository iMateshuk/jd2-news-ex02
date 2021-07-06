package by.http.news.controller.impl;

import java.io.IOException;

import by.http.news.bean.User;
import by.http.news.bean.UserData;
import by.http.news.controller.Command;
import by.http.news.controller.CommandName;
import by.http.news.service.ServiceException;
import by.http.news.service.ServiceProvider;
import by.http.news.service.UserService;
import by.http.news.util.LogWriter;
import by.http.news.util.UserTool;
import by.http.news.util.View;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserAuthorization implements Command {

	private final static UserService userService = ServiceProvider.getInstance().getUserService();

	private final static String commandAnswer = CommandName.USER_ANSWER.toString().toLowerCase();
	private final static String commandAutho = CommandName.AUTHORIZATION.toString().toLowerCase();

	final static String PATH = "/WEB-INF/jsp/" + commandAnswer + ".jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {

			response.sendRedirect("Controller?command=" + commandAnswer + "&errorMessage=" + user.getLogin() + " "
					+ " already logged in!&action=" + commandAutho);
			return;

		}

		UserData userData = new UserTool().create(request);

		View.print(userData);

		try {

			user = userService.authorization(userData);

			View.print(user);

			HttpSession session = request.getSession(true);

			session.setAttribute("user", user);
			// session.setAttribute("action", commandAutho);

			response.sendRedirect("Controller?command=" + commandAnswer + "&action=" + commandAutho);

		} catch (ServiceException e) {

			LogWriter.writeLog(e);

			request.setAttribute("errorMessage", e.getMessage());

			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH);
			requestDispatcher.forward(request, response);

		}

	}

}
