package dados;

// Subclasse para Vaca
public class Vaca extends Animal {
    private int numeroLactacoes;
    private String statusLactacao;
    private double producaoDiaria;
    private double producaoTotalLactacao;
    private String statusReprodutivo;
    private String ultimaCobertura;
    private String ultimaParicao;

    public int getNumeroLactacoes() {
        return numeroLactacoes;
    }

    public void setNumeroLactacoes(int numeroLactacoes) {
        this.numeroLactacoes = numeroLactacoes;
    }

    public String getStatusLactacao() {
        return statusLactacao;
    }

    public void setStatusLactacao(String statusLactacao) {
        this.statusLactacao = statusLactacao;
    }

    public double getProducaoDiaria() {
        return producaoDiaria;
    }

    public void setProducaoDiaria(double producaoDiaria) {
        this.producaoDiaria = producaoDiaria;
    }

    public double getProducaoTotalLactacao() {
        return producaoTotalLactacao;
    }

    public void setProducaoTotalLactacao(double producaoTotalLactacao) {
        this.producaoTotalLactacao = producaoTotalLactacao;
    }

    public String getStatusReprodutivo() {
        return statusReprodutivo;
    }

    public void setStatusReprodutivo(String statusReprodutivo) {
        this.statusReprodutivo = statusReprodutivo;
    }

    public String getUltimaCobertura() {
        return ultimaCobertura;
    }

    public void setUltimaCobertura(String ultimaCobertura) {
        this.ultimaCobertura = ultimaCobertura;
    }

    public String getUltimaParicao() {
        return ultimaParicao;
    }

    public void setUltimaParicao(String ultimaParicao) {
        this.ultimaParicao = ultimaParicao;
    }
}
