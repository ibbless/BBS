package com.cw.service;

import java.util.List;

import com.cw.Entity.Article;
import com.cw.Entity.Topic;

public interface ArticleDao {
		public List<Article> getAll();
		public List<Article> getReply(Topic topic);
		
		
}
