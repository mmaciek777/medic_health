package com.jsf.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jsf.entities.Szczepionka;

@Stateless
public class SzczepionkaDAO {

	@PersistenceContext
	EntityManager em;

	public void create(Szczepionka szczepionka) {
		em.persist(szczepionka);
	}

	public Szczepionka merge(Szczepionka szczepionka) {
		return em.merge(szczepionka);
	}

	public void remove(Szczepionka szczepionka) {
		em.remove(em.merge(szczepionka));
	}

	public Szczepionka find(Object id) {
		return em.find(Szczepionka.class, id);
	}
}