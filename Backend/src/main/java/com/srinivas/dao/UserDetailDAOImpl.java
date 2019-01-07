package com.srinivas.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srinivas.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUserDetail(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	public boolean deleteUserDetail(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateUserDetail(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public List<UserDetail> listUserDetail() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from UserDetail");
		@SuppressWarnings("unchecked")
		List<UserDetail> listUserDetail = query.list();
		return listUserDetail;
	}

	public UserDetail getUserDetail(String username) {
		Session session = sessionFactory.openSession();
		UserDetail user = session.get(UserDetail.class, username);
		session.close();
		return user;
	}

	

	

}
