package com.jsfcourse.skierowanie;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsf.dao.SkierowanieDAO;
import com.jsf.dao.SzczepionkaDAO;
import com.jsf.dao.UserDAO;
import com.jsf.entities.Skierowanie;
import com.jsf.entities.Szczepionka;
import com.jsf.entities.User;

@Named
@ViewScoped
public class SkierowanieEditBB implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String PAGE_SKIEROWANIE_LIST = "skierowanieShow?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	
	private Skierowanie skierowanie = new Skierowanie();
	private Skierowanie loaded = null;
	
	private Integer idSzczepionka;
	private Integer idUser;	//lekarz
	private Integer idUser2;	//pacjent
	private String Termin_Dawka_Pierwsza;
	private String Termin_Dawka_Druga;
	private String Termin_Dawka_Trzecia;
	
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	public Integer getIdUser2() {
		return idUser2;
	}
	public void setIdUser2(Integer idUser2) {
		this.idUser2 = idUser2;
	}
	
	public Integer getIdSzczepionka() {
		return idSzczepionka;
	}
	public void setIdSzczepionka(Integer idSzczepionka) {
		this.idSzczepionka = idSzczepionka;
	}
	public String getTermin_Dawka_Pierwsza() {
		return Termin_Dawka_Pierwsza;
	}

	public void setTermin_Dawka_Pierwsza(String termin_Dawka_Pierwsza) {
		this.Termin_Dawka_Pierwsza = termin_Dawka_Pierwsza;
	}
	
	public String getTermin_Dawka_Druga() {
		return Termin_Dawka_Druga;
	}

	public void setTermin_Dawka_Druga(String termin_Dawka_Druga) {
		this.Termin_Dawka_Druga = termin_Dawka_Druga;
	}
	
	public String getTermin_Dawka_Trzecia() {
		return Termin_Dawka_Trzecia;
	}

	public void setTermin_Dawka_Trzecia(String termin_Dawka_Trzecia) {
		this.Termin_Dawka_Trzecia = termin_Dawka_Trzecia;
	}

	@EJB
	SkierowanieDAO skierowanieDAO;
	
	@EJB
	SzczepionkaDAO szczepionkaDAO;
	
	@EJB
	UserDAO userDAO;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;
	
	public Skierowanie getSkierowanie() {
		return skierowanie;
	}
	
	public void onLoad() throws IOException{
		
		loaded = (Skierowanie) flash.get("skierowanie");
		
		if(loaded != null) {
			skierowanie = loaded;
		}else {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"B³êdne u¿ycie systemu", null));
		}
		
	}

	public String saveData() {
     
				skierowanie.setUser2(userDAO.findUserPacjent(idUser2));
				skierowanie.setUser1(userDAO.findUser(idUser));
				skierowanie.setSzczepionka(szczepionkaDAO.findSzczepionka(idSzczepionka));
				skierowanie.setTermin_Dawka_Pierwsza(Termin_Dawka_Pierwsza);
				skierowanie.setTermin_Dawka_Druga(Termin_Dawka_Druga);
				skierowanie.setTermin_Dawka_Trzecia(Termin_Dawka_Trzecia);
       
            if (skierowanie.getIdSkierowanie() == null) {
            	
            	skierowanieDAO.create(skierowanie);
            	
            } else {
                
            	skierowanieDAO.merge(skierowanie);
            }
       

        return PAGE_SKIEROWANIE_LIST;
    }



}
