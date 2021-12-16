package com.jsf.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jsf.entities.Rola;

@Stateless
public class RolaDAO {

	@PersistenceContext
	EntityManager em;

	public void create(Rola rola) {
		em.persist(rola);
	}

	public Rola merge(Rola rola) {
		return em.merge(rola);
	}

	public void remove(Rola rola) {
		em.remove(em.merge(rola));
	}

	public Rola find(Object id) {
		return em.find(Rola.class, id);
	}
}