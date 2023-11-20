package pojo;

import java.time.LocalDate;

public class Rechner extends Hardware{

    private String cpu;
    private int arbeitsspeicher;
    private String betribssysteme;
    private String typ;
    private String grafikKarte;
    private int festPlatteSSD;
    private int festPlatteHdd;



    public Rechner(){
        super();
    }

    public Rechner(String serienNummer, String modell, String hersteller, String status, int herstellerGarantie, LocalDate lieferDatum,
                   String cpu,int arbeitsspeicher,String betribssysteme, String typ,String grafikKarte,int festPlatteSSD,int festPlatteHdd){

        super(serienNummer,modell,hersteller,status,herstellerGarantie,lieferDatum);
        this.cpu = cpu;
        this.arbeitsspeicher = arbeitsspeicher;
        this.betribssysteme = betribssysteme;
        this.typ= typ;
        this.grafikKarte = grafikKarte;
        this.festPlatteSSD = festPlatteSSD;
        this.festPlatteHdd = festPlatteHdd;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getArbeitsspeicher() {
        return arbeitsspeicher;
    }

    public void setArbeitsspeicher(int arbeitsspeicher) {
        this.arbeitsspeicher = arbeitsspeicher;
    }

    public String getBetribssysteme() {
        return betribssysteme;
    }

    public void setBetribssysteme(String betribssysteme) {
        this.betribssysteme = betribssysteme;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getGrafikKarte() {
        return grafikKarte;
    }

    public void setGrafikKarte(String grafikKarte) {
        this.grafikKarte = grafikKarte;
    }

    public int getFestPlatteSSD() {
        return festPlatteSSD;
    }

    public void setFestPlatteSSD(int festPlatteSSD) {
        this.festPlatteSSD = festPlatteSSD;
    }

    public int getFestPlatteHdd() {
        return festPlatteHdd;
    }

    public void setFestPlatteHdd(int festPlatteHdd) {
        this.festPlatteHdd = festPlatteHdd;
    }

    @Override
    public String toString() {
        return super.toString()+"Rechner{" +
                "cpu='" + cpu + '\'' +
                ", arbeitsspeicher=" + arbeitsspeicher +
                ", betribssysteme='" + betribssysteme + '\'' +
                ", typ='" + typ + '\'' +
                ", grafikKarte='" + grafikKarte + '\'' +
                ", festPlatteSSD=" + festPlatteSSD +
                ", festPlatteHdd=" + festPlatteHdd +
                '}';
    }
}
