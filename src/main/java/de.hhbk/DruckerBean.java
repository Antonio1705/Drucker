package de.hhbk;

import pojo.Drucker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "druckerBean")
@SessionScoped
public class DruckerBean implements Serializable
{
    //-------------------------------------------------------------------------
    //  Constructor(s)
    //-------------------------------------------------------------------------
    public DruckerBean() { }



    private Drucker drucker = new Drucker();
    List<Drucker> druckerList = new ArrayList();

    public Drucker getDrucker() {
        return this.drucker;
    }

    public void setDrucker(Drucker drucker) {
        this.drucker = drucker;
    }

    public List<Drucker> getDruckerList() { return druckerList; }

    public void setPersonList(List<Drucker> druckerList) {
        this.druckerList = druckerList;


    }

    public void resetDrucker() {
        Drucker newDrucker = new Drucker();
        this.drucker = newDrucker;
    }


    //-------------------------------------------------------------------------
    //  Method(s)
    //-------------------------------------------------------------------------
    public void addDrucker()
    {
        if (this.drucker.getId() <= 0)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Vorname fehlt"));
            return;
        }

        if (this.drucker.getModell()== null || this.drucker.getModell().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Modell-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.drucker.getStatus()== null || this.drucker.getStatus().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Status-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.drucker.getTechonologie()== null || this.drucker.getTechonologie().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Technologie-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.drucker.getPapierFormatMax()== null || this.drucker.getPapierFormatMax().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das MaxPapierformat-Feld darf nicht leer sein!!!"));
            return;
        }



        if (!druckerList.contains(drucker)) {

            druckerList.add(drucker);

        }
        System.out.println(druckerList.get(0));

        resetDrucker();

    }



    public void deleteDrucker(Drucker d) {
        druckerList.remove(d);
    }

}
