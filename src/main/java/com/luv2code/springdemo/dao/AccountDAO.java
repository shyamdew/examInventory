package com.luv2code.springdemo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Account;
import com.luv2code.springdemo.entity.Inventory;
@Repository
public class AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Account getInventory(Integer id) {
		if(id == null) {
			return null;
		}
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Account where id = :id");
		query.setParameter("id", id);
		return (Account) query.uniqueResult();
	}
}
