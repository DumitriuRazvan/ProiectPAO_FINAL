package etapa2;

public class Bar extends Local {


    private Integer stocBucatiDesert;
    private Integer stocBucatiBauturi;
    private Integer pretDesert;
    private Integer pretBauturi;


    public Bar(String numeLocal, Integer stocBucatiDesert, Integer stocBucatiBauturi, Integer pretDesert, Integer pretBauturi) {
        super(numeLocal);
        this.stocBucatiDesert = stocBucatiDesert;
        this.stocBucatiBauturi = stocBucatiBauturi;
        this.pretDesert = pretDesert;
        this.pretBauturi = pretBauturi;
    }

    @Override
    public Integer calculeazaProfit(Comanda c){
        Integer profit = c.getNrBucatiBautura() * pretBauturi + c.getNrBucatiDesert() *pretDesert;
        return profit;
    }

    public Integer getStocBucatiDesert() {
        return stocBucatiDesert;
    }

    public void setStocBucatiDesert(Integer stocBucatiDesert) {
        this.stocBucatiDesert = stocBucatiDesert;
    }

    public Integer getStocBucatiBauturi() {
        return stocBucatiBauturi;
    }

    public void setStocBucatiBauturi(Integer stocBucatiBauturi) {
        this.stocBucatiBauturi = stocBucatiBauturi;
    }

    public Integer getPretDesert() {
        return pretDesert;
    }

    public void setPretDesert(Integer pretDesert) {
        this.pretDesert = pretDesert;
    }

    public Integer getPretBauturi() {
        return pretBauturi;
    }

    public void setPretBauturi(Integer pretBauturi) {
        this.pretBauturi = pretBauturi;
    }
}
