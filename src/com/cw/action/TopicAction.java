package com.cw.action;

import java.util.List;

import com.cw.service.ArticleDao;
import com.cw.service.impl.ArticleDaoImpl;

public class TopicAction extends SuperAction {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao = new ArticleDaoImpl();
	
		public String Home(){
			List list = articleDao.getAll();
			request.setAttribute("list", list);
			return "HOME";
		}
}
