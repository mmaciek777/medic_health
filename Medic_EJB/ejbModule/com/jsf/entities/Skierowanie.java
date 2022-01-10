package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the skierowanie database table.
 * 
 */
@Entity
@NamedQuery(name="Skierowanie.findAll", query="SELECT s FROM Skierowanie s")
public class Skierowanie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSkierowanie;

	@Temporal(TemporalType.DATE)
	private Date termin_Dawka_Druga;

	@Temporal(TemporalType.DATE)
	private Date termin_Dawka_Pierwsza;

	@Temporal(TemporalType.DATE)
	private Date termin_Dawka_Trzecia;

	//bi-directional many-to-one association to Szczepionka
	@ManyToOne
	@JoinColumn(name="Szczepionka_id")
	private Szczepionka szczepionka;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Lekarz")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Pacjent")
	private User user2;

	public Skierowanie() {
	}

	public Integer getIdSkierowanie() {
		return this.idSkierowanie;
	}

	public void setIdSkierowanie(Integer idSkierowanie) {
		this.idSkierowanie = idSkierowanie;
	}

	public Date getTermin_Dawka_Druga() {
		return this.termin_Dawka_Druga;
	}

	public void setTermin_Dawka_Druga(Date termin_Dawka_Druga) {
		this.termin_Dawka_Druga = termin_Dawka_Druga;
	}

	public Date getTermin_Dawka_Pierwsza() {
		return this.termin_Dawka_Pierwsza;
	}

	public void setTermin_Dawka_Pierwsza(Date termin_Dawka_Pierwsza) {
		this.termin_Dawka_Pierwsza = termin_Dawka_Pierwsza;
	}

	public Date getTermin_Dawka_Trzecia() {
		return this.termin_Dawka_Trzecia;
	}

	public void setTermin_Dawka_Trzecia(Date termin_Dawka_Trzecia) {
		this.termin_Dawka_Trzecia = termin_Dawka_Trzecia;
	}

	public Szczepionka getSzczepionka() {
		return this.szczepionka;
	}

	public void setSzczepionka(Szczepionka szczepionka) {
		this.szczepionka = szczepionka;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}