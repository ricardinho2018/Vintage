package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Model implements Serializable {

    public static Fatura fatura;
    public static Encomenda encomenda;
    public int quantidadeProduto;
    private List<Utilizador> utilizadores;
    private List<Transportadora> transportadoras;
    private List<Artigo> artigos;
    private List<Fatura> faturas;
    private List<Encomenda> encomendas ;
    private double dimensao; // dimensão da mala em centímetros
    private double preco; // preço da mala em reais



    public Model() {
        this.utilizadores = new ArrayList<>();
         this.transportadoras = new ArrayList<>();
         this.artigos = new ArrayList<>();
        this.faturas = new ArrayList<>();
        this.encomendas = new ArrayList<>();
    }
    public Model(List<Utilizador> utilizadores,List<Transportadora> transportadoras,List<Artigo> artigos,List<Fatura> faturas,List<Encomenda> encomendas) {
        this.utilizadores = utilizadores;
         this.transportadoras= transportadoras;
         this.artigos = artigos;
         this.faturas = faturas;
         this.encomendas = encomendas;
    }

    public Model(Model m){

        this.utilizadores =  m.getUtilizadores();
        this.transportadoras = m.getTransportadoras();
        this.artigos = m.getArtigos();
        this.faturas = m.getFaturas();
        this.encomendas = m.getEncomendas();
    }
    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public List<Transportadora> getTransportadoras() {
        return transportadoras;
    }

    public void setTransportadoras(List<Transportadora> transportadoras) {
        this.transportadoras = transportadoras;
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public List<Fatura> getFaturas() {
        return faturas;
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public double getDimensao() {
        return dimensao;
    }

    public double getPreco() {
        return preco;
    }

    public double calcularDesconto() {
        double desconto;
        if (dimensao > 60.0) {
            desconto = preco * 0.1;
        } else {
            desconto = preco * 0.05;
        }
        return desconto;
    }

    public double getPrecoComDesconto() {
        return preco - calcularDesconto();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return Objects.equals(utilizadores, model.utilizadores) &&
                Objects.equals(transportadoras, model.transportadoras) &&
                Objects.equals(artigos, model.artigos) &&
                Objects.equals(faturas, model.faturas) &&
                Objects.equals(encomendas, model.encomendas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilizadores, transportadoras, artigos, faturas, encomendas);
    }

    @Override
    public String toString() {
        return "Model{" +
                "utilizadores=" + utilizadores +
                ", transportadoras=" + transportadoras +
                ", artigos=" + artigos +
                ", faturas=" + faturas +
                ", encomendas=" + encomendas +
                '}';
    }

    @Override
    public Model clone() {
        try {
            Model model = (Model) super.clone();
            // Realizar clonagem profunda de listas
            model.utilizadores = utilizadores != null ? List.copyOf(utilizadores) : null;
            model.transportadoras = transportadoras != null ? List.copyOf(transportadoras) : null;
            model.artigos = artigos != null ? List.copyOf(artigos) : null;
            model.faturas = faturas != null ? List.copyOf(faturas) : null;
            model.encomendas = encomendas != null ? List.copyOf(encomendas) : null;
            return model;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    public void decreaseStock(String nomeProduto, int quantidadeProduto) {

    }

    public int getStock(int nomeProduto) {
        return quantidadeProduto;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setValorizacaoAnual(double valorizacaoAnual) {

    }

    public void setTipoMala(String premium) {

    }

    public void setPrecoNovo(double precoNovo) {

    }
}


