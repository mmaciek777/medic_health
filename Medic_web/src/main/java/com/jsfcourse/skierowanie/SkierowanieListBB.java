package com.jsfcourse.skierowanie;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.enterprise.context.RequestScoped;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.simplesecurity.RemoteClient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jsf.dao.SkierowanieDAO;
import com.jsf.dao.SzczepionkaDAO;
import com.jsf.dao.UserDAO;
import com.jsf.entities.Skierowanie;
import com.jsf.entities.Szczepionka;
import com.jsf.entities.User;

@Named
@RequestScoped
public class SkierowanieListBB {
	private static final String PAGE_SKIEROWANIE_ADD = "skierowanieAdd?faces-redirect=true";
	private static final String PAGE_SKIEROWANIE_SHOW = "skierowanieShow?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	@PersistenceContext
	EntityManager em;
	
	private String nazwa_szczepionki;
	private Integer idSkierowanie;
	private Date Termin_Dawka_Pierwsza;
	private Date Termin_Dawka_Druga;
	private Date Termin_Dawka_Trzecia;
	private Integer Pacjent;
	private String Imie;
	private String Tytu³;
	private Integer idUser;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	SkierowanieDAO SkierowanieDAO;
	UserDAO UserDao;
	
	public String getNazwa_szczepionki() {
		return nazwa_szczepionki;
	}

	public void setNazwa_szczepionki(String nazwa_szczepionki) {
		this.nazwa_szczepionki = nazwa_szczepionki;
	}
	
	
	public String getImie() {
		return Imie;
	}

	public void setImie(String imie) {
		this.Imie = imie;
	}

	public Integer getIdSkierowanie() {
		return idSkierowanie;
	}

	public void setIdSkierowanie(Integer idSkierowanie) {
		this.idSkierowanie = idSkierowanie;
	}
	
	public Date getTermin_Dawka_Pierwsza() {
		return Termin_Dawka_Pierwsza;
	}

	public void setTermin_Dawka_Pierwsza(Date termin_Dawka_Pierwsza) {
		Termin_Dawka_Pierwsza = termin_Dawka_Pierwsza;
	}
	
	public Date getTermin_Dawka_Druga() {
		return Termin_Dawka_Druga;
	}

	public void setTermin_Dawka_Druga(Date termin_Dawka_Druga) {
		Termin_Dawka_Druga = termin_Dawka_Druga;
	}
	
	public Date getTermin_Dawka_Trzecia() {
		return Termin_Dawka_Trzecia;
	}

	public void setTermin_Dawka_Trzecia(Date termin_Dawka_Trzecia) {
		Termin_Dawka_Trzecia = termin_Dawka_Trzecia;
	}
	
	public String getTytu³() {
		return Tytu³;
	}

	public void setTytu³(String tytu³) {
		this.Tytu³ = tytu³;
	}

	public Integer getPacjent() {
		return Pacjent;
	}

	public void setPacjent(Integer pacjent) {
		this.Pacjent = pacjent;
	}
	
	public List<Skierowanie> getFullList(){
		return SkierowanieDAO.getFullList();
	}
	
	public List<Skierowanie> getSkierowanieForUser(){
		HttpSession session = (HttpSession) extcontext.getSession(false);
		
		RemoteClient<User> client = RemoteClient.load(session);
		
		
		return SkierowanieDAO.getSkierowanieForUser(client.getDetails());
	}

	public List<Skierowanie> getList(){
		List<Skierowanie> list = null;
		
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		list = SkierowanieDAO.getList(searchParams);
		
		return list;
	}
	
	public String newZastrzyk(){
		
		return PAGE_SKIEROWANIE_ADD;
	}
	
	public String showZastrzyk(){
		
		return PAGE_SKIEROWANIE_SHOW;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	
	
	
}
