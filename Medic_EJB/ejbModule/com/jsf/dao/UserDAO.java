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
	
	
	public User getUserFromDatabase(String login, String has這) {
		
		User user = null;
		try {
		
        Query query = em.createQuery("select u from User u where u.login like :login and u.has這 like :has這 ");
        query.setParameter("login", login);
        query.setParameter("has這", has這);
        
        User user2 = (User) query.getSingleResult();
        
        return user2;
		}
		catch(NoResultException nre) {
			
		}
		return user;
	}
	
	
	 	public User findUser(int id) {
        Query query = em.createQuery("select u from User u where idUser=" + String.valueOf(id));
        @SuppressWarnings("unchecked")
        List<User> list = query.getResultList();
        User user = list.get(0);
        return user;
    }
	 	
	 	public User findUserPacjent(int id) {
	        Query query = em.createQuery("select u from User u where idUser=" + String.valueOf(id));
	        @SuppressWarnings("unchecked")
	        List<User> list = query.getResultList();
	        User user = list.get(0);
	        return user;
	}
	
	
	public List<User> getFullListAll() {
		List<User> listAll = null;

		Query query = em.createQuery("select u from User u");

		try {
			listAll = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listAll;
	}
	
	public List<User> getListAll(Map<String, Object> searchParams) {
		List<User> listAll = null;

		String select = "select u ";
		String from = "from User u ";
		String where = "";
		String orderby = "order by u.nazwisko asc";

		String nazwisko = (String) searchParams.get("nazwisko");
		if (nazwisko != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "u.nazwisko like :nazwisko ";
		}
		

		Query query = em.createQuery(select + from + where + orderby);

		if (nazwisko != null) {
			query.setParameter("nazwisko", nazwisko+"%");
		}

		try {
			listAll = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listAll;
		
	}
	
	
	
	public List<User> getFullList() {
		List<User> list = null;

		Query query = em.createQuery("select u from User u");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<User> getList(Map<String, Object> searchParams) {
		List<User> list = null;

		String select = "select u ";
		String from = "from User u ";
		String where = "where Nazwa_roli = 'Doktor' ";
		String orderby = "order by u.nazwisko asc";

		String nazwisko = (String) searchParams.get("nazwisko");
		if (nazwisko != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "u.nazwisko like :nazwisko ";
		}
		

		Query query = em.createQuery(select + from + where + orderby);

		if (nazwisko != null) {
			query.setParameter("nazwisko", nazwisko+"%");
		}

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
}