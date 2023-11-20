package de.hhbk;

import pojo.Rechner;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value="rechnerBean")
@SessionScoped
public class RechnerBean implements Serializable {

    public RechnerBean(){

    }

    Rechner rechner = new Rechner();

    List<Rechner> rechnerList = new ArrayList<>();


    public Rechner getRechner() {
        return rechner;
    }

    public void setRechner(Rechner rechner) {
        this.rechner = rechner;
    }

    public List<Rechner> getRechnerList() {
        return rechnerList;
    }

    public void setRechnerList(List<Rechner> rechnerList) {
        this.rechnerList = rechnerList;
    }



    public void resetRechner(){
        Rechner newRechner = new Rechner();
        this.rechner = newRechner;
    }

    public void deleteRechner(Rechner rechner){
        rechnerList.remove(rechner);
    }

    public void addRechner(){
        if (this.rechner.getId() <= 0)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Vorname fehlt"));
            return;
        }

        if (this.rechner.getModell()== null || this.rechner.getModell().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Modell-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.rechner.getStatus()== null || this.rechner.getStatus().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Status-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.rechner.getCpu()== null || this.rechner.getCpu().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Technologie-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.rechner.getBetribssysteme()== null || this.rechner.getBetribssysteme().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das MaxPapierformat-Feld darf nicht leer sein!!!"));
            return;
        }

        if (!rechnerList.contains(rechner)){
            rechnerList.add(rechner);
        }

        System.out.println(rechnerList.get(0));

        resetRechner();

    }

}
