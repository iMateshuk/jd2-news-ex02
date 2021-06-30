package by.http.news.dao;

import by.http.news.dao.impl.NewsImplDAO;
import by.http.news.dao.impl.UserImplDAO;

public class DAOProvider {
	
	private static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new UserImplDAO();
	
	private final NewsDAO newsDAO = new NewsImplDAO();
 	
	private DAOProvider() {}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	};
	
	

}
