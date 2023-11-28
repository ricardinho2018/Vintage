package Model;

public class Tempo {
    private int dia;
    private int mes;
    private int ano;

    public Tempo(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void avancarDia() {
        this.dia++;
        if (this.dia > 31) {
            this.dia = 1;
            this.mes++;
        }
        if (this.mes > 12) {
            this.mes = 1;
            this.ano++;
        }
    }

    public String toString() {
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
