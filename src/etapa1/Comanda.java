package etapa1;

import java.util.Comparator;

public class Comanda {
    private Curier curier;
    private Integer nrBucatiMancare;
    private Integer nrBucatiBautura;
    private User destinatar;
    private Integer nrBucatiDesert;
    private Local local;
    private  Integer curierMinuteDeplasare;

    public Comanda(Curier curier, Integer nrBucatiMancare, Integer nrBucatiBautura, User destinatar, Integer nrBucatiDesert, Local local) {
        this.curier = curier;
        this.nrBucatiMancare = nrBucatiMancare;
        this.nrBucatiBautura = nrBucatiBautura;
        this.destinatar = destinatar;
        this.nrBucatiDesert = nrBucatiDesert;
        this.local = local;
    }

    public Integer getCurierMinuteDeplasare() {
        return curierMinuteDeplasare;
    }

    public void setCurierMinuteDeplasare(Integer curierMinuteDeplasare) {
        this.curierMinuteDeplasare = curierMinuteDeplasare;
    }

    public Integer getNrBucatiMancare() {
        return nrBucatiMancare;
    }

    public void setNrBucatiMancare(Integer nrBucatiMancare) {
        this.nrBucatiMancare = nrBucatiMancare;
    }

    public Integer getNrBucatiBautura() {
        return nrBucatiBautura;
    }

    public void setNrBucatiBautura(Integer nrBucatiBautura) {
        this.nrBucatiBautura = nrBucatiBautura;
    }

    public Integer getNrBucatiDesert() {
        return nrBucatiDesert;
    }

    public void setNrBucatiDesert(Integer nrBucatiDesert) {
        this.nrBucatiDesert = nrBucatiDesert;
    }


    void setLocal(Local local)
    {
        this.local = local;
    }
    Local getLocal(){return local;}

    public void setCurier(Curier curier) {
        this.curier = curier;
    }

    public User getDestinatar() {
        return destinatar;
    }

    public void setDestinatar(User destinatar) {
        this.destinatar = destinatar;
    }

    Curier getCurier()
    {
        if(curier != null)
            return curier;
        else return null;
    }

    public static Comparator<Comanda> SortareDupaProfit = new Comparator<Comanda>() {
        @Override
        public int compare(Comanda o1, Comanda o2) {
            return (o1.getLocal().calculeazaProfit(o1) - o2.getLocal().calculeazaProfit(o2));
        }
    };

}
