package com.example.javafx_beadando;

import java.sql.*;
import java.util.ArrayList;

public class MoziDAO {

    private Connection Con;


    public MoziDAO(String url) {//"jdbc:mysql://localhost/mozimusor?user=root"
        try {
            Con= DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

public ArrayList<String> getMoziNev(){

        String sql="select mozinev from mozi";

    try {
        Statement st = Con.createStatement();
        ResultSet res = st.executeQuery(sql);
        ArrayList<String> list=new ArrayList<String>();
            while(res.next()){
                list.add(res.getString("mozinev"));
            }

        return list;
    }
    catch (SQLException ex) {
        System.out.println(ex);
        return null;
    }

}


public Mozi getMozi(String nev){

    String sql="select * from mozi where mozinev='"+nev+"'";

    try {
        Statement st = Con.createStatement();
        ResultSet res = st.executeQuery(sql);

        int id,irszam;
        String mozinev,cim,telefon;

        res.next();

        id=res.getInt("moziazon");
        mozinev=res.getString("mozinev");
        irszam=res.getInt("irszam");
        cim=res.getString("cim");
        telefon=res.getString("telefon");

        Mozi re=new Mozi(id,mozinev,irszam,cim,telefon);

        return re;
    }
    catch (SQLException ex) {
        System.out.println(ex);
        return null;
    }

}


    public void UpdateMozi(Mozi update) {
        String sql="UPDATE `mozi` SET `moziazon`="+update.getMoziazon()+",`mozinev`='"+update.getMozinev()+"',`irszam`="+update.getIrszam()+",`cim`='"+update.getCim()+"',`telefon`='"+update.getTelefon()+"' WHERE `moziazon`="+update.getMoziazon();
        try {
            Statement st = Con.createStatement();
            System.out.println(sql);
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void deleteMozi(String a) {

        try {
            Statement st = Con.createStatement();
            st.execute( "DELETE FROM mozi WHERE mozinev ='" + a + "'");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
