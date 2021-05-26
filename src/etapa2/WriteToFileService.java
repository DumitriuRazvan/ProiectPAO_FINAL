package etapa2;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class WriteToFileService {

    private static WriteToFileService instance;

    public static WriteToFileService getFile()
    {
        if (instance == null)
        {
            instance = new WriteToFileService();
        }
        return instance;
    }

    public void  writeToFileComanda(String PATH, Comanda comanda)
    {
        File csvFile = new File(PATH);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        try {
            bw.append(comanda.getLocal().getNumeLocal() + "," + comanda.getNrBucatiMancare() + "," + comanda.getNrBucatiBautura() + ","
                    + comanda.getNrBucatiDesert() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        writeToFileAudit("createComanda");

    }

    public void  writeToFileLocal(String PATH, Local local)
    {
        File csvFile = new File(PATH);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        try {

            if (local instanceof Restaurant)
            {
                bw.append("Restaurant" + "," + local.getNumeLocal() + "," + ((Restaurant) local).getPretBauturi() + "," + ((Restaurant) local).getPretDesert() + ","
                        + ((Restaurant) local).getPretMancare() + "," + ((Restaurant) local).getStocBucatiBauturi() + "," + ((Restaurant) local).getStocBucatiDesert() + ","
                        + ((Restaurant) local).getStocBucatiMancare() + '\n');
                writeToFileAudit("createRestaurant");
            }
            else if (local instanceof Bar)
            {

                if (local instanceof Restaurant)
                {
                    bw.append("Bar" + "," + local.getNumeLocal() + "," + ((Bar) local).getPretBauturi() + "," + ((Bar) local).getPretDesert() + ","
                            + ((Bar) local).getStocBucatiBauturi() + "," + ((Bar) local).getStocBucatiDesert() + '\n');
                    writeToFileAudit("createBar");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


    public static void writeToFileAudit(String denumireActiune)
    {
        String PATH = "src/Output/ServiceAudit.csv";
        try {
            FileWriter fw = new FileWriter(new File(PATH), true);
            Date d = new Date();
            //getTime() returns current time in milliseconds
            long t = d.getTime();
            //Passed the milliseconds to constructor of Timestamp class
            Timestamp ts = new Timestamp(t);
            fw.write(denumireActiune + "," +  ts.toString());
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void  writeToFileDestinatar(String PATH, User destinatar)
    {
        File csvFile = new File(PATH);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        try {
            bw.append(destinatar.getNume() + "," + destinatar.getVarsta() +',' + destinatar.getAdresa() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        writeToFileAudit("createDestinatar");

    }

    public void  writeToFileCurieri(String PATH, Curier curier)
    {
        File csvFile = new File(PATH);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(csvFile, true));
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        try {
            if (curier instanceof Biciclist)
            {
                bw.append(curier.getNumeCurier() + "," + ((Biciclist) curier).getModelBicicleta() + "\n");
                writeToFileAudit("createBiciclist");
            }
            else if (curier instanceof Sofer)
            {
                bw.append(curier.getNumeCurier() + "," + ((Sofer) curier).getNumeMasina() + "," + ((Sofer) curier).getConsum() +'\n');
                writeToFileAudit("createSofer");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
