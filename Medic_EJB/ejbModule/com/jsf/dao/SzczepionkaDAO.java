package com.jsf.dao;


import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.jsf.entities.Szczepionka;
import com.jsf.entities.User;

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
	public List<Szczepionka> getFullList() {
		List<Szczepionka> list = null;

		Query query = em.createQuery("select s from Szczepionka s");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Szczepionka> getList(Map<String, Object> searchParams) {
		List<Szczepionka> list = null;

		
		String select = "select p ";
		String from = "from Szczepionka p ";
		String where = "";
		String orderby = "order by p.nazwa_szczepionki asc";

		// search for surname
		String nazwa_szczepionki = (String) searchParams.get("nazwa_szczepionki");
		if (nazwa_szczepionki != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.nazwa_szczepionki like :nazwa_szczepionki ";
		}
		
		
		Query query = em.createQuery(select + from + where + orderby);

		if (nazwa_szczepionki != null) {
			query.setParameter("nazwa_szczepionki", nazwa_szczepionki+"%");
		}

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
	
	 	public Szczepionka findSzczepionka(int id) {
	    Query query = em.createQuery("select p from Szczepionka p where idSzczepionka=" + String.valueOf(id));
	    @SuppressWarnings("unchecked")
	    List<Szczepionka> list = query.getResultList();
	    Szczepionka szczepionka = list.get(0);
	    return szczepionka;
	    
	}

}