package com.cw.action;

import com.cw.Entity.Reply;
import com.cw.Entity.Topic;
import com.cw.Entity.User;
import com.cw.service.ArticleDao;
import com.cw.service.UserDAO;
import com.cw.service.impl.ArticleDaoImpl;
import com.cw.service.impl.UserDAOImpl;
import com.opensymphony.xwork2.ActionContext;

public class ReplyAction extends SuperAction {
	ArticleDao a = new ArticleDaoImpl();
	UserDAO u = new UserDAOImpl();
	private static final long serialVersionUID = 1L;

	public String Delete() {
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		Reply r = new Reply();
		r.setId(replyId);
		ActionContext.getContext().getSession()
				.put("lastURL", request.getContextPath());
		a.deleteReply(r);
		return "DELETE";
	}

	public String Save() {
		int topicId = Integer.parseInt(request.getParameter("topicId"));
		Reply r = new Reply();
		String username = (String) ActionContext.getContext().getSession()
				.get("username");
		User user = u.getUserByName(username);
		r.setAuthor(user);
		;
		r.setContent((String) request.getAttribute("content"));
		Topic topic = a.getTopic(topicId);
		r.setTopic(topic);
		a.saveReply(r);
		ActionContext
				.getContext()
				.getSession()
				.put("lastPage",
						request.getSession().getServletContext()
								.getRealPath("url"));
		return "SAVE";
	}
}
