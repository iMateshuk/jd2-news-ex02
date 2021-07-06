package by.http.news.dao.impl;

import by.http.news.bean.User;
import by.http.news.bean.UserData;
import by.http.news.dao.DAOException;
import by.http.news.dao.UserDAO;
import by.http.news.util.UserTool;

public class UserDB implements UserDAO {

	@Override
	public void registration(UserData userData) throws DAOException {
		// TODO Auto-generated method stub
		if (userData.getLogin().equals("Admin") || !userData.getLogin().equals("qwer")) {

			throw new DAOException("Sorry, user dao registration section under construction");
		}

	}

	@Override
	public void update(UserData userData) throws DAOException {
		// TODO Auto-generated method stub
		throw new DAOException("Sorry, user dao update section under construction");

	}

	@Override
	public void delete(UserData userData) throws DAOException {
		// TODO Auto-generated method stub
		throw new DAOException("Sorry, user dao delete section under construction");

	}

	@Override
	public User authorization(UserData userData) throws DAOException {
		// TODO Auto-generated method stub
		if (userData.getLogin().equals("qwer")) {

			return new UserTool().create(userData);
		}

		if (userData.getLogin().equals("Admin")) {
			
			userData.setRole("admin");

			return new UserTool().create(userData);
		}

		throw new DAOException("Sorry, user dao authorization section under construction");

	}

}
