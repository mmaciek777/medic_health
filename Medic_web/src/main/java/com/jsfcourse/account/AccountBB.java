/*
package com.jsfcourse.account;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jsf.dao.UserDAO;
import com.jsf.entities.Szczepionka;
import com.jsf.entities.User;

@Named
@ViewScoped
public class AccountBB implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String PAGE_ACCOUNT_LIST = "account?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	private static final String MAIN = "index?faces-redirect=true";
	private static final String EDIT = null;

	private User user = new User();
	private User loaded = null;

	@EJB
	UserDAO userDAO;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	public User getUser() {
		return user;
	}

	public void onLoad() throws IOException {
		
		loaded = (User) flash.get("user");

		if (loaded != null) {
			user = loaded;
		
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bledne uzycie systemu", null));
		
		}

	}
	

	public String saveData() {
       
        if (loaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
            if (user.getIdUser() == null) {
                
            	userDAO.create(user);
            } else {
                
            	userDAO.merge(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystapil blad podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_ACCOUNT_LIST;
    }
}
*/