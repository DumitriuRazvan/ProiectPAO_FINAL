package etapa3;

import java.sql.*;
import java.util.Scanner;

public class serviciiSistem {

    private static serviciiSistem instance;

    public static serviciiSistem getInstance() {
        if (instance == null)
        {
            instance = new serviciiSistem();
        }
        return instance;
    }


    public void afiseazaComenziFacuteLaRestaurant(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Numele restaurantului pentru care se afiseaza comenzile:");
            var numeRestaurant = scanner.nextLine();

            String query = "select * from comenzi_restaurant  where numerestaurant = ?";
            PreparedStatement prepStat = con.prepareStatement(query);
            prepStat.setString(1,numeRestaurant);
            ResultSet rs = prepStat.executeQuery();
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
            System.out.println(p);
            con.close();


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public void calculeazaImpozitAfacereRestaurant(String host, String user, String password)
    {
        var profit = 0;
        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Numele restaurantului pentru care se afiseaza comenzile:");
            var numeRestaurant = scanner.nextLine();

            String query = "select * from comenzi_restaurant  where numerestaurant = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (1, numeRestaurant);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                String numeClient = rs.getString("numeclient");
                int stocbautura = rs.getInt("nrbautura");
                int stocdesert = rs.getInt("nrdesert");
                int stocmancare = rs.getInt("nrmancare");
                int pretBautura = 10;
                int pretDesert = 20;
                int pretMancare = 30;   // additional query from restaurant table is useful

                profit += (stocbautura * pretBautura + stocdesert * pretDesert + pretMancare * stocmancare) * 0.5;
            }
            System.out.println("Profitul este: " + profit);
            con.close();


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        public void afiseazaCurieriAutorizati(String host, String user, String password) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Numele restaurantului pentru care se afiseaza curierii autorizati:");
            var numeRestaurant = scanner.nextLine();

            String query = "select numecurier from comenzi_restaurant where numerestaurant = ?";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, numeRestaurant);
            ResultSet rs = preparedStmt.executeQuery();
            String p = "";
            while (rs.next()) {
                String numecurier = rs.getString("numecurier");
                Statement stat2 = con.createStatement();
                String query2 = "select * from soferi  where numecurier = ?";
                PreparedStatement preparedStmt2 = con.prepareStatement(query2);
                preparedStmt2.setString(1, numecurier);
                ResultSet rs2 = preparedStmt2.executeQuery();
                while (rs2.next()) {
                    String numesofer = rs2.getString("numecurier");
                    String numemasina = rs2.getString("numemasina");
                    int consum = rs2.getInt("consum");
                    p += numesofer + "," + numemasina + "," + consum + "\n";
                }
                preparedStmt2.close();


            }
            System.out.println(p);
            preparedStmt.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
