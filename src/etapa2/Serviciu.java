package etapa2;

import java.util.*;




public class Serviciu {

    Restaurant CreateRestaurant(String PATH)
    {
        System.out.println("Se citesc pentru restaurant parametrii lui\n---------------------\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numele restaurantului : ");
        var numeLocal = scanner.nextLine();
        System.out.println("Stocul de mancare : ");
        var stocMancare = scanner.nextInt();
        System.out.println("Stocul de bautura:");
        var stocBautura = scanner.nextInt();
        System.out.println("Stocul de desert");
        var stocDesert = scanner.nextInt();
        System.out.println("Pret mancare: ");
        var pretMancare = scanner.nextInt();
        System.out.println("Pret bautura: ");
        var pretBautura = scanner.nextInt();
        System.out.println("Pret desert: ");
        var pretDesert = scanner.nextInt();
        Restaurant restaurant = new Restaurant(numeLocal,stocMancare, stocBautura, stocDesert, pretMancare, pretDesert, pretBautura);

        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileLocal(PATH, restaurant);

        return restaurant;
    }
    Bar CreateBar(String PATH)
    {
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
        Bar bar = new Bar(numeLocal,stocBautura, stocDesert,  pretDesert, pretBautura);

        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileLocal(PATH, bar);

        return bar;
    }

    Sofer CreateSofer(String PATH)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Se citeste parametri soferului");
        System.out.println("Cum te cheama?");
        String numeCurier = scanner.nextLine();
        System.out.println("Ce masina ai?");
        String numeMasina = scanner.nextLine();
        System.out.println("Cat consuma?");
        Integer consum = scanner.nextInt();
        Sofer sofer = new Sofer(numeMasina,numeCurier,consum);

        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileCurieri(PATH, sofer);

        return sofer;
    }


    Biciclist CreateBiciclist(String PATH)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se citeste parametri biciclistului");
        System.out.println("Cum te cheama?");
        String numeCurier = scanner.nextLine();
        System.out.println("Ce bicicleta ai?");
        String modelBicicleta = scanner.nextLine();
        Biciclist biciclist = new Biciclist(numeCurier,modelBicicleta);

        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileCurieri(PATH, biciclist);

        return biciclist;
    }

    User CreateDestinatar(String PATH)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se citesc parametrii destinatarului");

        System.out.println("Ce nume ai?");
        var nume = scanner.nextLine();

        System.out.println("Ce adresa de livrare?");
        var adresa = scanner.nextLine();

        System.out.println("Ce varsta ai?");
        var varsta = scanner.nextInt();

        User destinatar = new User(adresa,nume, varsta);

        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileDestinatar(PATH, destinatar);

        return destinatar;
    }



    Comanda CreateComanda(Local localAles, Curier curierAles, User destinatar, String PATH)
    {
        Comanda comanda = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Se citeste pentru comanda parametrii urmatori:");
        //System.out.println("Soferul ajunge mai repede, dar biciclistul este mai sigur pentru mediul inconjurator");

        if(localAles instanceof Restaurant)
        {
            var nrBautura = 0;
            System.out.println("Esti la restaurant. Ce produse servesti?");
            System.out.println("Cate portii de mancare vrei: ");
            var nrMancare = scanner.nextInt();
            if(destinatar.getVarsta() >= 18) {
                System.out.println("Cate portii de bautura vrei: ");
                nrBautura = scanner.nextInt();
            }
            System.out.println("Cate portii de desert vrei: ");
            var nrDesert = scanner.nextInt();
            comanda = new Comanda(curierAles, nrMancare, nrBautura, destinatar, nrDesert, localAles);
        }
        if(localAles instanceof Bar)
        {
            var nrBautura = 0;
            System.out.println("Esti la Bar. Ce produse servesti?");
            if(destinatar.getVarsta() >= 18) {
                System.out.println("Cate portii de bautura vrei: ");
                nrBautura = scanner.nextInt();
            }
            System.out.println("Cate portii de desert vrei: ");
            var nrDesert = scanner.nextInt();
            comanda = new Comanda(curierAles, 0, nrBautura, destinatar, nrDesert, localAles);
        }
        localAles.adaugaComanda(comanda);
        localAles.addToCurieriAutorizati(curierAles);
        comanda.setLocal(localAles);

        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileComanda(PATH, comanda);

        return comanda;
    }

    void afiseazaComenziFacuteLaLocal(Local local)
    {
            var lista = local.getListaComenzi();
            Collections.sort(lista, Comanda.SortareDupaProfit);
            for( var comanda : lista  )
            {
                if( comanda.getCurier() instanceof Sofer)
                {
                    System.out.println("Soferul " + comanda.getCurier().getNumeCurier() + " cu masina " + ((Sofer) comanda.getCurier()).getNumeMasina() + " va livra comanda lui " +
                                        comanda.getDestinatar().getNume() + " in " + comanda.getCurier().calculeazaMinute((comanda)) +" minute " + " si va plati " + comanda.getLocal().calculeazaProfit(comanda) +" lei");
                }
                if( comanda.getCurier() instanceof Biciclist)
                {
                    System.out.println("Biciclistul " + comanda.getCurier().getNumeCurier() + " cu bicicleta " + ((Biciclist) comanda.getCurier()).getModelBicicleta() + " va livra comanda lui " +
                            comanda.getDestinatar().getNume() + " in " + comanda.getCurier().calculeazaMinute((comanda)) +" minute " + " si va plati " + comanda.getLocal().calculeazaProfit(comanda
                    ) +" lei");
                }
            }

            // write to CSV file
            var file = WriteToFileService.getFile();
            file.writeToFileAudit("afisareComenziFacuteLaLocal");
    }

    Integer calculeazaImpozitAfacere(Local local, Integer cotaImpozit)
    {
        var profit = 0;
        for(var comanda : local.getListaComenzi())
            profit += local.calculeazaProfit(comanda);


        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileAudit("calculareImpozitAfacere" + cotaImpozit.toString() + "%");

        return profit * cotaImpozit;
    }

    void afiseazaCurieriAutorizati(Local local)
    {
        var curieri = local.getCurieriAutorizati();
        System.out.println("Localul " + local.getNumeLocal() + " are " + curieri.size() + " curieri autorizati. Acestia sunt: ");
        int count = 1;
        for (var curier : curieri)
        {

            System.out.println(count + " Curierul " + curier.getNumeCurier() + ' ' );
            if (curier instanceof Biciclist)
            {
                System.out.println("cu model de bicicleta " + ((Biciclist) curier).getModelBicicleta());
            }
            else if (curier instanceof Sofer)
            {
                System.out.println("cu masina" + ((Sofer) curier).getNumeMasina() + " ce consuma" + ((Sofer) curier).getConsum());
            }
            count ++;
        }
        // write to CSV file
        var file = WriteToFileService.getFile();
        file.writeToFileAudit("afisareCurieriAutorizati");

    }
}


