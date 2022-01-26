package com.jsfcourse.admin;

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


import com.jsf.dao.UserDAO;
import com.jsf.entities.User;

@Named
@RequestScoped
public class AdminListBB {
	private static final String PAGE_USER_EDIT = "adminEdit?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private String imie;
	private String nazwisko;
	private String nazwa_roli;
	private String miasto_user;
	private String telefon;
	private String kod_Pocztowy_User;
	private String tytu³;
		
	@Inject
	ExternalContext extcontext;
	
	@Inject
	Flash flash;
	
	@EJB
	UserDAO userDAO;
		
	public String getImie() {
		return imie;
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
	
	public String getNazwa_roli() {
		return nazwa_roli;
	}

	public void setNazwa_roli(String nazwa_roli) {
		this.nazwa_roli = nazwa_roli;
	}
	
	public String getMiasto_user() {
		return miasto_user;
	}

	public void setMiasto_user(String miasto_user) {
		this.miasto_user = miasto_user;
	}
	
	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	public String getKod_Pocztowy_User() {
		return kod_Pocztowy_User;
	}

	public void setKod_Pocztowy_User(String kod_Pocztowy_User) {
		this.kod_Pocztowy_User = kod_Pocztowy_User;
	}
	
	public String getTytu³() {
		return tytu³;
	}

	public void setTytu³(String tytu³) {
		this.tytu³ = tytu³;
	}
	

	public List<User> getFullListAll(){
		return userDAO.getFullListAll();
	}
	
	public List<User> getListAll(){
		List<User> listAll = null;
		
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwisko != null && nazwisko.length() > 0){
			searchParams.put("nazwisko", nazwisko);
		}
		
		listAll = userDAO.getListAll(searchParams);
		
		return listAll;
	}
	
	
	
	
	public List<User> getFullList(){
		return userDAO.getFullList();
	}
	
	public List<User> getList(){
		List<User> list = null;
		
		Map<String,Object> searchParams = new HashMap<String, Object>();
		
		if (nazwisko != null && nazwisko.length() > 0){
			searchParams.put("nazwisko", nazwisko);
		}
		
		list = userDAO.getList(searchParams);
		
		return list;
	}

	
	
	
	public String editUser(User user){
		
		flash.put("user", user);
		
		return PAGE_USER_EDIT;
	}

	public String deleteUser(User user){
		userDAO.remove(user);
		return PAGE_STAY_AT_THE_SAME;
	}

	
}
