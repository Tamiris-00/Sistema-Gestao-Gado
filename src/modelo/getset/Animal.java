package modelo.getset;

public class Animal {
    private int brinco;
    private String nome;
    private String raca;
    private String sexo;
    private String dataNascimento;
    private double pesoAtual;
    private String origem;

    public Animal() {

    }

    public int getBrinco() {
        return brinco;
    }

    public void setBrinco(int brinco) {
        this.brinco = brinco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeTouro) {
        this.nome = nomeTouro;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String racaTouro) {
        this.raca = racaTouro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    // getters, setters e construtor
}

