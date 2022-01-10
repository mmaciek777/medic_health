package com.jsf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jsf.entities.MaRole;

@Stateless
public class MaRoleDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(MaRole marole) {
		em.persist(marole);
	}

	public MaRole merge(MaRole marole) {
		return em.merge(marole);
	}

	public void remove(MaRole marole) {
		em.remove(em.merge(marole));
	}

	public MaRole get(Object id) {
		return em.find(MaRole.class, id);
	}
}