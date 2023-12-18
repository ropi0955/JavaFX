package com.example.mozimusor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaData {
    Integer moziazon;
    String mozinev;
    Integer irszam;
    String cim;
    Integer telefon;

    public CinemaData() {
    }

    public CinemaData(ResultSet rs) throws SQLException {
        this.moziazon = rs.getInt("moziazon");
        this.mozinev = rs.getString("mozinev");
        this.cim = rs.getString("cim");
        this.irszam = rs.getInt("irszam");
        this.telefon = rs.getInt("telefon");
    }

    @Override
    public String toString() {
        return "CinemaData{" +
                "moziazon=" + moziazon +
                ", mozinev='" + mozinev + '\'' +
                ", irszam=" + irszam +
                ", cim='" + cim + '\'' +
                ", telefon=" + telefon +
                '}';
    }

    public String getMozinev() {
        return mozinev;
    }

    public void setMozinev(String mozinev) {
        this.mozinev = mozinev;
    }

    public Integer getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(Integer moziazon) {
        this.moziazon = moziazon;
    }

    public Integer getIrszam() {
        return irszam;
    }

    public void setIrszam(Integer irszam) {
        this.irszam = irszam;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public Integer getTelefon() {
        return telefon;
    }

    public void setTelefon(Integer telefon) {
        this.telefon = telefon;
    }
}
