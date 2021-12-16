package com.jsf.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

	public Skierowanie find(Object id) {
		return em.find(Skierowanie.class, id);
	}
}