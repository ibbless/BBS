package com.cw.action;

import java.util.List;

import com.cw.Entity.PageBean;
import com.cw.Entity.Topic;
import com.cw.service.ArticleDao;
import com.cw.service.impl.ArticleDaoImpl;
import com.opensymphony.xwork2.ActionContext;

public class TopicAction extends SuperAction {

	
	private static final long serialVersionUID = 1L;
	ArticleDao articleDao = new ArticleDaoImpl();
	private int pageNum = 1;
	private int pageSize = 10;
		public String Home(){
			List list = articleDao.getAll();
			ActionContext.getContext().put("list", list);
			return "HOME";
		}
		public String Show(){
			int id = Integer.parseInt(request.getParameter("TopicId"));
			Topic topic = articleDao.getTopic(id);
			
			
			PageBean pageBean = articleDao.getPageBeanByTopic(pageNum,pageSize,topic);
			ActionContext.getContext().getValueStack().push(pageBean);
			
			
			
			
			ActionContext.getContext().put("topic", topic);
			return "TOPIC_VIEW";
		}
		public String lastPage(){
			return "LASTPAGE";
		}
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		
}
