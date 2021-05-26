package etapa2;


import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadFileService {

    private static ReadFileService instance;

    public static ReadFileService getFile()
    {
        if (instance == null)
        {
            instance = new ReadFileService();
        }
        return instance;
    }

    public List<User> readUsers(String PATH)
    {
        String csvFile = PATH;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        List<User> destinatari = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                var element = line.split(cvsSplitBy);
                String nume = element[0];
                int varsta = Integer.parseInt(element[1]);
                String adresa = element[2];
                User destinatar = new User(adresa,nume, varsta);
                destinatari.add(destinatar);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        WriteToFileService.writeToFileAudit("createDestinatar");
        return destinatari;



    }


    public List<Sofer> readSoferi(String PATH)
    {
        String csvFile = PATH;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        List<Sofer> soferi = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                var element = line.split(cvsSplitBy);
                String numeCurier = element[0];
                String numeMasina = element[1];
                int consum = Integer.parseInt(element[2]);
                Sofer sofer = new Sofer(numeMasina,numeCurier,consum);
                soferi.add(sofer);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        WriteToFileService.writeToFileAudit("createSofer");
        return soferi;



    }

    public List<Biciclist>  readBiciclist(String PATH)
    {
        String csvFile = PATH;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        List<Biciclist> biciclists = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                var element = line.split(cvsSplitBy);
                String numeCurier = element[0];
                String modelBicicleta = element[1];
                Biciclist biciclist = new Biciclist(numeCurier,modelBicicleta);
                biciclists.add(biciclist);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        WriteToFileService.writeToFileAudit("createBiciclist");
        return biciclists;




    }

    public List<Restaurant>  readRestaurants(String PATH)
    {
        String csvFile = PATH;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        List<Restaurant> restaurante = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                var element = line.split(cvsSplitBy);
                String numeLocal = element[0];
                int stocBucatiMancare = Integer.parseInt(element[1]);
                int stocBucatiDesert = Integer.parseInt(element[2]);
                int stocBucatiBauturi = Integer.parseInt(element[3]);
                int pretMancare = Integer.parseInt(element[4]);
                int pretDesert = Integer.parseInt(element[5]);
                int pretBauturi = Integer.parseInt(element[6]);
                Restaurant restaurant = new Restaurant(numeLocal,stocBucatiMancare,stocBucatiDesert,
                        stocBucatiBauturi, pretMancare, pretDesert, pretBauturi);
                restaurante.add(restaurant);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        WriteToFileService.writeToFileAudit("createRestaurant");
        return restaurante;




    }

}
