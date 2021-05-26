package etapa2;

import java.util.*;

abstract public class Local {
    protected String numeLocal;
    protected ArrayList<Comanda> listaComenzi = new ArrayList<Comanda>();
    protected Set<Curier> curieriAutorizati = new HashSet<>();

    Local()
    {
        this.numeLocal = "none";
    }
    Local(String numeLocal)
    {
        this.numeLocal = numeLocal;
    }






    public void adaugaComanda( Comanda comanda) {
        listaComenzi.add(comanda);
    }


    public Integer calculeazaProfit(Comanda c){
        var profit = 0;
        return profit;
    }

    public String getNumeLocal() {
        return numeLocal;
    }

    public void setNumeLocal(String numeLocal) {
        this.numeLocal = numeLocal;
    }

    public ArrayList<Comanda> getListaComenzi() {
        return listaComenzi;
    }

    public void setListaComenzi(ArrayList<Comanda> listaComenzi) {
        this.listaComenzi = listaComenzi;
    }

    public Set<Curier> getCurieriAutorizati() {
        return curieriAutorizati;
    }

    public void addToCurieriAutorizati(Curier curier) {

        this.curieriAutorizati.add(curier);


    }
}
