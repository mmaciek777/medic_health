package com.jsfcourse.login;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.spi.Context;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.simplesecurity.RemoteClient;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

import com.jsf.dao.UserDAO;
import com.jsf.entities.User;

@Named
@RequestScoped
public class LoginBB {
	private static final String PAGE_MAIN = "/public/index?faces-redirect=true";
	private static final String PAGE_LOGIN = "/public/index?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;
	
	
	@Size(min=6,max=45)
	private String login;
	
	@Size(min=6,max=45)
	private String has�o;
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHas�o() {
		return this.has�o;
	}

	public void setHas�o(String has�o) {
		this.has�o = has�o;
	}

	@EJB
	UserDAO UserDAO;
	
	public String doLogin() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        User user = UserDAO.getUserFromDatabase(login, has�o);

        if (user == null) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Niepoprawny login lub has�o", null));
            return PAGE_STAY_AT_THE_SAME;
        }
        
        RemoteClient<User> client = new RemoteClient<User>(); 
        client.getRoles().add(user.getNazwa_roli());
        client.setDetails(user);
        
        HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
        client.store(request);
        return PAGE_MAIN;
    }
	
	
	public String doLogout(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();
		return PAGE_LOGIN;
	}
	
	
	
}
