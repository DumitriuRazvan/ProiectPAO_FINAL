package etapa2;

public class Sofer extends Curier {
    private String numeMasina;

    private Integer consum;

    Sofer(){
        numeMasina = "fara masina";
        consum = 0;
    }

    public Sofer(String numeMasina, String numeCurier, Integer consum) {
        this.numeMasina = numeMasina;
        this.consum = consum;
        this.numeCurier = numeCurier;
    }

    @Override
    public Integer calculeazaMinute(Comanda c){
        if(c.getLocal() instanceof Restaurant)
        {
            int nrBucatiTotal = c.getNrBucatiMancare()  + c.getNrBucatiDesert() + c.getNrBucatiBautura();
            if(nrBucatiTotal <= 10)
                c.setCurierMinuteDeplasare(10);
            else if(nrBucatiTotal <= 20)
                c.setCurierMinuteDeplasare(20);
            else if(nrBucatiTotal <= 30)
                c.setCurierMinuteDeplasare(30);
        }
        else if(c.getLocal() instanceof Bar) {
            int nrBucatiTotal = c.getNrBucatiDesert() + c.getNrBucatiBautura();
            if(nrBucatiTotal <= 10)
                c.setCurierMinuteDeplasare(10);
            else if(nrBucatiTotal <= 20)
                c.setCurierMinuteDeplasare(20);
            else if(nrBucatiTotal <= 30)
                c.setCurierMinuteDeplasare(30);
        }
        return c.getCurierMinuteDeplasare();
    }


    public String getNumeMasina() {
        return numeMasina;
    }

    public void setNumeMasina(String numeMasina) {
        this.numeMasina = numeMasina;
    }

    public Integer getConsum() {
        return consum;
    }

    public void setConsum(Integer consum) {
        this.consum = consum;
    }
}
