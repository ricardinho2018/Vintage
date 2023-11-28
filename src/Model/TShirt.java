package Model;

public class TShirt extends Artigo {
    private String tamanho;
    private String padrao;

    // Construtores
    public TShirt() {
       super();
        // Construtor por omissão
    }

    public TShirt(String referencia, String descricao, double preco, String tamanho, String padrao) {
        super();
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt(TShirt tshirt) {
        super(tshirt);
        this.tamanho = tshirt.tamanho;
        this.padrao = tshirt.padrao;
    }

    // Métodos Getters
    public String getTamanho() {
        return tamanho;
    }

    public String getPadrao() {
        return padrao;
    }

    // Métodos Setters
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

    // Equals
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof TShirt)) {
            return false;
        }

        TShirt other = (TShirt) obj;

        return super.equals(obj) &&
                this.tamanho.equals(other.tamanho) &&
                this.padrao.equals(other.padrao);
    }

    // Clone
    @Override
    public TShirt clone() {
        return new TShirt(this);
    }

    // ToString
    @Override
    public String toString() {
        return "TShirt{" +
                ", descricao='" + getDescricao() + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", padrao='" + padrao + '\'' +
                '}';
    }
}

