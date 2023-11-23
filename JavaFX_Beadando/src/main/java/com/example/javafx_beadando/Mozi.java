package com.example.javafx_beadando;

public class Mozi {

    private int moziazon;
    private String mozinev;
    private int irszam;
    private String cim;
    private String telefon;

    public int getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(int moziazon) {
        this.moziazon = moziazon;
    }

    public String getMozinev() {
        return mozinev;
    }

    public void setMozinev(String mozinev) {
        this.mozinev = mozinev;
    }

    public int getIrszam() {
        return irszam;
    }

    public void setIrszam(int irszam) {
        this.irszam = irszam;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    public Mozi(int moziazon, String mozinev, int irszam, String cim, String telefon) {
        this.moziazon = moziazon;
        this.mozinev = mozinev;
        this.irszam = irszam;
        this.cim = cim;
        this.telefon = telefon;
    }
}
