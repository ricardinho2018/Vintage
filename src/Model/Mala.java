package Model;

import java.util.Objects;

public class Mala extends Artigo {
    private double dimensao;
    private String material;
    private int anoColecao;

    // Construtor por omissão
    public Mala() {
        super(); // Chama o construtor por omissão da classe Artigo
        this.dimensao = 0.0;
        this.material = "";
        this.anoColecao = 0;
    }

    // Construtor por parâmetros
    public Mala(String codigo, String marca, String descricao, double precoBase, double correcaoPreco,
                double dimensao, String material, int anoColecao) {
        super(codigo, marca, descricao, precoBase, correcaoPreco);
        this.dimensao = dimensao;
        this.material = material;
        this.anoColecao = anoColecao;
    }

    // Construtor de cópia
    public Mala(Mala outraMala) {
        super(outraMala); // Chama o construtor de cópia da classe Artigo
        this.dimensao = outraMala.dimensao;
        this.material = outraMala.material;
        this.anoColecao = outraMala.anoColecao;
    }

    // Getters e Setters
    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mala)) return false;
        if (!super.equals(o)) return false;
        Mala mala = (Mala) o;
        return Double.compare(mala.dimensao, dimensao) == 0 &&
                anoColecao == mala.anoColecao &&
                Objects.equals(material, mala.material);
    }

    // Clone
    @Override
    public Mala clone() {
        return new Mala(this);
    }

    // ToString
    @Override
    public String toString() {
        return "Mala{" +
                "codigo='" + getCodigo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", precoBase=" + getPrecoBase() +
                ", correcaoPreco=" + getCorrecaoPreco() +
                ", dimensao=" + dimensao +
                ", material='" + material + '\'' +
                ", anoColecao=" + anoColecao +
                '}';
    }
}
