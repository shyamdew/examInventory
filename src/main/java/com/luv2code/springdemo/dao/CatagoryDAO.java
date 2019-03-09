package com.luv2code.springdemo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Inventory;
@Repository
public class CatagoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Inventory getInventory(Integer id) {
		if(id == null) {
			return null;
		}
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Inventory where id = :id");
		query.setParameter("id", id);
		return (Inventory) query.uniqueResult();
	}
}
