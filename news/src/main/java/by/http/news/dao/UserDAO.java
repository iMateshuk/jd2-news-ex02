package by.http.news.dao;

import by.http.news.bean.User;

public interface UserDAO {

	void registration(User user) throws DAOException;

	void update(User user) throws DAOException;

	void delete(User user) throws DAOException;
	
	void authorization(User user) throws DAOException;

}
