package by.http.news.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.http.news.bean.News;
import by.http.news.dao.DAOException;
import by.http.news.dao.NewsDAO;
import by.http.news.util.NewsTool;

public class NewsDB implements NewsDAO {

	@Override
	public void add(News news) throws DAOException {
		// TODO Auto-generated method stub
		throw new DAOException("Sorry, news dao add section under construction");

	}

	@Override
	public void update(News news) throws DAOException {
		// TODO Auto-generated method stub
		throw new DAOException("Sorry, news dao update section under construction");

	}

	@Override
	public void delete(News news) throws DAOException {
		// TODO Auto-generated method stub
		throw new DAOException("Sorry, news dao delete section under construction");

	}

	@Override
	public List<News> load() throws DAOException {
		// TODO Auto-generated method stub
		
		List<News> newses = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			
			newses.add(new NewsTool().create());
			
		}
		
		//throw new DAOException("Sorry, news dao load section under construction"); 
		
		return newses;
	}

}
