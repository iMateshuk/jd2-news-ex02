package by.http.news.dao;

import by.http.news.bean.News;

public interface NewsDAO {
	
	void add(News news) throws DAOException;
	
	void update(News news) throws DAOException;
	
	void delete(News news) throws DAOException;

}
