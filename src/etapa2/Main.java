package etapa2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Serviciu servicii = new Serviciu();

        String PATH = "src/input/";
        String PATH2 = "src/output/";

        var instance = ReadFileService.getFile();

        var biciclistiiMei = instance.readBiciclist(PATH+"biciclisti.csv");
        var soferiiMei = instance.readSoferi(PATH+"soferi.csv");
        var restauranteleMele = instance.readRestaurants(PATH+"restaurante.csv");
        var destinatariiMei = instance.readUsers(PATH+"destinatari.csv");

        // cititi din fisier
        var localulMeu = restauranteleMele.get(0);
        var curierulMeu = soferiiMei.get(0);
        var destinatar = destinatariiMei.get(0);
        var curierulMeu2 = biciclistiiMei.get(0);

        // cititi de la tastatura, scrisi in fisier
        var localulMeu2 = servicii.CreateBar(PATH2 + "localuri.csv");
        var curierulMeu3 = servicii.CreateBiciclist(PATH2 + "biciclisti.csv");
        var destinatar2 = servicii.CreateDestinatar(PATH2 + "destinatari.csv");

        var comandaMea = servicii.CreateComanda(localulMeu, curierulMeu, destinatar, PATH2 + "comenzi.csv");
        var comandaMea2 = servicii.CreateComanda(localulMeu, curierulMeu2, destinatar, PATH2 + "comenzi.csv");
        var comandaMea3 = servicii.CreateComanda(localulMeu2,curierulMeu3,destinatar2, PATH2 + "comenzi.csv");

        servicii.calculeazaImpozitAfacere(comandaMea.getLocal(), 2);
        servicii.afiseazaComenziFacuteLaLocal(comandaMea.getLocal());
        servicii.afiseazaCurieriAutorizati(localulMeu);

    }
}
