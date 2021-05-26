package etapa2;


public class Biciclist extends Curier {
    private String modelBicicleta;


    Biciclist(){
        modelBicicleta = "MTB";
    }

    public Biciclist(String numeCurier, String modelBicicleta) {
        this.modelBicicleta = modelBicicleta;
        this.numeCurier = numeCurier;
    }

    @Override
    public Integer calculeazaMinute(Comanda c){
        if(c.getLocal() instanceof Restaurant)
        {
            int nrBucatiTotal = c.getNrBucatiMancare()  + c.getNrBucatiDesert() + c.getNrBucatiBautura();
            if(nrBucatiTotal <= 10)
                c.setCurierMinuteDeplasare(30);
            else if(nrBucatiTotal <= 20)
                c.setCurierMinuteDeplasare(40);
            else if(nrBucatiTotal <= 30)
                c.setCurierMinuteDeplasare(50);
        }
        else if(c.getLocal() instanceof Bar) {
            int nrBucatiTotal = c.getNrBucatiDesert() + c.getNrBucatiBautura();
            if(nrBucatiTotal <= 10)
                c.setCurierMinuteDeplasare(30);
            else if(nrBucatiTotal <= 20)
                c.setCurierMinuteDeplasare(40);
            else if(nrBucatiTotal <= 30)
                c.setCurierMinuteDeplasare(50);
        }
        return c.getCurierMinuteDeplasare();
    }

    public String getModelBicicleta() {
        return modelBicicleta;
    }

    public void setModelBicicleta(String modelBicicleta) {
        this.modelBicicleta = modelBicicleta;
    }
}
