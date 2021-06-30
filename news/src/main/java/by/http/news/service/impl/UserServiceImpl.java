package by.http.news.service.impl;

import by.http.news.bean.User;
import by.http.news.dao.DAOException;
import by.http.news.dao.DAOProvider;
import by.http.news.dao.UserDAO;
import by.http.news.service.ServiceException;
import by.http.news.service.UserService;

public class UserServiceImpl implements UserService {

	private static final DAOProvider provider = DAOProvider.getInstance();

	private static final UserDAO userDAO = provider.getUserDAO();

	@Override
	public void registration(User user) throws ServiceException {
		// TODO Auto-generated method stub

		checkUserField(user);

		try {

			userDAO.registration(user);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void update(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		checkUserField(user);

		try {

			userDAO.update(user);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void delete(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		checkUserField(user);

		try {

			userDAO.delete(user);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e.getMessage(), e);
		}

	}
	
	@Override
	public void authorization(User user) throws ServiceException {
		// TODO Auto-generated method stub
		
		checkUserField(user);

		try {

			userDAO.authorization(user);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

	private void checkUserField(User user) throws ServiceException {
		
		if (user.getLogin() == null || user.getLogin().isEmpty() || user.getLogin().isBlank()) {

			throw new ServiceException("Login is null or empty");
		}

		if (user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().isBlank()) {

			throw new ServiceException("Password is null or empty");
		}
		
		int lenght = 3;

		if (user.getLogin().length() < lenght) {

			throw new ServiceException("Login lenght must be more or equal " + lenght);
		}

		if (user.getPassword().length() < lenght) {

			throw new ServiceException("Password lenght must be more or equal " + lenght);
		}
		
		if (user.getLogin().matches(".*\\W+.*")) {
			
			throw new ServiceException("Login contain illegal char");
		}
		
		if (user.getEmail() != null && !user.getEmail().isEmpty() && !user.getEmail().isBlank() 
				&& !user.getEmail().matches("^\\w{3}\\w*@\\w{3}\\w*\\.\\w{2}\\w*$"))
			
			throw new ServiceException("E-mail field are incorrect");
	}

}
