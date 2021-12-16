package com.jsf.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jsf.entities.MaRole;

@Stateless
public class MaRoleDAO {

	@PersistenceContext
	EntityManager em;

	public void create(MaRole MaRole) {
		em.persist(MaRole);
	}

	public MaRole merge(MaRole MaRole) {
		return em.merge(MaRole);
	}

	public void remove(MaRole MaRole) {
		em.remove(em.merge(MaRole));
	}

	public MaRole find(Object id) {
		return em.find(MaRole.class, id);
	}
}