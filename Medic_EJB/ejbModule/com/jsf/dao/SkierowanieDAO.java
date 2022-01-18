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

	public Skierowanie get(Object id) {
		return em.find(Skierowanie.class, id);
	}
	
	public List<Skierowanie> getList(Map<String, Object> searchParams) {
		List<Skierowanie> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from Skierowanie p ";
		String where = "";
		String orderby = "";
		
		// search for surname
		String nazwisko = (String) searchParams.get("nazwisko");
		if (nazwisko != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.nazwisko like :nazwisko ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (nazwisko != null) {
			query.setParameter("nazwisko", nazwisko+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}
	
}