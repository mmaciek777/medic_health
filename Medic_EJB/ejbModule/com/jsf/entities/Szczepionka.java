package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the szczepionka database table.
 * 
 */
@Entity
@NamedQuery(name="Szczepionka.findAll", query="SELECT s FROM Szczepionka s")
public class Szczepionka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Szczepionka;

	private String nazwa_szczepionki;

	//bi-directional many-to-one association to Skierowanie
	@OneToMany(mappedBy="szczepionka")
	private List<Skierowanie> skierowanies;

	public Szczepionka() {
	}

	public int getId_Szczepionka() {
		return this.id_Szczepionka;
	}

	public void setId_Szczepionka(int id_Szczepionka) {
		this.id_Szczepionka = id_Szczepionka;
	}

	public String getNazwa_szczepionki() {
		return this.nazwa_szczepionki;
	}

	public void setNazwa_szczepionki(String nazwa_szczepionki) {
		this.nazwa_szczepionki = nazwa_szczepionki;
	}

	public List<Skierowanie> getSkierowanies() {
		return this.skierowanies;
	}

	public void setSkierowanies(List<Skierowanie> skierowanies) {
		this.skierowanies = skierowanies;
	}

	public Skierowanie addSkierowany(Skierowanie skierowany) {
		getSkierowanies().add(skierowany);
		skierowany.setSzczepionka(this);

		return skierowany;
	}

	public Skierowanie removeSkierowany(Skierowanie skierowany) {
		getSkierowanies().remove(skierowany);
		skierowany.setSzczepionka(null);

		return skierowany;
	}

}