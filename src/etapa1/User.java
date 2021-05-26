package etapa1;

public class User {
    private String adresa;
    private String nume;
    private Integer varsta;

    public User(String adresa, String nume, Integer varsta) {
        this.adresa = adresa;
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
}
