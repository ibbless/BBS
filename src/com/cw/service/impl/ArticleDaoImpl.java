package com.cw.service.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cw.Entity.Article;
import com.cw.Entity.Reply;
import com.cw.Entity.Topic;
import com.cw.Util.MyHSessionFactory;
import com.cw.service.ArticleDao;

public class ArticleDaoImpl implements ArticleDao {

	Session session = MyHSessionFactory.getSessionFactory().openSession();
	Transaction tx = null;
	@Override
	public List<Article> getAll() {
		tx = session.beginTransaction();
		String hql = "from Topic t order by t.postTime";
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
		String hql = "from Reply where topicId = ? order by postTime";
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


	@Override
	public Topic getTopic(int id) {
		tx = session.beginTransaction();
		Topic topic = new Topic();
		topic.setId(id);
		String hql = "from Topic where id = ?";
		Query query = session.createQuery(hql).setParameter(0, topic.getId());
		Topic result = (Topic) query.list().get(0);
		tx.commit();
		return result;
	}


	@Override
	public void deleteTopic(Topic topic) {
		tx = session.beginTransaction();
		String hql = "delete from Topic where id = ?";
		Query query = session.createQuery(hql).setParameter(0, topic.getId());
		query.executeUpdate();
		tx.commit();
	}


	@Override
	public void deleteReply(Reply reply) {
		tx = session.beginTransaction();
		String hql = "delete from Reply where id = ?";
		Query query = session.createQuery(hql).setParameter(0, reply.getId());
		query.executeUpdate();
		tx.commit();
	}

}
