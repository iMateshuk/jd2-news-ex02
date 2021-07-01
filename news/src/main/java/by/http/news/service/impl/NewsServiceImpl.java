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
		
		checkNewsField(news);

		try {

			newsDAO.add(news);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void update(News news) throws ServiceException {
		// TODO Auto-generated method stub
		
		checkNewsField(news);

		try {

			newsDAO.update(news);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public void delete(News news) throws ServiceException {
		// TODO Auto-generated method stub
		
		checkNewsField(news);

		try {

			newsDAO.delete(news);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	private void checkNewsField(News news) throws ServiceException {

		/*
		 * if (news.getTitle() == null || news.getTitl().isEmpty() ||
		 * news.getTitl().isBlank()) {
		 * 
		 * throw new ServiceException("News is null or empty"); }
		 * 
		 * if (news.getBody() == null || news.getBody().isEmpty() ||
		 * news.getBody().isBlank()) {
		 * 
		 * throw new ServiceException("NewsBody is null or empty"); }
		 * 
		 * int lenght = 3;
		 * 
		 * if (news.getTitle().length() < lenght) {
		 * 
		 * throw new ServiceException("Title lenght must be more or equal " + lenght); }
		 * 
		 * if (news.getTitle().matches(".*\\W+.*")) {
		 * 
		 * throw new ServiceException("Title contain illegal char"); }
		 * 
		 */
	}

}
