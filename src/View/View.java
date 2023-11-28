package View;

import Controler.Controler;
import Model.Model;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class View {

    private int opcao;
    private String menuAtual;
    private Map<String,Vista> opcoes;

    private Model model;
    private Controler controler;

    public View(Model model, Controler controler) {
        this.model = model;
        this.controler = controler;
        this.opcoes = new HashMap<>();
        this.opcao = 0;
        this.menuAtual = "MAIN MENU";
    }


    public Map<String,Vista> carregaMenus() throws LineAlreadyExists {
        return ParserVistas.parser();
    }

    private void showMenu(Vista v) {
        v.show();
    }

    public int leOpcao(){
        int op;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Opção: ");
        try{
            op = scanner.nextInt();
        } catch (InputMismatchException e){
            op = -3;
        }
       /*if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -3;
        }
        */

        return op;
    }

    public void run() throws LineAlreadyExists, ParseException, IOException {
        setOpcoes(carregaMenus());
        showMenu(this.opcoes.get("MAIN MENU"));
        this.menuAtual = "MAIN MENU";
        while(this.opcao != -1){
            this.opcao = leOpcao();
            int tamanho_menu = this.opcoes.get(getMenuAtual()).getNr_opcoes();

            if(getOpcao() == 1) {
                setMenuAtual("MENU1");
                showMenu(getOpcoes().get(getMenuAtual()));

                while (getOpcao() != -1) {
                    this.opcao = leOpcao();
                    if (getOpcao() > 0 && getOpcao() <= 7) {
                        controler.processa(getOpcao(), getMenuAtual());
                    } else if (getOpcao() == 0) {
                        setMenuAtual("MAIN MENU");
                        showMenu(getOpcoes().get(getMenuAtual()));
                        setOpcao(-3);
                    } //else
                       // System.out.println("Opção inválida!");
                }
            }
            else if(getOpcao() == 0) {
                this.opcao = -1;
            }
            else if(getOpcao() > 0 && getOpcao() <= tamanho_menu){
                controler.processa(getOpcao(),getMenuAtual());
            }
        }
    }

    public int getOpcao() {
        return this.opcao;
    }

    public String getMenuAtual() {
        return menuAtual;
    }

    public void setMenuAtual(String menuAtual) {
        this.menuAtual = menuAtual;
    }

    public void setOpcoes(Map<String, Vista> opcoes) {
        this.opcoes = opcoes;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public Map<String, Vista> getOpcoes() {
        Map<String,Vista> aux = new HashMap<>();
        for(Map.Entry<String,Vista> v : this.opcoes.entrySet())
            aux.put(v.getKey(),v.getValue().clone());
        return aux;
    }
}

