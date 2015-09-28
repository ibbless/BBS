package com.cw.action;

import com.cw.Entity.Reply;
import com.cw.service.ArticleDao;
import com.cw.service.impl.ArticleDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class ReplyAction extends SuperAction {
	ArticleDao a = new ArticleDaoImpl();
	private static final long serialVersionUID = 1L;
	public String Delete(){
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		Reply r = new Reply();
		r.setId(replyId);
		ActionContext.getContext().getSession().put("lastURL", request.getContextPath());
		a.deleteReply(r);
		return "DELETE";
	}
}
