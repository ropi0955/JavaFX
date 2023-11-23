package com.example.javafx_beadando;


public class Database {
    private String filmcim;
    private String szarmazas;
    private String mufaj;
    private String mozinev;
    private String cim;

    public String getSzinkron() {
        return szinkron;
    }

    public void setSzinkron(String szinkron) {
        this.szinkron = szinkron;
    }

    private String szinkron;

    public boolean isSzines() {
        return szines;
    }

    public void setSzines(boolean szines) {
        this.szines = szines;
    }

    private boolean szines;


    public Database() {
    }

    public Database(String filmcim, String szarmazas, String mufaj, String mozinev, String cim,String szinkron,boolean szines) {
        this.filmcim = filmcim;
        this.szarmazas = szarmazas;
        this.mufaj = mufaj;
        this.mozinev = mozinev;
        this.cim = cim;
        this.szinkron=szinkron;
        this.szines=szines;
    }

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }

    public String getSzarmazas() {
        return szarmazas;
    }

    public void setSzarmazas(String szarmazas) {
        this.szarmazas = szarmazas;
    }

    public String getMufaj() {
        return mufaj;
    }

    public void setMufaj(String mufaj) {
        this.mufaj = mufaj;
    }

    public String getMozinev() {
        return mozinev;
    }

    public void setMozinev(String mozinev) {
        this.mozinev = mozinev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    @Override
    public String toString() {
        return filmcim+","+szarmazas+","+ mufaj+","+ mozinev+","+ cim+","+ szinkron+","+ szines;
    }
}
