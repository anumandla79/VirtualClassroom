package com.virtualclassrooms.services;

import java.util.List;

import com.virtualclassrooms.dao.NewsDaoImpl;
import com.virtualclassrooms.model.News;

public class NewsServicesImpl implements NewsServices {
	public List<News> getNews() {
		List<News> topnews=new NewsDaoImpl().fetchNews();
		return topnews;
	}
}
