package View;

import java.util.ArrayList;
import java.util.List;

public class Vista {

    private int nr_opcoes;
    private List<String> opcoes;

    public Vista(){
        this.nr_opcoes = 0;
        this.opcoes = new ArrayList<>();
    }

    public Vista(List<String> opcoes){
        this.nr_opcoes = 0;
        setOpcoes(opcoes);
    }

    public Vista(Vista v){
        this.nr_opcoes = v.getNr_opcoes();
        this.opcoes = v.getOpcoes();
    }


    public int getNr_opcoes() {
        return nr_opcoes;
    }

    public List<String> getOpcoes() { return opcoes; }
    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public void addLinha(String linha) throws LineAlreadyExists {
        if(this.opcoes.contains(linha)){
            throw new LineAlreadyExists(linha);
        }
        else{
            this.nr_opcoes++;
            this.opcoes.add(linha);
        }
    }
    public Vista clone(){
        return new Vista(this);
    }

    public void show(){
        for(String s : this.opcoes)
            System.out.println(s+"\n");
    }

}


