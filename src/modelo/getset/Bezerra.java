package modelo.getset;

// Subclasse para Bezerra
public class Bezerra extends Animal {
    private boolean desmamou;
    private String dataDesmame;
    private int consumoLeite;
    private String pai;
    private String mae;

    public boolean isDesmamou() {
        return desmamou;
    }

    public void setDesmamou(boolean desmamou) {
        this.desmamou = desmamou;
    }

    public String getDataDesmame() {
        return dataDesmame;
    }

    public void setDataDesmame(String dataDesmame) {
        this.dataDesmame = dataDesmame;
    }

    public int getConsumoLeite() {
        return consumoLeite;
    }

    public void setConsumoLeite(int consumoLeite) {
        this.consumoLeite = consumoLeite;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    // getters, setters e construtor
}
