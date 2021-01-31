package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Person;
@Repository
@Transactional
public class PersonDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void savePerson(Person person) {
		getSession().save(person);
	}
	
	@SuppressWarnings("deprecation")
	public List<Person> getPersons() {
		return getSession().createCriteria(Person.class).list();
	}

	private Session getSession() {
		
		Session session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

}
