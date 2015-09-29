package com.cw.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cw.Entity.User;
import com.cw.Util.MyHSessionFactory;
import com.cw.service.UserDAO;

public class UserDAOImpl implements UserDAO {
	
	Session session = MyHSessionFactory.getSessionFactory().openSession();
	Transaction tx = null;
	@Override
	public boolean userLogin(User user) {
		tx = session.beginTransaction();
		String hql = "from User where username=? and password =?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List list = query.list();
		tx.commit();
		if(list.size()!=0)
			return true;
		else
			return false;
	}

	@Override
	public void userRegistry(User user) {
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
	}

	@Override
	public boolean userCheck(String username) {
		tx = session.beginTransaction();
		String hql = "from User where username=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, username);
		List list = query.list();
		tx.commit();
		if(list.size()!=0)
			return true;
		else
			return false;
	}

	@Override
	public User getUserByName(String username) {
		return (User) session.createQuery("from User where username = ?").setParameter(0, username).uniqueResult();
	}
	
	

}
