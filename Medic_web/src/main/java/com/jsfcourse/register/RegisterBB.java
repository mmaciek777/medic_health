package com.jsfcourse.register;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.simplesecurity.RemoteClient;
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
	

	private String login;
	private String has³o;
	private Date Data_ostatniej_edycji;
	private Date Data_rejestracji;
	private String E_mail;
	private String Imie;
	private String Nazwisko;
	private String Ulica;
	private Integer Nr_budynku_User;
	private String Kod_Pocztowy_User;
	private String Miasto_User;
	private String Nr_CRL;
	private String PESEL;
	private Integer Telefon;
	private String Tytu³;
	private String Ulica_user;
	private Integer kto_utworzyl;
	private Integer kto_zmodyfikowal;
	private String Nazwa_roli;

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

	public String getHas³o() {
		return this.has³o;
	}

	public void setHas³o(String has³o) {
		this.has³o = has³o;
	}

	public String getImie() {
		return this.Imie;
	}

	public void setImie(String imie) {
		this.Imie = imie;
	}

	public String getKod_Pocztowy_User() {
		return this.getKod_Pocztowy_User();
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMiasto_User() {
		return this.Miasto_User;
	}

	public void setMiasto_User(String miasto_User) {
		this.Miasto_User = miasto_User;
	}

	public String getNazwisko() {
		return this.Nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.Nazwisko = nazwisko;
	}

	public int getNr_budynku_User() {
		return this.Nr_budynku_User;
	}

	public void setNr_budynku_User(int nr_budynku_User) {
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

	public int getTelefon() {
		return this.Telefon;
	}

	public void setTelefon(int telefon) {
		this.Telefon = telefon;
	}

	public String getTytu³() {
		return this.Tytu³;
	}

	public void setTytu³(String tytu³) {
		this.Tytu³ = tytu³;
	}

	public String getUlica_User() {
		return this.Ulica_user;
	}

	public void setUlica_User(String ulica_User) {
		this.Ulica_user = ulica_User;
	}

	public String getNazwa_roli() {
		return Nazwa_roli;
	}

	public void setNazwa_roli(String nazwa_roli) {
		this.Nazwa_roli = nazwa_roli;
	}
	
	@EJB
	UserDAO UserDAO;

	public String goRegister() {
		
		return PAGE_REGISTER;
	}
	
	public String doRegister() {
		return PAGE_MAIN;
	}

	
	
}
