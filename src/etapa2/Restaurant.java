package etapa2;

public class Restaurant extends Local {

    private Integer stocBucatiMancare;
    private Integer stocBucatiDesert;
    private Integer stocBucatiBauturi;
    private Integer pretMancare;
    private Integer pretDesert;
    private Integer pretBauturi;


    public Restaurant(String numeLocal, Integer stocBucatiMancare, Integer stocBucatiDesert, Integer stocBucatiBauturi, Integer pretMancare, Integer pretDesert, Integer pretBauturi) {
        super(numeLocal);
        this.stocBucatiMancare = stocBucatiMancare;
        this.stocBucatiDesert = stocBucatiDesert;
        this.stocBucatiBauturi = stocBucatiBauturi;
        this.pretMancare = pretMancare;
        this.pretDesert = pretDesert;
        this.pretBauturi = pretBauturi;
    }
    @Override
    public Integer calculeazaProfit(Comanda c){
        var profit = c.getNrBucatiMancare() * pretMancare + c.getNrBucatiBautura() * pretBauturi + c.getNrBucatiDesert() *pretDesert;
        return profit;
    }

    public Integer getStocBucatiMancare() {
        return stocBucatiMancare;
    }

    public void setStocBucatiMancare(Integer stocBucatiMancare) {
        this.stocBucatiMancare = stocBucatiMancare;
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

    public Integer getPretMancare() {
        return pretMancare;
    }

    public void setPretMancare(Integer pretMancare) {
        this.pretMancare = pretMancare;
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
