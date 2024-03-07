package pojo;

import de.hhbk.RaumBean;


import javax.inject.Inject;

import javax.swing.*;
import java.time.LocalDate;

public class Drucker extends Hardware {

    @Inject
    RaumBean raumBean;

    private String  techonologie;
    private boolean farbdruckFunktion;
    private String papierFormatMax;
    private int druckerSeitenGesamt;
    private int restKapazitaet = 200;
    private int kapazitetBetriebsMittel = 200;




    public Drucker(String serienNummer, String modell, String hersteller, String status, int herstellerGarantie,
                   LocalDate lieferDatum, String techonologie, boolean farbdruckFunktion, String papierFormatMax)
    {
        super(serienNummer,modell,hersteller,status,herstellerGarantie,lieferDatum);

        this.techonologie = techonologie;
        this.farbdruckFunktion = farbdruckFunktion;
        this.papierFormatMax = papierFormatMax;

    }

    public Drucker(){
        super();
    }






    public void wechselBetriebesmittelnd(int newKapazitaet){

        if (newKapazitaet <= 0){
            JOptionPane.showMessageDialog(null,"Kapazitöt muss  größer 0 sein!","Warnung", JOptionPane.WARNING_MESSAGE);
        }else {
            this.kapazitetBetriebsMittel += newKapazitaet;
            this.restKapazitaet += newKapazitaet;
        }
    }



    public String getTechonologie() {
        return techonologie;
    }

    public void setTechonologie(String techonologie) {
        this.techonologie = techonologie;
    }

    public boolean isFarbdruckFunktion() {
        return farbdruckFunktion;
    }

    public void setFarbdruckFunktion(boolean farbdruckFunktion) {
        this.farbdruckFunktion = farbdruckFunktion;
    }

    public String getPapierFormatMax() {
        return papierFormatMax;
    }

    public void setPapierFormatMax(String papierFormatMax) {
        this.papierFormatMax = papierFormatMax;
    }

    public int getDruckerSeitenGesamt() {
        return druckerSeitenGesamt;
    }

    public void setDruckerSeitenGesamt(int druckerSeitenGesamt) {
        this.druckerSeitenGesamt = druckerSeitenGesamt;
    }

    public int getRestKapazitaet() {
        return restKapazitaet;
    }

    public void setRestKapazitaet(int restKapazitaet) {
        this.restKapazitaet = restKapazitaet;
    }

    public int getKapazitetBetriebsMittel() {
        return kapazitetBetriebsMittel;
    }

    public void setKapazitetBetriebsMittel(int kapazitetBetriebsMittel) {
        this.kapazitetBetriebsMittel = kapazitetBetriebsMittel;
    }



    public LocalDate berechneGarantieEnde(){
        JOptionPane.showMessageDialog(null,"Lieferdatum: "+super.getLieferDatum() + "\nGerantieende:"+super.getLieferDatum().plusMonths(super.getHerstellerGarantie()));
        return super.getLieferDatum().plusMonths(super.getHerstellerGarantie());
    }

    public void drucken(int anzahlSeiten){
        if (anzahlSeiten <=0){
            JOptionPane.showMessageDialog(null,"Anzahl an seiten muss  größer 0 sein!","Warnung", JOptionPane.WARNING_MESSAGE);
        }else {
            if (anzahlSeiten > 0 && restKapazitaet >= anzahlSeiten){
                druckerSeitenGesamt += anzahlSeiten;
                restKapazitaet -= anzahlSeiten;

                JOptionPane.showMessageDialog(null,anzahlSeiten+" Seiten erfolgreich gedruckt");
            }else {
                anzahlSeiten -= restKapazitaet;
                druckerSeitenGesamt += restKapazitaet;
                kapazitetBetriebsMittel = 0;

                JOptionPane.showMessageDialog(null,"Es könnten nur "+ restKapazitaet+ " Seiten gedrückt werden!\n Bitte wechseln Sie das Betreibsmittel","Warnung", JOptionPane.WARNING_MESSAGE);
                restKapazitaet = 0;
            }
        }

    }



    @Override
    public String toString() {
        return "Drucker{" +
                "id=" + super.getId() +
                ", serienNummer='" + super.getSerienNummer() + '\'' +
                ", modell='" + super.getModell() + '\'' +
                ", hersteller='" + super.getHersteller() + '\'' +
                ", status='" + super.getStatus() + '\'' +
                ", herstellerGarantie=" + super.getHerstellerGarantie()+
                ", lieferDatum=" + super.getLieferDatum() +
                ", techonologie='" + techonologie + '\'' +
                ", farbdruckFunktion=" + farbdruckFunktion +
                ", papierFormatMax='" + papierFormatMax + '\'' +
                ", druckerSeitenGesamt=" + druckerSeitenGesamt +
                ", restKapazitaet=" + restKapazitaet +
                ", kapazitetBetriebsMittel=" + kapazitetBetriebsMittel +
                '}';
    }


}
