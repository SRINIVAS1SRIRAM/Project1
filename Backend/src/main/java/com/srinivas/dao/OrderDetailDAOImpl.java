package com.srinivas.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srinivas.model.OrderDetail;

@Transactional
@Repository("orderDetailDAO")
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
   	SessionFactory sessionFactory;

	@Override
	public boolean updateCartItemStatus(String username) {
		try
		{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("update Cart set paymentStatus='P' where username=:username");
			query.setParameter("username", username);
			System.out.println(2);
			int row_eff=query.executeUpdate();
			if(row_eff>0)
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			System.out.println("exception occured:" + e);
			return false;
		}
	}

	@Override
	public boolean paymentProcess(OrderDetail orderDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("exception occured in adding" + e);
			return false;
		}
	}
	
	


}
