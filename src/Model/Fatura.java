package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class Fatura {
    private Calendar calendar;
    private String descricao;
    private double valor;
    private LocalDate dataVencimento;
    private double taxaDiaria;
    private int diasTrabalhados;
    private Sistema sistema;
    private String dataFatura;


    // Construtor por omissão


    // Construtor parametrizado
    public Fatura(Sistema sistema, String dataFatura) {
        this.calendar = calendar;
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.taxaDiaria = taxaDiaria;
        this.diasTrabalhados = diasTrabalhados;
        this.sistema = sistema;
        this.dataFatura = dataFatura;
    }

    // Construtor de cópia
    public Fatura(Fatura outraFatura) {
        this.calendar = outraFatura.calendar;
        this.descricao = outraFatura.descricao;
        this.valor = outraFatura.valor;
        this.dataVencimento = outraFatura.dataVencimento;
        this.taxaDiaria = outraFatura.taxaDiaria;
        this.diasTrabalhados = outraFatura.diasTrabalhados;
    }

    // Getters e Setters
    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getTaxaDiaria() {
        return taxaDiaria;
    }

    public void setTaxaDiaria(double taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public void gerarFatura() {
        double total = 0;
        ArrayList<String> produtos = sistema.getProdutosComprados();
        ArrayList<Double> precos = sistema.getPrecos();

        System.out.println("Fatura para " + sistema.getNomeUtilizador() + ":");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i) + "\t" + precos.get(i));
            total += precos.get(i);
        }
        System.out.println("Total: " + total);
        System.out.println("Data da compra: " + sistema.getDataCompra());
        System.out.println("Data da fatura: " + dataFatura);
    }



    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fatura)) return false;

        Fatura fatura = (Fatura) o;

        if (Double.compare(fatura.valor, valor) != 0) return false;
        if (Double.compare(fatura.taxaDiaria, taxaDiaria) != 0) return false;
        if (diasTrabalhados != fatura.diasTrabalhados) return false;
        if (!calendar.equals(fatura.calendar)) return false;
        if (!descricao.equals(fatura.descricao)) return false;
        return dataVencimento.equals(fatura.dataVencimento);
    }

    // Método clone
    @Override
    public Fatura clone() {
        return new Fatura(this);
    }

    // Método toString
    @Override
    public String toString() {
        return "Fatura{" +
                "calendar=" + calendar +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", dataVencimento=" + dataVencimento +
                ", taxaDiaria=" + taxaDiaria +
                ", diasTrabalhados=" + diasTrabalhados +
                '}';
    }}
