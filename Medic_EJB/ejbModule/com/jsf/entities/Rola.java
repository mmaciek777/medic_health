package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRola;

	private String czy_rola_aktywna;

	@Temporal(TemporalType.DATE)
	private Date do_kiedy_rola_byla_aktywna;

	private String nazwa_roli;

	@Temporal(TemporalType.DATE)
	private Date od_kiedy_rola_funkcjonuje;

	//bi-directional many-to-one association to MaRole
	@OneToMany(mappedBy="rola")
	private List<MaRole> maRoles;

	public Rola() {
	}

	public Integer getIdRola() {
		return this.idRola;
	}

	public void setIdRola(Integer idRola) {
		this.idRola = idRola;
	}

	public String getCzy_rola_aktywna() {
		return this.czy_rola_aktywna;
	}

	public void setCzy_rola_aktywna(String czy_rola_aktywna) {
		this.czy_rola_aktywna = czy_rola_aktywna;
	}

	public Date getDo_kiedy_rola_byla_aktywna() {
		return this.do_kiedy_rola_byla_aktywna;
	}

	public void setDo_kiedy_rola_byla_aktywna(Date do_kiedy_rola_byla_aktywna) {
		this.do_kiedy_rola_byla_aktywna = do_kiedy_rola_byla_aktywna;
	}

	public String getNazwa_roli() {
		return this.nazwa_roli;
	}

	public void setNazwa_roli(String nazwa_roli) {
		this.nazwa_roli = nazwa_roli;
	}

	public Date getOd_kiedy_rola_funkcjonuje() {
		return this.od_kiedy_rola_funkcjonuje;
	}

	public void setOd_kiedy_rola_funkcjonuje(Date od_kiedy_rola_funkcjonuje) {
		this.od_kiedy_rola_funkcjonuje = od_kiedy_rola_funkcjonuje;
	}

	public List<MaRole> getMaRoles() {
		return this.maRoles;
	}

	public void setMaRoles(List<MaRole> maRoles) {
		this.maRoles = maRoles;
	}

	public MaRole addMaRole(MaRole maRole) {
		getMaRoles().add(maRole);
		maRole.setRola(this);

		return maRole;
	}

	public MaRole removeMaRole(MaRole maRole) {
		getMaRoles().remove(maRole);
		maRole.setRola(null);

		return maRole;
	}

}