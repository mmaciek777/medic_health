package com.jsfcourse.register;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.simplesecurity.RemoteClient;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jsf.dao.UserDAO;
import com.jsf.entities.User;

@Named
@RequestScoped
public class RegisterBB {
	private static final String PAGE_MAIN = "/public/index?faces-redirect=true";
	private static final String PAGE_REGISTER = "/pages/register";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	
	
	private String Login;
	private String Has³o;
	private String Imie;
	private String Nazwisko;
	private String Nazwa_roli;
	private String Nr_budynku_User;
	private Date Data_ostatniej_edycji;
	private Date Data_rejestracji;
	private String E_mail;
	private String Kod_Pocztowy_User;
	private String Miasto_User;
	private String Nr_CRL;
	private String PESEL;
	private String Telefon;
	private String Tytu³;
	private String Ulica_User;
	private Integer kto_utworzyl;
	private Integer kto_zmodyfikowal;
	private Date Od_Kiedy_rola_funkcjonuje;
	private Date Do_Kiedy_rola_aktywna;

	
	public Date getData_ostatniej_edycji() {
		return this.Data_ostatniej_edycji;
	}

	public void setData_ostatniej_edycji(Date data_ostatniej_edycji) {
		this.Data_ostatniej_edycji = data_ostatniej_edycji;
	}

	public Date getData_rejestracji() {
		return this.Data_rejestracji;
	}

	public void setData_rejestracji(Date data_rejestracji) {
		this.Data_rejestracji = data_rejestracji;
	}

	public String getE_mail() {
		return this.E_mail;
	}
	
	public void setE_mail(String e_mail) {
		this.E_mail = e_mail;
	}

	public String getNazwisko() {
		return this.Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.Nazwisko = nazwisko;
	}

	public String getLogin() {
		return this.Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}

	public String getHas³o() {
		return this.Has³o;
	}

	public void setHas³o(String Has³o) {
		this.Has³o = Has³o;
	}

	public String getImie() {
		return this.Imie;
	}

	public void setImie(String imie) {
		this.Imie = imie;
	}
	public String getNazwa_roli() {
		return Nazwa_roli;
	}

	public void setNazwa_roli(String nazwa_roli) {
		this.Nazwa_roli = nazwa_roli;
	}

	public String getKod_Pocztowy_User() {
		return Kod_Pocztowy_User;
	}

	public void setKod_Pocztowy_User(String kod_Pocztowy_User) {
		this.Kod_Pocztowy_User = kod_Pocztowy_User;
		 
	}
	public Integer getKto_utworzyl() {
		return this.kto_utworzyl;
	}

	public void setKto_utworzyl(int kto_utworzyl) {
		this.kto_utworzyl = kto_utworzyl;
	}

	public int getKto_zmodyfikowal() {
		return this.kto_zmodyfikowal;
	}

	public void setKto_zmodyfikowal(int kto_zmodyfikowal) {
		this.kto_zmodyfikowal = kto_zmodyfikowal;
	}

	
	public String getMiasto_User() {
		return this.Miasto_User;
	}

	public void setMiasto_User(String miasto_User) {
		this.Miasto_User = miasto_User;
	}

	
	public String getNr_budynku_User() {
		return Nr_budynku_User;
	}

	public void setNr_budynku_User(String nr_budynku_User) {
		this.Nr_budynku_User = nr_budynku_User;
	}

	public String getNr_CRL() {
		return this.Nr_CRL;
	}

	public void setNr_CRL(String nr_CRL) {
		this.Nr_CRL = nr_CRL;
	}

	public String getPesel() {
		return this.PESEL;
	}

	public void setPesel(String pesel) {
		this.PESEL = pesel;
	}

	public String getTelefon() {
		return this.Telefon;
	}

	public void setTelefon(String telefon) {
		this.Telefon = telefon;
	}

	public String getTytu³() {
		return this.Tytu³;
	}

	public void setTytu³(String tytu³) {
		this.Tytu³ = tytu³;
	}
	
	public String getUlica_User() {
		return Ulica_User;
	}

	public void setUlica_User(String ulica_User) {
		this.Ulica_User = ulica_User;
	}
	
	
	public Date getOd_Kiedy_rola_funkcjonuje() {
		return Od_Kiedy_rola_funkcjonuje;
	}

	public void setOd_Kiedy_rola_funkcjonuje(Date Od_Kiedy_rola_funkcjonuje) {
		this.Od_Kiedy_rola_funkcjonuje = Od_Kiedy_rola_funkcjonuje;
	}
	
	public Date getDo_Kiedy_rola_aktywna() {
		return Do_Kiedy_rola_aktywna;
	}

	public void setDo_Kiedy_rola_aktywna(Date Do_Kiedy_rola_aktywna) {
		this.Do_Kiedy_rola_aktywna = Do_Kiedy_rola_aktywna;
	}

	@Inject
	FacesContext context;
	
	@Inject
	Flash flash;
	
	@EJB
	UserDAO userDAO;
	
	private User user = new User();
	
	public User getUser() {
		return user;
	}
	
	public String saveData() {

        try {
            if (user.getIdUser() == null) {
                
            	userDAO.create(user);
            	
            } else {
                
            	userDAO.merge(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wyst¹pi³ b³¹d podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_MAIN;
    }

	
	
}
