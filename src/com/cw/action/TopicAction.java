package com.cw.action;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.cw.Entity.Reply;
import com.cw.Entity.Topic;
import com.cw.service.ArticleDao;
import com.cw.service.impl.ArticleDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class TopicAction extends SuperAction {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao = new ArticleDaoImpl();
	
		public String Home(){
			List list = articleDao.getAll();
			ActionContext.getContext().put("list", list);
			return "HOME";
		}
		public String ShowTopic(){
			int id = Integer.parseInt(request.getParameter("TopicId"));
			Topic topic = articleDao.getTopic(id);
			List rlist = articleDao.getReply(topic);
			ActionContext.getContext().put("topic", topic);
			ActionContext.getContext().put("replies", rlist);
			return "TOPIC_VIEW";
		}
}
