package com.jsfcourse.szczepionka;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.jsf.dao.SzczepionkaDAO;
import com.jsf.entities.Szczepionka;

@Named
@ViewScoped
public class SzczepionkaEditBB implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String PAGE_SZCZEPIONKA_LIST = "szczepionkaList?faces-redirect=true";
	private static final String PAGE_STAY_AT_THE_SAME = null;

	private Szczepionka szczepionka = new Szczepionka();
	private Szczepionka loaded = null;

	@EJB
	SzczepionkaDAO szczepionkaDAO;

	@Inject
	FacesContext context;

	@Inject
	Flash flash;

	public Szczepionka getSzczepionka() {
		return szczepionka;
	}

	public void onLoad() throws IOException {
		
		loaded = (Szczepionka) flash.get("szczepionka");

		if (loaded != null) {
			szczepionka = loaded;
			
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Bledne uzycie systemu", null));
		
		}

	}

	public String saveData() {
        // no Person object passed
        if (loaded == null) {
            return PAGE_STAY_AT_THE_SAME;
        }

        try {
            if (szczepionka.getIdSzczepionka() == null) {
                // new record
            	szczepionkaDAO.create(szczepionka);
            } else {
                // existing record
            	szczepionkaDAO.merge(szczepionka);
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystapil blad podczas zapisu", null));
            return PAGE_STAY_AT_THE_SAME;
        }

        return PAGE_SZCZEPIONKA_LIST;
    }
}
