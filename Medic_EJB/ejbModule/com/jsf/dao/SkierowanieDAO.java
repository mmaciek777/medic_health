package com.jsf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jsf.entities.Skierowanie;

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

	public Skierowanie get(Object id) {
		return em.find(Skierowanie.class, id);
	}
}