package com.example.mozimusor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadData {
    private String mozinev;
    private String filmcim;

    public ReadData(ResultSet rs) throws SQLException {
        this.mozinev = rs.getString("mozinev");
        this.filmcim = rs.getString("filmcim");
    }

    public String getMozinev() {
        return mozinev;
    }

    public void setMozinev(String mozinev) {
        this.mozinev = mozinev;
    }

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }
}
