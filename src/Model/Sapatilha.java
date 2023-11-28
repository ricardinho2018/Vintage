package Model;

import java.time.LocalDate;
import java.util.Objects;

public class Sapatilha extends Artigo {
    private int tamanho;
    private boolean temAtacadores;
    private String cor;
    private int anoColecao;
    private int numeroDonos;
    private double estadoUtilizacao;

    // Construtor por omissão
    public Sapatilha() {
        // Chamar o construtor da superclasse Artigo
        super();
    }

    // Construtor parametrizado
    public Sapatilha(String referencia, String marca, double preco, LocalDate dataFabrico,
                     int tamanho, boolean temAtacadores, String cor, int anoColecao,
                     int numeroDonos, double estadoUtilizacao) {
        // Chamar o construtor da superclasse Artigo
        this.tamanho = tamanho;
        this.temAtacadores = temAtacadores;
        this.cor = cor;
        this.anoColecao = anoColecao;
        this.numeroDonos = numeroDonos;
        this.estadoUtilizacao = estadoUtilizacao;
    }

    // Construtor de cópia
    public Sapatilha(Sapatilha other) {
        // Chamar o construtor da superclasse Artigo
        super(other);
        this.tamanho = other.tamanho;
        this.temAtacadores = other.temAtacadores;
        this.cor = other.cor;
        this.anoColecao = other.anoColecao;
        this.numeroDonos = other.numeroDonos;
        this.estadoUtilizacao = other.estadoUtilizacao;
    }

    // Getters e Setters
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isTemAtacadores() {
        return temAtacadores;
    }

    public void setTemAtacadores(boolean temAtacadores) {
        this.temAtacadores = temAtacadores;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    public int getNumeroDonos() {
        return numeroDonos;
    }

    public void setNumeroDonos(int numeroDonos) {
        this.numeroDonos = numeroDonos;
    }

    public double getEstadoUtilizacao() {
        return estadoUtilizacao;
    }

    public void setEstadoUtilizacao(double estadoUtilizacao) {
        this.estadoUtilizacao = estadoUtilizacao;
    }

    // Métodos equals, clone e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sapatilha)) return false;
        if (!super.equals(o)) return false;
        Sapatilha that = (Sapatilha) o;
        return tamanho == that.tamanho &&
                temAtacadores == that.temAtacadores &&
                anoColecao == that.anoColecao &&
                numeroDonos == that.numeroDonos &&
                Double.compare(that.estadoUtilizacao, estadoUtilizacao) == 0 &&
                Objects.equals(cor, that.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tamanho, temAtacadores, cor, anoColecao, numeroDonos, estadoUtilizacao);
    }

    @Override
    public String toString() {
        return "Sapatilha{" +
                ", marca='" + getMarca() + '\'' +
                ", tamanho=" + tamanho +
                ", temAtacadores=" + temAtacadores +
                ", cor='" + cor + '\'' +
                ", anoColecao=" + anoColecao +
                ", numeroDonos=" + numeroDonos +
                ", estadoUtilizacao=" + estadoUtilizacao +
                '}';
    }

    @Override
    public Sapatilha clone() {
        return new Sapatilha(this);
    }
}
