package de.hhbk;

import jdk.jfr.Name;
import pojo.Hardware;
import pojo.Raum;
import pojo.Rechner;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named(value = "raumBean")
@SessionScoped
public class RaumBean implements Serializable {

    private Raum raum = new Raum();

    private List<Raum> raumList;




    public RaumBean(){
        raumList = new ArrayList<>();
        raumList.add(new Raum("A123","IT Fachraum"));
        raumList.add(new Raum("A124","Klassenraum"));
        raumList.add(new Raum("A125","ET Fachraum"));
        raumList.add(new Raum("A126","CH Labor"));
        raumList.add(new Raum("A127","Serviceraum"));
        raumList.add(new Raum("A128","Lehrervorbereitungsraum"));
        raumList.add(new Raum("A129","Büro"));
        raumList.add(new Raum("A130","Sonstiges"));

    }

    public Raum getRaum() {
        return raum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    public List<Raum> getRaumList() {
        return raumList;
    }

    public void setRaumList(List<Raum> raumList) {
        this.raumList = raumList;
    }

    public void resetRaum(){
        this.raum = new Raum();
    }

    public void deleteRaum(Raum raum){
        this.raumList.remove(raum);
    }


    public void addRaum(){

        if (this.raum.getBezeichnung()== null || this.raum.getBezeichnung().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Modell-Feld darf nicht leer sein!!!"));
            return;
        }

        if (this.raum.getTyp()== null || this.raum.getTyp().isBlank()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Das Status-Feld darf nicht leer sein!!!"));
            return;
        }

        if (!raumList.contains(raum)){
            raumList.add(raum);
        }

        resetRaum();
    }
}
