package pojo;

import java.time.LocalDate;

public class Hardware {

    private static int anzahl = 1;
    private int id;
    private String serienNummer;
    private String modell;
    private String  hersteller;
    private String status = "OK";
    private int herstellerGarantie;
    private LocalDate lieferDatum;

    public Hardware(String serienNummer, String modell, String hersteller, String status, int herstellerGarantie, LocalDate lieferDatum) {
        this();
        this.serienNummer = serienNummer;
        this.modell = modell;
        this.hersteller = hersteller;
        this.status = status;
        this.herstellerGarantie = herstellerGarantie;
        this.lieferDatum = lieferDatum;
    }

    public Hardware(){
        this.id = anzahl;
        anzahl +=1;
    }

    public static int getAnzahl() {
        return anzahl;
    }

    public static void setAnzahl(int anzahl) {
        Hardware.anzahl = anzahl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerienNummer() {
        return serienNummer;
    }

    public void setSerienNummer(String serienNummer) {
        this.serienNummer = serienNummer;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHerstellerGarantie() {
        return herstellerGarantie;
    }

    public void setHerstellerGarantie(int herstellerGarantie) {
        this.herstellerGarantie = herstellerGarantie;
    }

    public LocalDate getLieferDatum() {
        return lieferDatum;
    }

    public void setLieferDatum(LocalDate lieferDatum) {
        this.lieferDatum = lieferDatum;
    }


    @Override
    public String toString() {
        return "Gereat{" +
                "id=" + id +
                ", serienNummer='" + serienNummer + '\'' +
                ", modell='" + modell + '\'' +
                ", hersteller='" + hersteller + '\'' +
                ", status='" + status + '\'' +
                ", herstellerGarantie=" + herstellerGarantie +
                ", lieferDatum=" + lieferDatum +
                '}';
    }
}
