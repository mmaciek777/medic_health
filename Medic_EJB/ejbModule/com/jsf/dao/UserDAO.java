package com.jsf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import com.jsf.entities.User;

@Stateless
public class UserDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(User user) {
		em.persist(user);
	}

	public User merge(User user) {
		return em.merge(user);
	}

	public void remove(User user) {
		em.remove(em.merge(user));
	}

	public User get(Object id) {
		return em.find(User.class, id);
	}
	
	
	public User getUserFromDatabase(String login, String has�o) {
		
		User user = null;
		try {
		
        Query query = em.createQuery("select u from User u where u.login like :login and u.has�o like :has�o ");
        query.setParameter("login", login);
        query.setParameter("has�o", has�o);
        
        User user2 = (User) query.getSingleResult();
        
        return user2;
		}
		catch(NoResultException nre) {
			
		}
		return user;
	}
	
}