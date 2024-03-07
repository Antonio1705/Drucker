package pojo;

import org.jboss.weld.bean.builtin.RequestContextControllerBean;
import org.jboss.weld.context.RequestContext;
import org.jboss.weld.contexts.unbound.RequestContextImpl;

import javax.enterprise.context.control.RequestContextController;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

public class Raum {

    private int id;
    static int anzahl = 1;
    private String bezeichnung;
    private String typ;

    private List<Hardware> hardwareList = new ArrayList<>();

    public Raum( String bezeichnung, String typ) {
        this();
        this.bezeichnung = bezeichnung;
        this.typ = typ;
    }

    public int getId() {
        return id;
    }

    public Raum() {
        this.id = anzahl;
        anzahl+=1;

    }
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public List<Hardware> getHardwareList() {
        return hardwareList;
    }

    public List<Hardware> addHardware(Hardware hardware){
        System.out.println(FacesContext.getCurrentInstance().getELContext());
        this.hardwareList.add(hardware);
        hardware.setRaum(this);


        return this.hardwareList;
    }



    public void setHardwareList(List<Hardware> hardwareList) {
        this.hardwareList = hardwareList;
    }
}