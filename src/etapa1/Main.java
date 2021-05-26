package etapa1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Serviciu servicii = new Serviciu();

        var curierulMeu = servicii.CreateSofer();
        var curierulMeu2 = servicii.CreateBiciclist();
        var localulMeu = servicii.CreateRestaurant();

//        localulMeu.addToCurieriAutorizati(curierulMeu);

        var destinatar = servicii.CreateDestinatar();
        var comandaMea = servicii.CreateComanda(localulMeu, curierulMeu, destinatar);
        var comanda2Mea = servicii.CreateComanda(localulMeu, curierulMeu2, destinatar);

        System.out.println("Impozit 2% din " + comandaMea.getLocal().getNumeLocal() + " este: " +  servicii.calculeazaImpozitAfacere(comandaMea.getLocal(), 2));
        servicii.afiseazaComenziFacuteLaLocal(comandaMea.getLocal());
        servicii.afiseazaCurieriAutorizati(localulMeu);

    }
}
