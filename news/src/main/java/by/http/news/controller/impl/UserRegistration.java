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

public class UserRegistration implements Command {

	private final static UserService userService = ServiceProvider.getInstance().getUserService();

	private final static String commandAnswer = CommandName.USER_ANSWER.toString().toLowerCase();
	private final static String commandAutho = CommandName.AUTHORIZATION.toString().toLowerCase();
	private final static String commandReg = CommandName.REGISTRATION.toString().toLowerCase();

	final static String PATH = "/WEB-INF/jsp/" + commandAnswer + ".jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserData userData = new UserTool().create(request);

		View.print(userData);

		try {

			userService.registration(userData);
			
			User user = (User) request.getSession().getAttribute("user");

			if (user != null && user.getRole().equals("admin")) {
				
				response.sendRedirect("Controller?command=" + commandAnswer + "&errorMessage=" + userData.getLogin() + " "
						+ commandReg + " success!&action=" + commandReg);

			} else {
				
				response.sendRedirect("Controller?command=" + commandAutho + "&message=" + userData.getLogin() + " "
						+ commandReg + " success!");

			}

		} catch (ServiceException e) {

			LogWriter.writeLog(e);

			request.setAttribute("errorMessage", e.getMessage());

			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PATH);
			requestDispatcher.forward(request, response);

		}

	}

}
