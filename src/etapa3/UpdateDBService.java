package etapa3;

import java.sql.*;
import java.util.Scanner;

public class UpdateDBService {

    private static UpdateDBService instance;

    public static UpdateDBService getInstance() {
        if (instance == null)
        {
            instance = new UpdateDBService();
        }
        return instance;
    }



    public void updateUser(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Se va modifica adresa si varsta unui utilizator din DB");
            System.out.println("Ce nume are userul?");
            var nume = scanner.nextLine();
            System.out.println("Noua adresa:");
            var adresa =scanner.nextLine();
            System.out.println("Varsta noua: ");
            var varsta = scanner.nextInt();

            String query = "update users set adresa = ?, varsta = ? where nume = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (1, adresa);
            preparedStmt.setInt   (2, varsta);
            preparedStmt.setString(3, nume);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();
            preparedStmt.close();
            con.close();
            System.out.println("Users table updated");


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void updateSofer(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Se va modifica masina  unui sofer din DB");
            System.out.println("Ce nume are soferul??");
            var nume = scanner.nextLine();
            System.out.println("Noul model de masina: ");
            var model =scanner.nextLine();
            System.out.println("Consumul: ");
            var consum = scanner.nextInt();

            String query = "update soferi set numemasina = ?, consum = ? where numecurier = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (1, model);
            preparedStmt.setInt   (2, consum);
            preparedStmt.setString(3, nume);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();
            preparedStmt.close();
            con.close();
            System.out.println("Soferi table updated");


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void updatecomenzi_restaurant(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Se va modifica cantitatea produselor unei comenzi din DB");
            System.out.println("Ce nume are userul?");
            var nume = scanner.nextLine();
            System.out.println("Ce nume are restaurantul");
            var numeRestaurant =scanner.nextLine();
            System.out.println("Cate portii de bautura vrei: ");
            var nrBautura = scanner.nextInt();
            System.out.println("Cate portii de desert vrei: ");
            var nrDesert = scanner.nextInt();
            System.out.println("Cate portii de mancare vrei: ");
            var nrMancare = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ce nume are curierul?");
            var numeCurier = scanner.nextLine();

            String query = "update comenzi_restaurant set nrbautura = ?, nrdesert = ?, nrmancare = ?, numeCurier = ? " +
                    "where numeclient = ? and numerestaurant = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt   (1, nrBautura);
            preparedStmt.setInt   (2, nrDesert);
            preparedStmt.setInt(3, nrMancare);
            preparedStmt.setString(4, numeCurier);
            preparedStmt.setString   (5, nume);
            preparedStmt.setString(6, numeRestaurant);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();
            preparedStmt.close();
            con.close();
            System.out.println("comenzi_restaurant table updated");


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }



    public void updatebar(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Se va modifica stocul unui bar");
            System.out.println("Ce nume are barul");
            var nume = scanner.nextLine();
            System.out.println("Stocul de bautura:");
            var stocBautura = scanner.nextInt();
            System.out.println("Stocul de desert");
            var stocDesert = scanner.nextInt();
            System.out.println("Pret bautura: ");
            var pretBautura = scanner.nextInt();
            System.out.println("Pret desert: ");
            var pretDesert = scanner.nextInt();

            String query = "update bars set stocbautura = ?, stocdesert = ?," +
                    "pretbautura = ?, pretdesert = ? where numelocal = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt   (1, stocBautura);
            preparedStmt.setInt(2, stocDesert);
            preparedStmt.setInt(3, pretBautura);
            preparedStmt.setInt(4, pretDesert);
            preparedStmt.setString(5, nume);
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();
            preparedStmt.close();
            con.close();
            System.out.println("bars table updated");


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }




}
