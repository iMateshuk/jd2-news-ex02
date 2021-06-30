package by.http.news.service;

import by.http.news.bean.User;

public interface UserService {

	void registration(User user) throws ServiceException;

	void update(User user) throws ServiceException;

	void delete(User user) throws ServiceException;
	
	void authorization(User user) throws ServiceException;

}
