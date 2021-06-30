package by.http.news.service.impl;

import by.http.news.bean.News;
import by.http.news.dao.DAOException;
import by.http.news.dao.DAOProvider;
import by.http.news.dao.NewsDAO;
import by.http.news.service.NewsService;
import by.http.news.service.ServiceException;

public class NewsServiceImpl implements NewsService {

	private static final DAOProvider provider = DAOProvider.getInstance();

	private static final NewsDAO newsDAO = provider.getNewsDAO();

	@Override
	public void add(News news) throws ServiceException {
		// TODO Auto-generated method stub

		try {

			newsDAO.add(news);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e);
		}

	}

	@Override
	public void update(News news) throws ServiceException {
		// TODO Auto-generated method stub

		try {

			newsDAO.update(news);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e);
		}

	}

	@Override
	public void delete(News news) throws ServiceException {
		// TODO Auto-generated method stub
		
		try {

			newsDAO.delete(news);

		} catch (DAOException e) {
			// log
			throw new ServiceException(e);
		}

	}

}
