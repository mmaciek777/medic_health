package com.jsfcourse.szczepionka;

import java.sql.Date;
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

import com.jsf.dao.SkierowanieDAO;
import com.jsf.dao.SzczepionkaDAO;
import com.jsf.entities.Skierowanie;
import com.jsf.entities.Szczepionka;

@Named
@RequestScoped
public class SzczepionkaListBB {
	private static final String PAGE_SZCZEPIONKA_EDIT = "szczepionkaEdit?faces-redirect=true";
	private static final String PAGE_SZCZEPIONKA_ADD = "szczepionkaAdd?faces-redirect=true";
	private static final String PAGE_SZCZEPIONKA_SHOW = "szczepionkaShow?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nazwa_szczepionki;
	private String idSzczepionka;
	
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	SzczepionkaDAO szczepionkaDAO;
	//SkierowanieDAO skierowanieDAO;
	
	public String getNazwa_szczepionki() {
		return nazwa_szczepionki;
	}

	public void setNazwa_szczepionki(String nazwa_szczepionki) {
		this.nazwa_szczepionki = nazwa_szczepionki;
	}
	
	public String getIdSzczepionka() {
		return idSzczepionka;
	}

	public void setIdSzczepionka(String idSzczepionka) {
		this.idSzczepionka = idSzczepionka;
	}

	public List<Szczepionka> getFullList(){
		return szczepionkaDAO.getFullList();
	}

	public List<Szczepionka> getList(){
		List<Szczepionka> list = null;
		
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwa_szczepionki != null && nazwa_szczepionki.length() > 0){
			searchParams.put("nazwa_szczepionki", nazwa_szczepionki);
		}
		
		list = szczepionkaDAO.getList(searchParams);
		
		return list;
	}

	public String newSzczepionka(){
		Szczepionka szczepionka = new Szczepionka();
		
		
		flash.put("szczepionka", szczepionka);
		
		return PAGE_SZCZEPIONKA_EDIT;
	}
	
	public String newZastrzyk(){
		Skierowanie skierowanie = new Skierowanie();
		
		
		flash.put("Skierowanie", skierowanie);
		
		return PAGE_SZCZEPIONKA_ADD;
	}
	
	public String showZastrzyk(){
		Skierowanie skierowanie = new Skierowanie();
		
		
		flash.put("Skierowanie", skierowanie);
		
		return PAGE_SZCZEPIONKA_SHOW;
	}

	public String editSzczepionka(Szczepionka szczepionka){
		
		flash.put("szczepionka", szczepionka);
		
		return PAGE_SZCZEPIONKA_EDIT;
	}

	public String deleteSzczepionka(Szczepionka szczepionka){
		szczepionkaDAO.remove(szczepionka);
		return PAGE_STAY_AT_THE_SAME;
	}


	
}
