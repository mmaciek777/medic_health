package com.jsfcourse.szczepionka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import com.jsf.dao.SzczepionkaDAO;
import com.jsf.entities.Szczepionka;

@Named
@RequestScoped
public class SzczepionkaListBB {
	private static final String PAGE_SZCZEPIONKA_EDIT = "szczepionkaEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nazwa_szczepionki;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	SzczepionkaDAO szczepionkaDAO;
		
	public String getNazwa_szczepionki() {
		return nazwa_szczepionki;
	}

	public void setNazwa_szczepionki(String nazwa_szczepionki) {
		this.nazwa_szczepionki = nazwa_szczepionki;
	}

	public List<Szczepionka> getFullList(){
		return szczepionkaDAO.getFullList();
	}

	public List<Szczepionka> getList(){
		List<Szczepionka> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwa_szczepionki != null && nazwa_szczepionki.length() > 0){
			searchParams.put("nazwa_szczepionki", nazwa_szczepionki);
		}
		
		//2. Get list
		list = szczepionkaDAO.getList(searchParams);
		
		return list;
	}

	public String newSzczepionka(){
		Szczepionka szczepionka = new Szczepionka();
		
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash	
		flash.put("szczepionka", szczepionka);
		
		return PAGE_SZCZEPIONKA_EDIT;
	}

	public String editSzczepionka(Szczepionka szczepionka){
		//1. Pass object through session
		//HttpSession session = (HttpSession) extcontext.getSession(true);
		//session.setAttribute("person", person);
		
		//2. Pass object through flash 
		flash.put("szczepionka", szczepionka);
		
		return PAGE_SZCZEPIONKA_EDIT;
	}

	public String deleteSzczepionka(Szczepionka szczepionka){
		szczepionkaDAO.remove(szczepionka);
		return PAGE_STAY_AT_THE_SAME;
	}
}
