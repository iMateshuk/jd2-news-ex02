package by.http.news.service.impl;

import by.http.news.bean.User;
import by.http.news.bean.UserData;
import by.http.news.dao.DAOException;
import by.http.news.dao.DAOProvider;
import by.http.news.dao.UserDAO;
import by.http.news.service.ServiceException;
import by.http.news.service.UserService;

public class UserServiceImpl implements UserService {

	private static final DAOProvider provider = DAOProvider.getInstance();

	private static final UserDAO userDAO = provider.getUserDAO();

	@Override
	public void registration(UserData userData) throws ServiceException {
		// TODO Auto-generated method stub

		checkUserField(userData);

		try {

			userDAO.registration(userData);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void update(UserData userData) throws ServiceException {
		// TODO Auto-generated method stub

		checkUserField(userData);

		try {

			userDAO.update(userData);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void delete(UserData userData) throws ServiceException {
		// TODO Auto-generated method stub

		checkUserField(userData);

		try {

			userDAO.delete(userData);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public User authorization(UserData userData) throws ServiceException {
		// TODO Auto-generated method stub

		checkUserField(userData);

		try {

			return userDAO.authorization(userData);

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}

	}

	private void checkUserField(UserData userData) throws ServiceException {

		int lenght = 3;

		String password = userData.getPassword();
		String login = userData.getLogin();
		String email = userData.getEmail();

		if (login == null || login.isEmpty() || login.isBlank()) {

			throw new ServiceException("Login is null or empty");
		}

		if (password == null || password.isEmpty() || password.isBlank()) {

			throw new ServiceException("Password is null or empty");
		}

		if (login.length() < lenght) {

			throw new ServiceException("Login lenght must be more or equal " + lenght);
		}

		if (password.length() < lenght) {

			throw new ServiceException("Password lenght must be more or equal " + lenght);
		}

		if (login.matches(".*\\W+.*")) {

			throw new ServiceException("Login contain illegal char");
		}

		if (email != null && !email.isEmpty() && !email.isBlank()
				&& !email.matches("^\\w{3}\\w*@\\w{3}\\w*\\.\\w{2}\\w*$")) {

			throw new ServiceException("E-mail field are incorrect");
		}

	}

	
}
