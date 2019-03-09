package com.luv2code.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CommonDAO {
	public static final Character INSERT = 'I';
	public static final Character MODIFY = 'M';
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	public Boolean insertOrUpdateRecord(Object obj,Character status){
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		if(status.equals(INSERT)){
			session.save(obj);
			return true;
		}else if(status.equals(MODIFY)){
			session.update(obj);
			return true;
		}else{
			return false;
		}
	}
}
