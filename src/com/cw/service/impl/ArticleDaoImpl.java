package com.cw.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cw.Entity.Article;
import com.cw.Entity.Reply;
import com.cw.Entity.Topic;
import com.cw.Entity.User;
import com.cw.Util.MyHSessionFactory;
import com.cw.service.ArticleDao;

public class ArticleDaoImpl implements ArticleDao {

	Session session = MyHSessionFactory.getSessionFactory().openSession();
	Transaction tx = null;
	@Override
	public List<Article> getAll() {
		tx = session.beginTransaction();
		String hql = "from Topic";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Article> list = query.list();
		tx.commit();
		return list;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getReply(Topic topic) {
		tx = session.beginTransaction();
		String hql = "from Reply where topicId = ? oder by postTime";
		Query query = session.createQuery(hql);
		query.setParameter(0,topic.getId());
		tx.commit();
		return query.list();
	}

	@Override
	public void saveTopic(Topic topic) {
		tx = session.beginTransaction();
		topic.setPostTime(new Date());
		session.save(topic);
		tx.commit();
		
	}

	@Override
	public void saveReply(Reply reply) {
		tx = session.beginTransaction();
		reply.setPostTime(new Date());
		session.save(reply);
		tx.commit();
		
	}

}
