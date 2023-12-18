package com.example.mozimusor;
import java.sql.*;
import java.util.ArrayList;

public class DbConnector {
    private Connection conn;

    public DbConnector() {connect();}

    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite::resource:adatbazis.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private String generateSqlString(String title, String cinema, Boolean colored, String genre) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        sb.append("select film.filmcim, mozi.mozinev from film inner join hely on film.fkod = hely.fkod inner join mozi on hely.moziazon = mozi.moziazon ");
        if (title != null || cinema != null || colored != null || genre != null) {sb.append("where ");}
        if (title != null && !title.isBlank()) {
            sb.append("film.filmcim = '").append(title).append("'");
            first = false;
        }
        if (cinema != null && !cinema.isBlank()) {
            if (!first) {
                sb.append(" AND ");
            }
            sb.append("mozi.mozinev = '").append(cinema).append("'");
            first = false;
        }
        if (colored != null) {
            if (!first) {
                sb.append(" AND ");
            }
            sb.append("film.szines = ").append(colored ? "0" : "-1");
            first = false;
        }
        if (genre != null && !genre.isBlank()) {
            if (!first) {
                sb.append(" AND ");
            }
            sb.append("film.mufaj = '").append(genre).append("'");
            first = false;
        }

        System.out.println("Generated sql script:");
        System.out.println(sb.toString());

        return sb.toString();
    }

    public ArrayList<ReadData> getReadDataFromDb(String title, String cinema, Boolean colored, String genre) {
        ArrayList<ReadData> res = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(generateSqlString(title,cinema,colored,genre));
            res = new ArrayList<>();
            while(rs.next()) {
                res.add(new ReadData(rs));
            }

        } catch (SQLException ex) {
            System.out.println("failed to create Statement in getReadDataFromDb");
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return res;
    }

    public ArrayList<CinemaData> getAllUniqueCinema() {
        Statement stmt = null;
        ArrayList<CinemaData> res = null;
        try {
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select distinct * from mozi");

            res = new ArrayList<>();

            while (rs.next()) {
                res.add(new CinemaData(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return res;
    }

    public ArrayList<MovieData> getAllUniqueMovie() {
        Statement stmt = null;
        ArrayList<MovieData> res = null;
        try {
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select distinct * from film");

            res = new ArrayList<>();

            while (rs.next()) {
                res.add(new MovieData(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return res;
    }

    public boolean insertLocation(CinemaData cinema, MovieData movie) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            stmt.executeUpdate("insert into hely values (" + movie.getFkod() + ", " + cinema.moziazon + ")");


        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean updateCinema(CinemaData cinema) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            stmt.executeUpdate(generateUpdateCinemaString(cinema));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try{
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private String generateUpdateCinemaString(CinemaData cinema) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        sb.append("update mozi SET ");
        if (cinema.moziazon != null) {
            if (cinema.mozinev != null && !cinema.mozinev.isBlank()) {
                if (!first) {
                    sb.append(" , ");
                }
                sb.append("mozinev = '" + cinema.getMozinev() + "'");
                first = false;
            }
            if (cinema.irszam != null ) {
                if (!first) {
                    sb.append(" , ");
                }
                sb.append("irszam = " + cinema.getIrszam().toString());
                first = false;
            }
            if (cinema.cim != null && !cinema.cim.isBlank()) {
                if (!first) {
                    sb.append(" , ");
                }
                sb.append("cim = '" + cinema.getCim() + "'");
                first = false;
            }
            if (cinema.telefon != null ) {
                if (!first) {
                    sb.append(" , ");
                }
                sb.append("telefon = " + cinema.getTelefon());
                first = false;
            }
        }
        sb.append(" where moziazon = " + cinema.getMoziazon().toString());

        System.out.println("generated sql string:");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public boolean deleteMovieById(Integer fkod) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();

            stmt.executeUpdate("delete from film where fkod = " + fkod.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try{
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
