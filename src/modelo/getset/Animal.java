package modelo.getset;

import java.time.LocalDate;

public class Animal {
    private Integer idAnimal;
    private String nome;
    private String raca;
    private String sexo;
    private LocalDate dataNasc;
    private double pesoAtual;
    private String origem;

    public Animal() {

    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
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

