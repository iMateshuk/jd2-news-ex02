package by.http.news.service;


import java.util.List;

import by.http.news.bean.News;

public interface NewsService {
	
	void add(News news) throws ServiceException;

	void update(News news) throws ServiceException;
	
	void delete(News news) throws ServiceException;
	
	List<News> load() throws ServiceException;

}
