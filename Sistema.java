package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Sistema {
    private String nomeUtilizador;
    private ArrayList<String> produtosComprados;
    private ArrayList<Double> precos;
    private String dataCompra;

    // Construtor por omissão
    public Sistema() {
        this.nomeUtilizador = "";
        this.produtosComprados = new ArrayList<String>();
        this.precos = new ArrayList<Double>();
        this.dataCompra = "";
    }

    // Construtor parametrizado
    public Sistema(String nomeUtilizador, ArrayList<String> produtosComprados, ArrayList<Double> precos, String dataCompra) {
        this.nomeUtilizador = nomeUtilizador;
        this.produtosComprados = produtosComprados;
        this.precos = precos;
        this.dataCompra = dataCompra;
    }



    public Sistema(String nomeUtilizador, String dataCompra) {
        this.nomeUtilizador = nomeUtilizador;
        this.produtosComprados = new ArrayList<String>();
        this.precos = new ArrayList<Double>();
        this.dataCompra = dataCompra;
    }

    public void addProduto(String produto, double preco) {
        this.produtosComprados.add(produto);
        this.precos.add(preco);
    }

    public String getNomeUtilizador() {
        return this.nomeUtilizador;
    }

    public ArrayList<String> getProdutosComprados() {
        return this.produtosComprados;
    }

    public ArrayList<Double> getPrecos() {
        return this.precos;
    }

    public String getDataCompra() {
        return this.dataCompra;
    }

    // Setter para o atributo nomeUtilizador
    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    // Setter para o atributo produtosComprados
    public void setProdutosComprados(ArrayList<String> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    // Setter para o atributo precos
    public void setPrecos(ArrayList<Double> precos) {
        this.precos = precos;
    }

    // Setter para o atributo dataCompra
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "nomeUtilizador='" + nomeUtilizador + '\'' +
                ", produtosComprados=" + produtosComprados +
                ", precos=" + precos +
                ", dataCompra=" + dataCompra +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sistema)) return false;
        Sistema sistema = (Sistema) o;
        return Objects.equals(nomeUtilizador, sistema.nomeUtilizador) &&
                Objects.equals(produtosComprados, sistema.produtosComprados) &&
                Objects.equals(precos, sistema.precos) &&
                Objects.equals(dataCompra, sistema.dataCompra);
    }

    // Método clone
    @Override
    public Sistema clone() {
        return new Sistema();
    }

}
