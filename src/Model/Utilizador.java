package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Utilizador implements Serializable {
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private String numFiscal;
    private ArrayList<Artigo> artigosAVenda;
    private ArrayList<Artigo> artigosVendidos;
    private ArrayList<Artigo> artigosAdquiridos;
    private double valorVendas;

    // Construtores
    public Utilizador() {
        // Construtor por omissão
    }

    public Utilizador(int codigo, String email, String nome, String morada, String numFiscal,
                      ArrayList<Artigo> artigosAVenda, ArrayList<Artigo> artigosVendidos,
                      ArrayList<Artigo> artigosAdquiridos, double valorVendas) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        this.artigosAVenda = artigosAVenda;
        this.artigosVendidos = artigosVendidos;
        this.artigosAdquiridos = artigosAdquiridos;
        this.valorVendas = valorVendas;
    }

    public Utilizador(Utilizador utilizador) {
        this.codigo = utilizador.codigo;
        this.email = utilizador.email;
        this.nome = utilizador.nome;
        this.morada = utilizador.morada;
        this.numFiscal = utilizador.numFiscal;
        this.artigosAVenda = new ArrayList<>(utilizador.artigosAVenda);
        this.artigosVendidos = new ArrayList<>(utilizador.artigosVendidos);
        this.artigosAdquiridos = new ArrayList<>(utilizador.artigosAdquiridos);
        this.valorVendas = utilizador.valorVendas;
    }

    // Métodos Getters
    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public String getNumFiscal() {
        return numFiscal;
    }

    public ArrayList<Artigo> getArtigosAVenda() {
        return artigosAVenda;
    }

    public ArrayList<Artigo> getArtigosVendidos() {
        return artigosVendidos;
    }

    public ArrayList<Artigo> getArtigosAdquiridos() {
        return artigosAdquiridos;
    }

    public double getValorVendas() {
        return valorVendas;
    }
    // Métodos Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumFiscal(String numFiscal) {
        this.numFiscal = numFiscal;
    }

    public void setArtigosAVenda(ArrayList<Artigo> artigosAVenda) {
        this.artigosAVenda = artigosAVenda;
    }

    public void setArtigosVendidos(ArrayList<Artigo> artigosVendidos) {
        this.artigosVendidos = artigosVendidos;
    }

    public void setArtigosAdquiridos(ArrayList<Artigo> artigosAdquiridos) {
        this.artigosAdquiridos = artigosAdquiridos;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    // Método clone
    @Override
    public Utilizador clone() {
        Utilizador clone = new Utilizador();
        clone.setCodigo(this.codigo);
        clone.setEmail(this.email);
        clone.setNome(this.nome);
        clone.setMorada(this.morada);
        clone.setNumFiscal(this.numFiscal);
        clone.setArtigosAVenda(new ArrayList<>(this.artigosAVenda));
        clone.setArtigosVendidos(new ArrayList<>(this.artigosVendidos));
        clone.setArtigosAdquiridos(new ArrayList<>(this.artigosAdquiridos));
        clone.setValorVendas(this.valorVendas);
        return clone;
    }

    // Método toString
    @Override
    public String toString() {
        return "Utilizador{" +
                "codigo=" + codigo +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", numFiscal='" + numFiscal + '\'' +
                ", artigosAVenda=" + artigosAVenda +
                ", artigosVendidos=" + artigosVendidos +
                ", artigosAdquiridos=" + artigosAdquiridos +
                ", valorVendas=" + valorVendas +
                '}';
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilizador)) return false;
        Utilizador that = (Utilizador) o;
        return getCodigo() == that.getCodigo() &&
                Double.compare(that.getValorVendas(), getValorVendas()) == 0 &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getMorada(), that.getMorada()) &&
                Objects.equals(getNumFiscal(), that.getNumFiscal()) &&
                Objects.equals(getArtigosAVenda(), that.getArtigosAVenda()) &&
                Objects.equals(getArtigosVendidos(), that.getArtigosVendidos()) &&
                Objects.equals(getArtigosAdquiridos(), that.getArtigosAdquiridos());
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getEmail(), getNome(), getMorada(), getNumFiscal(),
                getArtigosAVenda(), getArtigosVendidos(), getArtigosAdquiridos(), getValorVendas());
    }
}