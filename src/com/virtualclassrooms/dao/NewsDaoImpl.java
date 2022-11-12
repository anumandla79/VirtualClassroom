package com.virtualclassrooms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtualclassrooms.model.News;

public class NewsDaoImpl implements NewsDao {
	public List<News> fetchNews(){
		List<News> topnews=null;
		Statement stmt = null ;
		ResultSet rs = null ;
		try(Connection con =new DbConnectionImpl().getConnection()){
			stmt= con.createStatement();
			String query = "SELECT * FROM news order by news_id desc";
			rs= stmt.executeQuery(query);
			topnews= new ArrayList<News>();
			while(rs.next()) {
				String headline = rs.getString("news_headline");
				String content = rs.getString("news_content");
				News news = new News(headline,content);
				System.out.println(news);
				topnews.add(news);
			}
			return topnews;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return topnews;
	}
}
