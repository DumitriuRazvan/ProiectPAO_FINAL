package etapa3;

import java.sql.*;
import java.util.Scanner;

public class DeleteDBService {

    private static DeleteDBService instance;

    public static DeleteDBService getInstance() {
        if (instance == null)
        {
            instance = new DeleteDBService();
        }
        return instance;
    }



    public void deleteUser(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Se va sterge un destinatar");
            System.out.println("Ce nume are userul?");
            var nume = scanner.nextLine();

            String query = "delete from users where nume = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nume);

            // execute the java preparedstatement
            if(preparedStmt.executeUpdate() == 0)
            {
                System.out.println("Nothing deleted");
            }
            con.commit();
            preparedStmt.close();
            con.close();


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void deleteSofer(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Se va sterge un sofer");
            System.out.println("Ce nume are soferul??");
            var nume = scanner.nextLine();

            String query = "delete from soferi where numecurier = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nume);

            // execute the java preparedstatement
            if(preparedStmt.executeUpdate() == 0)
            {
                System.out.println("nothing deleted");
            }
            con.commit();
            preparedStmt.close();
            con.close();
            System.out.println("Soferi table updated");


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void deletecomanda_restaurant(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);


            System.out.println("Se va sterge o comanda restaurant din DB");
            System.out.println("Ce nume are userul?");
            var nume = scanner.nextLine();
            System.out.println("Ce nume are restaurantul");
            var numeRestaurant =scanner.nextLine();

            String query = "delete from comenzi_restaurant where numeclient = ? and numerestaurant = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString   (1, nume);
            preparedStmt.setString(2, numeRestaurant);

            // execute the java preparedstatement
            if(preparedStmt.executeUpdate() == 0)
            {
                System.out.println("Nothing deleted");
            }
            con.commit();
            preparedStmt.close();
            con.close();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }



    public void deletebar(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Statement stat = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Se va sterge stocul unui bar");
            System.out.println("Ce nume are barul");
            var nume = scanner.nextLine();

            String query = "delete from bars  where numelocal = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, nume);
            // execute the java preparedstatement
            if(preparedStmt.executeUpdate() == 0)
            {
                System.out.println("Nothing deleted");
            }
            con.commit();
            preparedStmt.close();
            con.close();


        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }




}
