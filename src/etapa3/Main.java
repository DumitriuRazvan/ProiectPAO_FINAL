package etapa3;

public class Main {

    public static void main(String[] args) {
//        Serviciu servicii = new Serviciu();

        String host = "jdbc:mysql://localhost:9900/restaurantdb";
        String user = "root";
        String password = "razvan";


        var createDBService = CreateDBService.getInstance();
        var readDBService =  ReadDBService.getInstance();
        var updateDBService = UpdateDBService.getInstance();
        var deleteDBService = DeleteDBService.getInstance();
        var serviciiSistem = etapa3.serviciiSistem.getInstance();

        serviciiSistem.calculeazaImpozitAfacereRestaurant(host,user,password);
        serviciiSistem.afiseazaComenziFacuteLaRestaurant(host,user,password);
        serviciiSistem.calculeazaImpozitAfacereRestaurant(host,user,password);

//        updateDBService.updateUser(host,user,password);
//        updateDBService.updatecomenzi_restaurant(host,user,password);
//        updateDBService.updatebar(host,user,password);
//        updateDBService.updateSofer(host,user,password);

//        System.out.println(readDBService.showBars(host,user,password));
//        System.out.println(readDBService.showcomenzi_restaurant(host,user,password));
//        System.out.println(readDBService.showUsers(host,user,password));
//        System.out.println(readDBService.showSoferi(host,password,password));


//        deleteDBService.deleteUser(host,user,password);
//        deleteDBService.deleteSofer(host,user,password);
//          deleteDBService.deletebar(host,user,password);
//        deleteDBService.deletecomanda_restaurant(host,user,password);

//        createDBService.readUser(host,user,password);
//        createDBService.readSofer(host,user,password);
//        createDBService.readRestaurant(host,user,password);
//        createDBService.readComandaRestaurant(host,user,password);
//


    }
}
