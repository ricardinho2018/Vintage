package Model;

import java.util.Objects;

public class Transportadora {
    private String nome;
    private double valorBasePequena;
    private double valorBaseMedia;
    private double valorBaseGrande;
    private double margemLucro;
    private double imposto;
    private boolean especializadaPremium;

    // Construtor por omissão
    public Transportadora() {
    }

    // Construtor parametrizado
    public Transportadora(String nome, double valorBasePequena, double valorBaseMedia, double valorBaseGrande,
                          double margemLucro, double imposto, boolean especializadaPremium) {
        this.nome = nome;
        this.valorBasePequena = valorBasePequena;
        this.valorBaseMedia = valorBaseMedia;
        this.valorBaseGrande = valorBaseGrande;
        this.margemLucro = margemLucro;
        this.imposto = imposto;
        this.especializadaPremium = especializadaPremium;
    }

    // Construtor de cópia
    public Transportadora(Transportadora other) {
        this.nome = other.nome;
        this.valorBasePequena = other.valorBasePequena;
        this.valorBaseMedia = other.valorBaseMedia;
        this.valorBaseGrande = other.valorBaseGrande;
        this.margemLucro = other.margemLucro;
        this.imposto = other.imposto;
        this.especializadaPremium = other.especializadaPremium;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getValorBasePequena() {
        return valorBasePequena;
    }

    public double getValorBaseMedia() {
        return valorBaseMedia;
    }

    public double getValorBaseGrande() {
        return valorBaseGrande;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public double getImposto() {
        return imposto;
    }

    public boolean isEspecializadaPremium() {
        return especializadaPremium;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorBasePequena(double valorBasePequena) {
        this.valorBasePequena = valorBasePequena;
    }

    public void setValorBaseMedia(double valorBaseMedia) {
        this.valorBaseMedia = valorBaseMedia;
    }

    public void setValorBaseGrande(double valorBaseGrande) {
        this.valorBaseGrande = valorBaseGrande;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setEspecializadaPremium(boolean especializadaPremium) {
        this.especializadaPremium = especializadaPremium;
    }


    // Métodos equals, clone e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transportadora)) return false;
        Transportadora that = (Transportadora) o;
        return Double.compare(that.valorBasePequena, valorBasePequena) == 0 &&
                Double.compare(that.valorBaseMedia, valorBaseMedia) == 0 &&
                Double.compare(that.valorBaseGrande, valorBaseGrande) == 0 &&
                Double.compare(that.margemLucro, margemLucro) == 0 &&
                Double.compare(that.imposto, imposto) == 0 &&
                especializadaPremium == that.especializadaPremium &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, valorBasePequena, valorBaseMedia, valorBaseGrande, margemLucro, imposto, especializadaPremium);
    }

    @Override
    public String toString() {
        return "Transportadora{" +
                "nome='" + nome + '\'' +
                ", valorBasePequena=" + valorBasePequena +
                ", valorBaseMedia=" + valorBaseMedia +
                ", valorBaseGrande=" + valorBaseGrande +
                ", margemLucro=" + margemLucro +
                ", imposto=" + imposto +
                ", especializadaPremium=" + especializadaPremium +
                '}';
    }

    @Override
    public Transportadora clone() {
        return new Transportadora(this);
    }
}
