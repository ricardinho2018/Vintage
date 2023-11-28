package Model;

import java.util.ArrayList;
import java.util.Date;

public class Encomenda {
    private ArrayList<Artigo> artigos;
    private String dimensao;
    private double precoFinal;
    private double taxaSatisfacaoNovo;
    private double taxaSatisfacaoUsado;
    private double custoExpedicao;
    private String estado;
    private String dataCriacao;
    private double imposto;

    // Construtor por omissão
    public Encomenda() {

    }


    // Construtor parametrizado
    public Encomenda(Sistema sistema, String dataCriacao) {
        this.artigos = artigos;
        this.dimensao = dimensao;
        this.precoFinal = precoFinal;
        this.taxaSatisfacaoNovo = taxaSatisfacaoNovo;
        this.taxaSatisfacaoUsado = taxaSatisfacaoUsado;
        this.custoExpedicao = custoExpedicao;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.imposto = imposto;
    }

    // Construtor de cópia
    public Encomenda(Encomenda outraEncomenda) {
        this.artigos = new ArrayList<>(outraEncomenda.artigos);
        this.dimensao = outraEncomenda.dimensao;
        this.precoFinal = outraEncomenda.precoFinal;
        this.taxaSatisfacaoNovo = outraEncomenda.taxaSatisfacaoNovo;
        this.taxaSatisfacaoUsado = outraEncomenda.taxaSatisfacaoUsado;
        this.custoExpedicao = outraEncomenda.custoExpedicao;
        this.estado = outraEncomenda.estado;
        this.dataCriacao = outraEncomenda.dataCriacao;
        this.imposto = outraEncomenda.imposto;
    }

    // Getters e Setters
    public ArrayList<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(ArrayList<Artigo> artigos) {
        this.artigos = artigos;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public double getTaxaSatisfacaoNovo() {
        return taxaSatisfacaoNovo;
    }

    public void setTaxaSatisfacaoNovo(double taxaSatisfacaoNovo) {
        this.taxaSatisfacaoNovo = taxaSatisfacaoNovo;
    }

    public double getTaxaSatisfacaoUsado() {
        return taxaSatisfacaoUsado;
    }

    public void setTaxaSatisfacaoUsado(double taxaSatisfacaoUsado) {
        this.taxaSatisfacaoUsado = taxaSatisfacaoUsado;
    }

    // Getters e Setters (continuação)
    public double getCustoExpedicao() {
        return custoExpedicao;
    }

    public void setCustoExpedicao(double custoExpedicao) {
        this.custoExpedicao = custoExpedicao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }



    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encomenda)) return false;

        Encomenda encomenda = (Encomenda) o;

        if (Double.compare(encomenda.precoFinal, precoFinal) != 0) return false;
        if (Double.compare(encomenda.taxaSatisfacaoNovo, taxaSatisfacaoNovo) != 0) return false;
        if (Double.compare(encomenda.taxaSatisfacaoUsado, taxaSatisfacaoUsado) != 0) return false;
        if (Double.compare(encomenda.custoExpedicao, custoExpedicao) != 0) return false;
        if (Double.compare(encomenda.imposto, imposto) != 0) return false;
        if (!artigos.equals(encomenda.artigos)) return false;
        if (!dimensao.equals(encomenda.dimensao)) return false;
        if (!estado.equals(encomenda.estado)) return false;
        return dataCriacao.equals(encomenda.dataCriacao);
    }

    // Método clone
    @Override
    public Encomenda clone() {
        return new Encomenda(this);
    }

    // Método toString
    @Override
    public String toString() {
        return "Encomenda{" +
                "artigos=" + artigos +
                ", dimensao='" + dimensao + '\'' +
                ", precoFinal=" + precoFinal +
                ", taxaSatisfacaoNovo=" + taxaSatisfacaoNovo +
                ", taxaSatisfacaoUsado=" + taxaSatisfacaoUsado +
                ", custoExpedicao=" + custoExpedicao +
                ", estado='" + estado + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", imposto=" + imposto +
                '}';
    }
}
