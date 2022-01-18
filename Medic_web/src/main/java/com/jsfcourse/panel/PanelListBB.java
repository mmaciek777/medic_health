package com.jsfcourse.panel;

import java.util.Date;
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
import com.jsf.dao.UserDAO;
import com.jsf.dao.SkierowanieDAO;

import com.jsf.entities.Szczepionka;
import com.jsf.entities.User;
import com.jsf.entities.Skierowanie;

@Named
@RequestScoped
public class PanelListBB {
	private static final String PAGE_PANEL_EDIT = "panelEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String nazwa_szczepionki;
	private String imie;
	private String nazwisko;
	private Date Termin_Dawka_Pierwsza;
	private Date Termin_Dawka_Druga;
	private Date Termin_Dawka_Trzecia;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	SzczepionkaDAO szczepionkaDAO;
	UserDAO userDAO;
	SkierowanieDAO skierowanieDAO;
		
	public String getNazwa_szczepionki() {
		return nazwa_szczepionki;
	}

	public void setNazwa_szczepionki(String nazwa_szczepionki) {
		this.nazwa_szczepionki = nazwa_szczepionki;
	}
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Date getTermin_Dawka_Druga() {
		return this.Termin_Dawka_Druga;
	}

	public void setTermin_Dawka_Druga(Date Termin_Dawka_Druga) {
		this.Termin_Dawka_Druga = Termin_Dawka_Druga;
	}

	public Date getTermin_Dawka_Pierwsza() {
		return this.Termin_Dawka_Pierwsza;
	}

	public void setTermin_Dawka_Pierwsza(Date Termin_Dawka_Pierwsza) {
		this.Termin_Dawka_Pierwsza = Termin_Dawka_Pierwsza;
	}

	public Date getTermin_Dawka_Trzecia() {
		return this.Termin_Dawka_Trzecia;
	}

	public void setTermin_Dawka_Trzecia(Date Termin_Dawka_Trzecia) {
		this.Termin_Dawka_Trzecia = Termin_Dawka_Trzecia;
	}

	
	
	
	public List<Skierowanie> getFullList(){
		return skierowanieDAO.getFullList();
	}

	public List<Skierowanie> getList(){
		List<Skierowanie> list = null;
		
		//1. Prepare search params
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwisko != null && nazwisko.length() > 0){
			searchParams.put("nazwisko", nazwisko);
		}
		
		//2. Get list
		list = skierowanieDAO.getList(searchParams);
		
		return list;
	}
/*
	public String newSzczepionka(){
		Szczepionka szczepionka = new Szczepionka();
		
		
		flash.put("szczepionka", szczepionka);
		
		return PAGE_PANEL_EDIT;
	}
*/
	public String editPanel(Skierowanie skierowanie){
		
		
		flash.put("nazwisko", nazwisko);
		
		return PAGE_PANEL_EDIT;
	}
	/*
	public String deleteSzczepionka(Szczepionka szczepionka){
		szczepionkaDAO.remove(szczepionka);
		return PAGE_STAY_AT_THE_SAME;
	}
	*/
}
