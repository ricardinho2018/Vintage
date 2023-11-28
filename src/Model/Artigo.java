package Model;


public abstract class Artigo  {
    private String codigo;
    private String marca;
    private String descricao;
    private double precoBase;
    private double correcaoPreco;

    // Construtor por omissão
    public Artigo() {
        this.codigo = "n/a";
        this.marca = "n/a";
        this.descricao = "n/a";
        this.precoBase = 0;
        this.correcaoPreco = 0;
    }



    // Construtor parametrizado
    public Artigo(String codigo, String marca, String descricao, double precoBase, double correcaoPreco) {
        this.codigo = codigo;
        this.marca = marca;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
    }

    // Construtor de cópia
    public Artigo(Artigo outroArtigo) {
        this.codigo = outroArtigo.codigo;
        this.marca = outroArtigo.marca;
        this.descricao = outroArtigo.descricao;
        this.precoBase = outroArtigo.precoBase;
        this.correcaoPreco = outroArtigo.correcaoPreco;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getCorrecaoPreco() {
        return correcaoPreco;
    }

    public void setCorrecaoPreco(double correcaoPreco) {
        this.correcaoPreco = correcaoPreco;
    }

    // Implementação dos métodos equals e toString
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Artigo)) {
            return false;
        }
        Artigo outroArtigo = (Artigo) obj;
        return codigo.equals(outroArtigo.codigo) &&
                marca.equals(outroArtigo.marca) &&
                descricao.equals(outroArtigo.descricao) &&
                precoBase == outroArtigo.precoBase &&
                correcaoPreco == outroArtigo.correcaoPreco;
    }


    @Override
    public String toString() {
        return "Artigo{" +
                "codigo='" + codigo + '\'' +
                ", marca='" + marca + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoBase=" + precoBase +
                ", correcaoPreco=" + correcaoPreco +
                '}';
    }
}
