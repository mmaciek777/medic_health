package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;

	@Temporal(TemporalType.DATE)
	private Date data_ostatniej_edycji;

	@Temporal(TemporalType.DATE)
	private Date data_rejestracji;

	@Temporal(TemporalType.DATE)
	private Date do_Kiedy_rola_aktywna;

	@Column(name="`E-mail`")
	private String e_mail;

	private String has³o;

	private String imie;

	private String kod_Pocztowy_User;

	private String login;

	private String miasto_User;

	private String nazwa_roli;

	private String nazwisko;

	private Integer nr_budynku_User;

	private String nr_CRL;

	@Temporal(TemporalType.DATE)
	private Date od_Kiedy_rola_funkcjonuje;

	private String pesel;

	private Integer telefon;

	private String tytu³;

	private String ulica_User;

	//bi-directional many-to-one association to Skierowanie
	@OneToMany(mappedBy="user1")
	private List<Skierowanie> skierowanies1;

	//bi-directional many-to-one association to Skierowanie
	@OneToMany(mappedBy="user2")
	private List<Skierowanie> skierowanies2;

	public User() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getData_ostatniej_edycji() {
		return this.data_ostatniej_edycji;
	}

	public void setData_ostatniej_edycji(Date data_ostatniej_edycji) {
		this.data_ostatniej_edycji = data_ostatniej_edycji;
	}

	public Date getData_rejestracji() {
		return this.data_rejestracji;
	}

	public void setData_rejestracji(Date data_rejestracji) {
		this.data_rejestracji = data_rejestracji;
	}

	public Date getDo_Kiedy_rola_aktywna() {
		return this.do_Kiedy_rola_aktywna;
	}

	public void setDo_Kiedy_rola_aktywna(Date do_Kiedy_rola_aktywna) {
		this.do_Kiedy_rola_aktywna = do_Kiedy_rola_aktywna;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getHas³o() {
		return this.has³o;
	}

	public void setHas³o(String has³o) {
		this.has³o = has³o;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getKod_Pocztowy_User() {
		return this.kod_Pocztowy_User;
	}

	public void setKod_Pocztowy_User(String kod_Pocztowy_User) {
		this.kod_Pocztowy_User = kod_Pocztowy_User;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMiasto_User() {
		return this.miasto_User;
	}

	public void setMiasto_User(String miasto_User) {
		this.miasto_User = miasto_User;
	}

	public String getNazwa_roli() {
		return this.nazwa_roli;
	}

	public void setNazwa_roli(String nazwa_roli) {
		this.nazwa_roli = nazwa_roli;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public Integer getNr_budynku_User() {
		return this.nr_budynku_User;
	}

	public void setNr_budynku_User(int nr_budynku_User) {
		this.nr_budynku_User = nr_budynku_User;
	}

	public String getNr_CRL() {
		return this.nr_CRL;
	}

	public void setNr_CRL(String nr_CRL) {
		this.nr_CRL = nr_CRL;
	}

	public Date getOd_Kiedy_rola_funkcjonuje() {
		return this.od_Kiedy_rola_funkcjonuje;
	}

	public void setOd_Kiedy_rola_funkcjonuje(Date od_Kiedy_rola_funkcjonuje) {
		this.od_Kiedy_rola_funkcjonuje = od_Kiedy_rola_funkcjonuje;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public Integer getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getTytu³() {
		return this.tytu³;
	}

	public void setTytu³(String tytu³) {
		this.tytu³ = tytu³;
	}

	public String getUlica_User() {
		return this.ulica_User;
	}

	public void setUlica_User(String ulica_User) {
		this.ulica_User = ulica_User;
	}

	public List<Skierowanie> getSkierowanies1() {
		return this.skierowanies1;
	}

	public void setSkierowanies1(List<Skierowanie> skierowanies1) {
		this.skierowanies1 = skierowanies1;
	}

	public Skierowanie addSkierowanies1(Skierowanie skierowanies1) {
		getSkierowanies1().add(skierowanies1);
		skierowanies1.setUser1(this);

		return skierowanies1;
	}

	public Skierowanie removeSkierowanies1(Skierowanie skierowanies1) {
		getSkierowanies1().remove(skierowanies1);
		skierowanies1.setUser1(null);

		return skierowanies1;
	}

	public List<Skierowanie> getSkierowanies2() {
		return this.skierowanies2;
	}

	public void setSkierowanies2(List<Skierowanie> skierowanies2) {
		this.skierowanies2 = skierowanies2;
	}

	public Skierowanie addSkierowanies2(Skierowanie skierowanies2) {
		getSkierowanies2().add(skierowanies2);
		skierowanies2.setUser2(this);

		return skierowanies2;
	}

	public Skierowanie removeSkierowanies2(Skierowanie skierowanies2) {
		getSkierowanies2().remove(skierowanies2);
		skierowanies2.setUser2(null);

		return skierowanies2;
	}


}