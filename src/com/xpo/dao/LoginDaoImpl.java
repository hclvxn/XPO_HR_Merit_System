package com.xpo.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpo.model.User;


@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getEmployee(String empid) {	
		
		
		
		return (User) sessionFactory.getCurrentSession().get(User.class, empid);
		
	}
	
	

}
