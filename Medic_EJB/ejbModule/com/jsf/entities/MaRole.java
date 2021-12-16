package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ma_role database table.
 * 
 */
@Entity
@Table(name="ma_role")
@NamedQuery(name="MaRole.findAll", query="SELECT m FROM MaRole m")
public class MaRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaRole;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	private Rola rola;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_id_User")
	private User user;

	public MaRole() {
	}

	public int getIdMaRole() {
		return this.idMaRole;
	}

	public void setIdMaRole(int idMaRole) {
		this.idMaRole = idMaRole;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}