package com.jsf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jsf.entities.Skierowanie;
import com.jsf.entities.Szczepionka;
import com.jsf.entities.User;

@Stateless
public class SkierowanieDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Skierowanie skierowanie) {
		em.persist(skierowanie);
	}

	public Skierowanie merge(Skierowanie skierowanie) {
		return em.merge(skierowanie);
	}

	public void remove(Skierowanie skierowanie) {
		em.remove(em.merge(skierowanie));
	}

	public Skierowanie find(Object id) {
		return em.find(Skierowanie.class, id);
	}
	
	
	public List<Skierowanie> getSkierowanieForUser(User u) {
		
		List<Skierowanie> list_foruser = null;

		if(u == null) {
			return list_foruser;
		}
		
		Query query = em.createQuery("Select s from Skierowanie s where s.user2.idUser = :id");

		query.setParameter("id", u.getIdUser());
		
		try {
			list_foruser = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list_foruser;
	}
	
	
	public List<Skierowanie> getFullList() {
		List<Skierowanie> list = null;

		Query query = em.createQuery("select s from Skierowanie s");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Skierowanie> getList(Map<String, Object> searchParams) {
		List<Skierowanie> list = null;

		String select = "select s ";
		String from = "from Skierowanie s ";
		String orderby = "order by s.idSkierowanie asc";

		Query query = em.createQuery(select + from + orderby);

		
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}
}