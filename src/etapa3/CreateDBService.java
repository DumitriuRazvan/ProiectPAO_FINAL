package etapa3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateDBService {

    private static CreateDBService instance;

    public static CreateDBService getInstance() {
        if (instance == null)
        {
            instance = new CreateDBService();
        }
        return instance;
    }



    public void raedBar(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            System.out.println("Se citesc pentru bar parametrii lui\n---------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Numele bar-ului: ");
            var numeLocal = scanner.nextLine();
            System.out.println("Stocul de bautura:");
            var stocBautura = scanner.nextInt();
            System.out.println("Stocul de desert");
            var stocDesert = scanner.nextInt();
            System.out.println("Pret bautura: ");
            var pretBautura = scanner.nextInt();
            System.out.println("Pret desert: ");
            var pretDesert = scanner.nextInt();

            String query = " insert into bars (numelocal, stocbautura, stocdesert, pretbautura, pretdesert)" + " values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, numeLocal);
            preparedStmt.setInt (2, stocBautura);
            preparedStmt.setInt   (3, stocDesert);
            preparedStmt.setInt(4, pretBautura);
            preparedStmt.setInt   (5, pretDesert);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void readRestaurant(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            System.out.println("Se citesc pentru bar parametrii lui\n---------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Numele restaurant: ");
            var numeLocal = scanner.nextLine();
            System.out.println("Stoc de mancare:");
            var stocMancare = scanner.nextInt();
            System.out.println("Stocul de bautura:");
            var stocBautura = scanner.nextInt();
            System.out.println("Stocul de desert");
            var stocDesert = scanner.nextInt();
            System.out.println("Pret bautura: ");
            var pretBautura = scanner.nextInt();
            System.out.println("Pret desert: ");
            var pretDesert = scanner.nextInt();
            System.out.println("Pret mancare:");
            var pretMancare = scanner.nextInt();

            String query = " insert into restaurants (numelocal, stocmancare, stocbautura, stocdesert, pretmancare, pretbautura, pretdesert)" +
                    " values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, numeLocal);
            preparedStmt.setInt   (2, stocMancare);
            preparedStmt.setInt (3, stocBautura);
            preparedStmt.setInt   (4, stocDesert);
            preparedStmt.setInt   (5, pretMancare);
            preparedStmt.setInt(6, pretBautura);
            preparedStmt.setInt   (7, pretDesert);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void readSofer(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Se citeste parametri soferului");
            System.out.println("Cum te cheama?");
            String numeCurier = scanner.nextLine();
            System.out.println("Ce masina ai?");
            String numeMasina = scanner.nextLine();
            System.out.println("Cat consuma?");
            Integer consum = scanner.nextInt();

            String query = " insert into soferi (numeCurier, numeMasina, consum)" + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, numeCurier);
            preparedStmt.setString (2, numeMasina);
            preparedStmt.setInt   (3, consum);
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void readBiciclist(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Se citeste parametri biciclistului");
            System.out.println("Cum te cheama?");
            String numeCurier = scanner.nextLine();
            System.out.println("Ce bicicleta ai?");
            String modelBicicleta = scanner.nextLine();

            String query = " insert into biciclisti (numeCurier, modelBicicleta)" + " values (?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, numeCurier);
            preparedStmt.setString (2, modelBicicleta);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void readUser(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Se citesc parametrii destinatarului");

            System.out.println("Ce nume ai?");
            var nume = scanner.nextLine();

            System.out.println("Ce adresa de livrare?");
            var adresa = scanner.nextLine();

            System.out.println("Ce varsta ai?");
            var varsta = scanner.nextInt();

            String query = " insert into users (nume, adresa, varsta)" + " values (?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, nume);
            preparedStmt.setString (2, adresa);
            preparedStmt.setInt   (3, varsta);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void readComandaRestaurant(String host, String user, String password) {

        Connection con = null;
        try{
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Se citeste pentru comanda parametrii urmatori:");

            System.out.println("Esti la restaurant. Ce produse servesti?");
            System.out.println("Ce nume ai?");
            var numeClient = scanner.nextLine();
            System.out.println("Cate portii de bautura vrei: ");
            var nrBautura = scanner.nextInt();
            System.out.println("Cate portii de desert vrei: ");
            var nrDesert = scanner.nextInt();
            System.out.println("Cate portii de mancare vrei: ");
            var nrMancare = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nume curier: ");
            var numeCurier = scanner.nextLine();
            System.out.println("Nume restaurant:");
            var numeRestaurant = scanner.nextLine();

            String query = " insert into comenzi_restaurant (numeClient, nrbautura, nrdesert, nrMancare, numecurier, numeRestaurant)" +
                    " values (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, numeClient);
            preparedStmt.setInt (2, nrBautura);
            preparedStmt.setInt   (3, nrDesert);
            preparedStmt.setInt   (4, nrMancare);
            preparedStmt.setString(5,numeCurier);
            preparedStmt.setString(6,numeRestaurant);;

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void readComandaBar(String host, String user, String password) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(host, user, password);
            con.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Se citeste pentru comanda parametrii urmatori:");


            System.out.println("Esti la bar. Ce produse servesti?");
            System.out.println("Ce nume ai?");
            var numeClient = scanner.nextLine();
            System.out.println("Cate portii de bautura vrei: ");
            var nrBautura = scanner.nextInt();
            System.out.println("Cate portii de desert vrei: ");
            var nrDesert = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nume curier: ");
            var numeCurier = scanner.nextLine();
            System.out.println("Nume bar:");
            var numeBar = scanner.nextLine();


            String query = " insert into comenzi_restaurant (numeClient, nrbautura, nrdesert, numecurier, numeBar)" + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, numeClient);
            preparedStmt.setInt(2, nrBautura);
            preparedStmt.setInt(3, nrDesert);
            preparedStmt.setString(4, numeCurier);
            preparedStmt.setString(5, numeBar);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            con.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
