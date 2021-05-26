package etapa3;

import java.sql.*;

public class ReadDBService {

    private static ReadDBService instance;

    public static ReadDBService getInstance() {
        if (instance == null)
        {
            instance = new ReadDBService();
        }
        return instance;
    }



    public String showBars(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            Statement stat = con.createStatement();
            String sql = "select * from bars";
            ResultSet rs = stat.executeQuery(sql);
            String p = "";
            while (rs.next()) {

                String numeLocal = rs.getString("numelocal");
                int stocbautura = rs.getInt("stocbautura");
                int stocdesert = rs.getInt("stocdesert");
                int pretbautura = rs.getInt("pretbautura");
                int pretdesert = rs.getInt("pretdesert");
                p += numeLocal + "," +  stocbautura + "," + stocdesert + "," + pretbautura + "," + pretdesert + ","  + "\n";

            }
            con.close();
            return p;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }
    public String showUsers(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            Statement stat = con.createStatement();
            String sql = "select * from users";
            ResultSet rs = stat.executeQuery(sql);
            String p = "";
            while (rs.next()) {

                String nume = rs.getString("nume");
                String adresa = rs.getString("adresa");
                int varsta = rs.getInt("varsta");
                p += nume + "," +  adresa + "," + varsta + "\n";
            }
            con.close();
            return p;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }


    public String showcomenzi_restaurant(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            Statement stat = con.createStatement();
            String sql = "select * from comenzi_restaurant";
            ResultSet rs = stat.executeQuery(sql);
            String p = "";
            while (rs.next()) {

                String numeClient = rs.getString("numeclient");
                int stocbautura = rs.getInt("nrbautura");
                int stocdesert = rs.getInt("nrdesert");
                int stocmancare = rs.getInt("nrmancare");
                String numecurier = rs.getString("numecurier");
                String numerestaurant = rs.getString("numerestaurant");
                p += numeClient + "," +  stocbautura + "," + stocdesert + "," + stocmancare + "," + numecurier + "," + numerestaurant  + "\n";
            }
            con.close();
            return p;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }



    public String showrestaurants(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            Statement stat = con.createStatement();
            String sql = "select * from restaurants";
            ResultSet rs = stat.executeQuery(sql);
            String p = "";
            while (rs.next()) {

                String nume = rs.getString("numelocal");
                int stocmancare= rs.getInt("stocmancare");
                int stocbautura = rs.getInt("stocbautura");
                int stocdesert = rs.getInt("stocdesert");
                int pretmancare = rs.getInt("pretmancare");
                int pretbautura = rs.getInt("pretbautura");
                int pretdesert = rs.getInt("pretdesert");
                p += stocmancare + "," +  stocbautura + "," + stocdesert + "," +  pretmancare + "," +
                        "," +  pretbautura + "," + pretdesert +"\n";
            }
            con.close();
            return p;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }

    public String showSoferi(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            Statement stat = con.createStatement();
            String sql = "select * from soferi";
            ResultSet rs = stat.executeQuery(sql);
            String p = "";
            while (rs.next()) {

                String numecurier = rs.getString("numecurier");
                String numemasina= rs.getString("numemasina");
                int consum = rs.getInt("consum");
                p += numecurier + "," + numemasina + "," + consum + "\n";
            }
            con.close();
            return p;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }




}
