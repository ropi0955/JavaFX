package com.example.mozimusor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieData {
    private Integer fkod;
    private String filmcim;
    private Integer szines;
    private String szinkron;
    private String szarmazas;
    private Integer hossz;

    public MovieData() {
    }

    public MovieData(ResultSet rs) throws SQLException {
        this.fkod = rs.getInt("fkod");
        this.filmcim =  rs.getString("filmcim");
        this.szines =  rs.getInt("szines");
        this.szinkron =  rs.getString("szinkron");
        this.szarmazas =  rs.getString("szarmazas");
        this.hossz =  rs.getInt("hossz");
    }

    @Override
    public String toString() {
        return "MovieData{" +
                "fkod=" + fkod +
                ", filmcim='" + filmcim + '\'' +
                ", szines=" + szines +
                ", szinkron='" + szinkron + '\'' +
                ", szarmazas='" + szarmazas + '\'' +
                ", hossz=" + hossz +
                '}';
    }

    public Integer getFkod() {
        return fkod;
    }

    public void setFkod(Integer fkod) {
        this.fkod = fkod;
    }

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }

    public Integer getSzines() {
        return szines;
    }

    public void setSzines(Integer szines) {
        this.szines = szines;
    }

    public String getSzinkron() {
        return szinkron;
    }

    public void setSzinkron(String szinkron) {
        this.szinkron = szinkron;
    }

    public String getSzarmazas() {
        return szarmazas;
    }

    public void setSzarmazas(String szarmazas) {
        this.szarmazas = szarmazas;
    }

    public Integer getHossz() {
        return hossz;
    }

    public void setHossz(Integer hossz) {
        this.hossz = hossz;
    }
}
