package Controler;


import java.io.IOException;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.time.LocalDate;
import java.util.Calendar;
import Model.*;
import java.util.HashMap;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.Scanner;




public  class Controler {

    private int op;
    private Model model;
    private Fatura fatura;
    private LocalDate data;
    private Encomenda encomenda;
    private double taxaDiaria;
    private int diasTrabalhados;
    private int ano;
    private int mes;
    private int dia;
    private int donos ;
    private double desconto ;
    private double precoComDesconto ;
    private double preco_10 ;
    private double precoBase ;
    private double taxaSatisfacaoNovo = 0.5;
    private double taxaSatisfacaoUsado = 0.25;
    private double precoExpedicao;
    Calendar calendar = Calendar.getInstance();
    private Map<String, Double> vendedoresFaturamento;
    private String args;
    private  Map<String, Utilizador> utilizadores = new HashMap<>(); // Mapa para armazenar os utilizadores

    public Controler() {
        vendedoresFaturamento = new HashMap<>();
    }

    private Sistema sistema;
    private Tempo tempo;





        public Controler(double taxaDiaria, int diasTrabalhados, int ano, int mes, int dia, int donos, double desconto, double precoComDesconto, double preco_10, double precoBase, double taxaSatisfacaoNovo, double taxaSatisfacaoUsado, double precoExpedicao) {
            this.taxaDiaria = taxaDiaria;
            this.diasTrabalhados = diasTrabalhados;
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
            this.donos = donos;
            this.desconto = desconto;
            this.precoComDesconto = precoComDesconto;
            this.preco_10 = preco_10;
            this.precoBase = precoBase;
            this.taxaSatisfacaoNovo = taxaSatisfacaoNovo;
            this.taxaSatisfacaoUsado = taxaSatisfacaoUsado;
            this.precoExpedicao = precoExpedicao;
        }

        public Controler(Controler controler) {
            this.taxaDiaria = controler.taxaDiaria;
            this.diasTrabalhados = controler.diasTrabalhados;
            this.ano = controler.ano;
            this.mes = controler.mes;
            this.dia = controler.dia;
            this.donos = controler.donos;
            this.desconto = controler.desconto;
            this.precoComDesconto = controler.precoComDesconto;
            this.preco_10 = controler.preco_10;
            this.precoBase = controler.precoBase;
            this.taxaSatisfacaoNovo = controler.taxaSatisfacaoNovo;
            this.taxaSatisfacaoUsado = controler.taxaSatisfacaoUsado;
            this.precoExpedicao = controler.precoExpedicao;
        }

        // Getters e Setters
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

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public int getDia() {
            return dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
        }

        public int getDonos() {
            return donos;
        }

    public void setDonos(int donos) {
        this.donos = donos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public void setPrecoComDesconto(double precoComDesconto) {
        this.precoComDesconto = precoComDesconto;
    }

    public double getPreco_10() {
        return preco_10;
    }

    public void setPreco_10(double preco_10) {
        this.preco_10 = preco_10;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getTaxaSatisfacaoNovo() {
        return taxaSatisfacaoNovo;
    }

    public void setTaxaSatisfacaoNovo(double taxaSatisfacaoNovo) {
        this.taxaSatisfacaoNovo = taxaSatisfacaoNovo;
    }

    public double getTaxaSatisfacaoUsado() {
        return taxaSatisfacaoUsado;
    }

    public void setTaxaSatisfacaoUsado(double taxaSatisfacaoUsado) {
        this.taxaSatisfacaoUsado = taxaSatisfacaoUsado;
    }

    public double getPrecoExpedicao() {
        return precoExpedicao;
    }

    public void setPrecoExpedicao(double precoExpedicao) {
        this.precoExpedicao = precoExpedicao;
    }




        public Controler(Model model) {
        this.model = model;
        this.op = 0;
    }

    public Model getModel() {
        return model;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public void setModel(Model model) {
        this.model = model;
    }




    public void processa(int op, String menu) {
        setOp(op);
        if (menu.equals("MAIN MENU")) {


            switch (getOp()) {
                case (2):
                    String nomeArquivo = "dados.txt"; // Nome do arquivo de texto
                    String vendedorDesejado = "Ana Oliveira"; // Nome do vendedor desejado

                    // Lista para armazenar as encomendas do vendedor
                    List<String> encomendasPorVendedor = new ArrayList<>();

                    try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            // Separar os campos da linha pelo caractere ","
                            String[] campos = linha.split(",");

                            // Verificar se há pelo menos 5 campos na linha
                            if (campos.length >= 6) {
                                // Extrair os dados da linha
                                String dataString = campos[0].trim();
                                String nome1 = campos[1].trim();
                                String nome2 = campos[2].trim();
                                String transportadora = campos[3].trim();
                                String artigo = campos[4].trim();
                                double valor = Double.parseDouble(campos[5].trim());

                                // Verificar se o vendedor é o desejado
                                if (nome1.equals(vendedorDesejado) || nome2.equals(vendedorDesejado)) {
                                    // Montar a string da encomenda
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    String encomenda = String.format("Data: %s, Vendedor 1: %s, Vendedor 2: %s, Transportadora: %s, Artigo %s, Valor:  %.2f",
                                            dataString, nome1, nome2, transportadora,artigo, valor);
                                    encomendasPorVendedor.add(encomenda);
                                }
                            }
                        }

                        // Exibir as encomendas do vendedor
                        if (!encomendasPorVendedor.isEmpty()) {
                            System.out.println("Encomendas emitidas por " + vendedorDesejado + ":");
                            for (String encomenda : encomendasPorVendedor) {
                                System.out.println(encomenda);
                            }
                        } else {
                            System.out.println("Nenhuma encomenda encontrada para o vendedor " + vendedorDesejado);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }

            switch (getOp()) {
                case (3):

                    String fileName = "dados.txt"; // Atualize com o caminho correto para o arquivo txt
                    Map<String, Double> compradores = new HashMap<>();
                    Map<String, Double> vendedores = new HashMap<>();
                    double totalGanho = 0.0; // Variável para armazenar o total ganho

                    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                        String line;
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        while ((line = br.readLine()) != null) {
                            String[] data = line.split(",");
                            if (data.length == 6) {
                                String dataStr = data[0].trim();
                                String comprador = data[1].trim();
                                String vendedor = data[2].trim();
                                String transportadora = data[3].trim();
                                String artigo = data[4].trim();
                                double valor = Double.parseDouble(data[5].trim());

                                // Verifica se a data está corretamente formatada
                                try {
                                    Date date = sdf.parse(dataStr);
                                    // Atualiza os mapas de compradores e vendedores
                                    if (compradores.containsKey(comprador)) {
                                        compradores.put(comprador, compradores.get(comprador) + valor);
                                    } else {
                                        compradores.put(comprador, valor);
                                    }

                                    if (vendedores.containsKey(vendedor)) {
                                        vendedores.put(vendedor, vendedores.get(vendedor) + valor);
                                    } else {
                                        vendedores.put(vendedor, valor);
                                    }

                                    totalGanho += valor; // Atualiza o total ganho

                                } catch (ParseException e) {
                                    System.out.println("Data inválida: " + dataStr);
                                }
                            }
                        }

                        System.out.println("Total Ganho:  " + totalGanho); // Imprime o total ganho

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

            switch (getOp()) {
                case (4):

                    Scanner scanner_39 = new Scanner(System.in);
                    System.out.println("Digite o nome do produto:");
                    String nomeProduto = scanner_39.nextLine();
                    System.out.println("Digite o preço do produto:");
                    double precoProduto = scanner_39.nextDouble();
                    System.out.println("Tempo avançado para ");
                    System.out.println("Digite a data da fatura (formato dd/mm/aaaa):");
                    String dataFaturaStr = scanner_39.next();
                    // Vai para a data desejada
                    String data_15 = scanner_39.nextLine();
                    model.getFaturas();
                    calendar.set(Calendar.YEAR, ano);
                    calendar.set(Calendar.MONTH, mes);
                    calendar.set(Calendar.DAY_OF_MONTH, dia);
                    System.out.println("Digite a quantidade do produto:");
                    int quantidadeProduto = scanner_39.nextInt();
                    scanner_39.nextLine(); // consume the remaining newline character
                    model.decreaseStock(nomeProduto, quantidadeProduto);
                    quantidadeProduto = quantidadeProduto - 1;
                    System.out.println("Produto adicionado.");
                    System.out.println("Stock atualizado: " + quantidadeProduto);

                    String line;
                    try (FileWriter writer = new FileWriter("faturas.txt", true)) {
                        do {
                            line = scanner_39.nextLine();
                            writer.write("Fatura:");
                            writer.write("  Descriçao:" + nomeProduto);
                            writer.write("  Valor:" + precoProduto);
                            writer.write("  Data de vecimento:" + dataFaturaStr);
                            writer.write("  Encomenda:");
                            writer.write("  Descriçao:" + nomeProduto);
                            writer.write("  Valor:" + precoProduto);
                            writer.write("  Data :" + dataFaturaStr);
                            writer.write(line + "\n");
                        } while (!line.isEmpty());
                        System.out.println("Os dados foram gravados com sucesso no arquivo faturas.txt.");
                    } catch (IOException e) {
                        System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
                    }

                    break;

            }
        }

       else if (menu.equals("MENU1")) {
            Scanner sc = new Scanner(System.in);
            System.out.println(menu);
            Utilizador j = null;


            switch (getOp()) {
                case (1): //utilizador


                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Email (que será o login): ");
                    String emailLogin = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira o nome: ");
                    String nome = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira a morada: ");
                    String morada = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira o numero fiscal: ");
                    String numFiscal = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira artigos à venda: ");
                    String artigosAVenda = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira artigos vendidos: ");
                    String artigosVendidos = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira artigos adquiridos: ");
                    String artigosAdquiridos = scanner.nextLine();
                    model.getUtilizadores();
                    System.out.println("Insira valor das vendas: ");
                    String valorVendas = scanner.nextLine();
                    model.getUtilizadores();


                    try {
                        FileOutputStream arquivo = new FileOutputStream("dados.bin", true);
                        ObjectOutputStream objetoOutput = new ObjectOutputStream(arquivo);
                        UUID codigoUtilizador = UUID.randomUUID();
                        objetoOutput.writeObject(codigoUtilizador);
                        objetoOutput.writeObject(emailLogin);
                        objetoOutput.writeObject(nome);
                        objetoOutput.writeObject(morada);
                        objetoOutput.writeObject(numFiscal);
                        objetoOutput.writeObject(artigosAVenda);
                        objetoOutput.writeObject(artigosVendidos);
                        objetoOutput.writeObject(artigosAdquiridos);
                        objetoOutput.writeObject(valorVendas);
                        objetoOutput.close();
                        arquivo.close();

                        System.out.println("Os dados foram gravados com sucesso no arquivo dados.bin.");
                    } catch (IOException e) {
                        System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
                    }

                    Utilizador utilizadorLogin = utilizadores.get(emailLogin);

                        // Lógica para verificar a senha do utilizador (não implementado neste exemplo)

                        System.out.println("Login efetuado com sucesso para o utilizador com email: " + emailLogin);


                    }
                    switch (getOp()) {
                        case (2): // Adicionar Encomenda
                            Scanner scanner_0 = new Scanner(System.in);
                            System.out.println("Insira nome do produto:");
                            String artigo = scanner_0.nextLine();
                            System.out.println("Insira dimensão do produto:");
                            String dimensao = scanner_0.nextLine();
                            System.out.println("Insira data da encomenda:");
                            String data = scanner_0.nextLine();
                            System.out.println("Insira preço base do produto:");
                            double precoBase = Double.parseDouble(scanner_0.nextLine());
                            System.out.println("Insira ano de coleção do produto:");
                            int anoColecao = Integer.parseInt(scanner_0.nextLine());
                            System.out.println("O produto é novo, usado ou premium? (digite 'n' para novo, 'u' para usado ou 'p' para premium):");
                            String tipoProduto = scanner_0.nextLine();
                            double valorizacao_anual = 0.0;
                            if (tipoProduto.equals("p")) {
                                System.out.println("Insira a valorização anual do produto premium (em %):");
                                valorizacao_anual = scanner_0.nextDouble() / 100.0;
                            } else if (tipoProduto.equals("u")) {
                                System.out.println("Insira o preço do produto quando novo:");
                                double precoNovo = scanner_0.nextDouble();
                                valorizacao_anual = (precoBase - precoNovo) / precoNovo;
                                precoBase = precoNovo;
                            }
                            System.out.println("Insira custo de expedição:");
                            double custoExpedicao =scanner_0.nextDouble();
                            System.out.println("Insira imposto:");
                            double imposto = scanner_0.nextDouble();

                            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
                            double precoFinal = precoBase + valorizacao_anual * (anoAtual - anoColecao);
                            double precoTotal = precoFinal + custoExpedicao + imposto;

                            Encomenda minhaEncomenda = new Encomenda();
// faça os cálculos para determinar o preço final e atribua ao atributo precoFinal da minhaEncomenda

                            System.out.println("Preço final da encomenda: " + precoTotal);


                            try {
                                FileOutputStream arquivo = new FileOutputStream("dados.bin", true);
                                ObjectOutputStream objetoOutput = new ObjectOutputStream(arquivo);
                                objetoOutput.writeObject(artigo);
                                objetoOutput.writeObject(dimensao);
                                objetoOutput.writeObject(data);
                                objetoOutput.writeObject(precoBase);
                                objetoOutput.writeObject(custoExpedicao);
                                objetoOutput.writeObject(imposto);
                                objetoOutput.writeObject(precoTotal);
                                objetoOutput.close();
                                arquivo.close();
                                System.out.println("Os dados foram gravados com sucesso no arquivo dados.bin.");
                            } catch (IOException e) {
                                System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
                            }


                            break;
                    }

                    switch (getOp()) {
                        case (3):// Criar transportadora
                            Scanner scanner_1 = new Scanner(System.in);
                            System.out.println("Insira nome da transpotadora:");
                            String nome_1 = sc.nextLine();
                            model.getTransportadoras();
                            System.out.println("Insira valor base pequena:");
                            String valor = sc.nextLine();
                            model.getTransportadoras();
                            System.out.println("Insira valor base media:");
                            String valor_1 = sc.nextLine();
                            model.getTransportadoras();
                            System.out.println("Insira valor base grande:");
                            String valor_2 = sc.nextLine();
                            model.getTransportadoras();
                            System.out.println("Insira margem de lucro:");
                            int lucro = sc.nextInt();
                            model.getTransportadoras();
                            String lucro_20 = sc.nextLine();
                            System.out.println("Insira imposto:");
                            int imposto = sc.nextInt();
                            model.getTransportadoras();
                            String imposto_12 = sc.nextLine();
                            System.out.println("Insira valor base :");
                            int valorBase = sc.nextInt();
                            model.getTransportadoras();
                            String valorBase_31 = sc.nextLine();
                            System.out.println("Insira especialização Premium :");
                            String premium = sc.nextLine();
                            model.getTransportadoras();
                             precoExpedicao = (valorBase * lucro * (1+imposto))*0.9;
                            System.out.println("Preço final: " + precoExpedicao);


                            try {
                                FileOutputStream arquivo = new FileOutputStream("dados.bin", true);
                                ObjectOutputStream objetoOutput = new ObjectOutputStream(arquivo);
                                objetoOutput.writeObject(nome_1);
                                objetoOutput.writeObject(valor);
                                objetoOutput.writeObject(valor_1);
                                objetoOutput.writeObject(valor_2);
                                objetoOutput.writeObject(lucro);
                                objetoOutput.writeObject(lucro_20);
                                objetoOutput.writeObject(imposto);
                                objetoOutput.writeObject(imposto_12);
                                objetoOutput.writeObject(valorBase);
                                objetoOutput.writeObject(valorBase_31);
                                objetoOutput.writeObject(premium);
                                objetoOutput.close();
                                arquivo.close();
                                System.out.println("Os dados foram gravados com sucesso no arquivo dados.bin.");
                            } catch (IOException e) {
                                System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
                            }


                            break;
                    }

                    switch (getOp()) {
                        case (4):// Criar Artigo
                            Scanner scanner_2 = new Scanner(System.in);
                            System.out.println("Se não quiser criar um ao dois artigos por exemplo mala insira zero em todos os itens:");
                            System.out.println("Insira mala:");
                            System.out.println("Insira dimensão (em cm):");
                            double dimensao = Double.parseDouble(scanner_2.nextLine());
                            System.out.println("Insira preço:");
                            double preco_base = Double.parseDouble(scanner_2.nextLine());
                            System.out.println("Insira ano de coleção:");
                            int ano_colecao = Integer.parseInt(scanner_2.nextLine());
                            System.out.println("A mala é nova, usada ou premium? (digite 'n' para nova, 'u' para usada ou 'p' para premium):");
                            String tipoMala = scanner_2.nextLine();
                            double valorizacao_anual = 0.0;
                            double desconto_proporcional = 0.0;
                            if (tipoMala.equals("p")) {
                                System.out.println("Insira a valorização anual da mala premium (em %):");
                                valorizacao_anual = scanner_2.nextDouble() / 100.0;
                            } else if (tipoMala.equals("u")) {
                                System.out.println("Insira o preço da mala quando nova:");
                                double precoNovo = scanner_2.nextDouble();
                                valorizacao_anual = (preco_base - precoNovo) / precoNovo;
                                preco_base = precoNovo;
                                System.out.println("Insira a percentagem de desconto proporcional à dimensão da mala (em %):");
                                desconto_proporcional = scanner_2.nextDouble() / 100.0;
                            }
                            int ano_atual = Calendar.getInstance().get(Calendar.YEAR);
                            double preco_final = preco_base;
                            if (tipoMala.equals("u")) {
                                preco_final = preco_final * (1 - desconto_proporcional * dimensao);
                            } else if (tipoMala.equals("p")) {
                                preco_final = preco_final * (1 + valorizacao_anual);
                            }
                            System.out.println("Preço final da mala: " + preco_final);



                            System.out.println("Insira sapatilha:");
                            System.out.println("Insira tamanho:");
                            int tamanho = sc.nextInt();
                            model.getArtigos();
                            System.out.println("Insira preço Base:");
                            double  precoBase = sc.nextInt();
                            String precoBase_10 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira se tem atacadores:");
                            String atacadores = sc.nextLine();
                            String atacadores_10 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira cor:");
                            String cor = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira ano de coleção:");
                            String colecao_1 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira numero de donos:");
                            int donos = sc.nextInt();
                            String donos_10 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira estado de utilização(de 1 a 10):");
                            int utilizacao = sc.nextInt();
                            model.getArtigos();
                            String utilizacao_11 = sc.nextLine();
                            System.out.println("A sapatilha é nova, usada ou premium?");
                            String estado = sc.nextLine();

                            if (estado.equalsIgnoreCase("nova")) {
                                // Cálculo do preço para sapatilha nova
                                if (tamanho > 45) {
                                    precoBase *= 0.9; // Decréscimo de 10% para sapatilhas novas acima do tamanho 45
                                }
                            } else if (estado.equalsIgnoreCase("usada")) {
                                // Cálculo do preço para sapatilha usada
                                if (!colecao_1.equals("2023")) {
                                    double desconto = precoBase / donos * utilizacao;
                                    precoBase -= desconto; // Aplicação de desconto para sapatilhas usadas que não sejam da coleção atual
                                }
                            } else if (estado.equalsIgnoreCase("premium")) {
                                // Cálculo do preço para sapatilha premium
                                precoBase *= 1.2; // Acréscimo de 20% para sapatilhas premium
                            }

// Exibir o preço final calculado
                            System.out.println("Preço final: " + precoBase);

                            System.out.println("Insira T-Shirt:");
                            System.out.println("Insira tamanho:");
                            String tamanho_2 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira padrão:");
                            String padrao_2 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira preço:");
                            double preco_102 = sc.nextInt();
                            String preco_202 = sc.nextLine();
                            model.getArtigos();
                            System.out.println("Insira estado de utilização (nova/usada/premium):");
                            String estado_2 = sc.nextLine();
                            model.getArtigos();

                            double precoFinal = preco_102;
                            if (!padrao_2.equals("liso") && estado_2.equals("usada")) {
                                precoFinal *= 0.5; // desconto de 50% se não for liso e for usada
                            } else if (estado_2.equals("premium")) {
                                precoFinal *= 1.2; // acréscimo de 20% para premium
                            }

                            if (estado_2.equals("usada") || estado_2.equals("premium")) {
                                System.out.println("Insira preço base original:");
                                double precoBaseOriginal = sc.nextDouble();
                                String precoBaseOriginal_10 = sc.nextLine();
                                if (precoBaseOriginal > precoFinal) {
                                    System.out.println("Insira o desconto (em %):");
                                    double desconto = sc.nextDouble();
                                    String desconto_10 = sc.nextLine();
                                    precoFinal = precoBaseOriginal * (1 - desconto/100);
                                }
                            }
                            precoBase =  precoBase -(precoBase/donos*utilizacao );
                            System.out.println("Preço final das sapatilhas: " + precoFinal);



                            try {
                                FileOutputStream arquivo = new FileOutputStream("dados.bin", true);
                                ObjectOutputStream objetoOutput = new ObjectOutputStream(arquivo);
                                objetoOutput.writeObject(dimensao);
                                objetoOutput.writeObject(preco_base);
                                objetoOutput.writeObject(ano_colecao);
                                objetoOutput.writeObject(preco_final);
                                objetoOutput.writeObject(tamanho);
                                objetoOutput.writeObject(precoBase);
                                objetoOutput.writeObject(atacadores);
                                objetoOutput.writeObject(cor);
                                objetoOutput.writeObject(colecao_1);
                                objetoOutput.writeObject(donos);
                                objetoOutput.writeObject(utilizacao);
                                objetoOutput.writeObject(tamanho_2);
                                objetoOutput.writeObject(padrao_2);
                                objetoOutput.writeObject(preco_102);
                                objetoOutput.writeObject(estado_2);
                                objetoOutput.writeObject(precoFinal);
                                objetoOutput.close();
                                arquivo.close();
                                System.out.println("Os dados foram gravados com sucesso no arquivo dados.bin.");
                            } catch (IOException e) {
                                System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
                            }


                            break;
                    }
                    switch (getOp()) {
                        case (5):   // Criação de uma nova fatura
                            Scanner scanner_3 = new Scanner(System.in);
                            System.out.println("Insira descrição:");
                            String descricao = sc.nextLine();
                            model.getFaturas();
                            System.out.println("Insira valor:");
                            String valor = sc.nextLine();
                            model.getFaturas();
                            System.out.println("Data atual: ");
                            String data_1 = sc.nextLine();
                            model.getFaturas();



                            String line;
                            try (FileWriter writer = new FileWriter("faturas.txt", true)) {
                                do {
                                    line = scanner_3.nextLine();
                                    writer.write("Fatura:");
                                    writer.write("  Descriçao:" + descricao);
                                    writer.write("  Valor:" + valor);
                                    writer.write("  Data de vecimento:" + data_1);
                                    writer.write(line + "\n");
                                } while (!line.isEmpty());
                                System.out.println("Os dados foram gravados com sucesso no arquivo faturas.txt.");
                            } catch (IOException e) {
                                System.err.println("Erro ao gravar dados no arquivo: " + e.getMessage());
                            }


                            break;

                    }
                {
                    switch (getOp()) {

                        case 6:
                            String nomeArquivo = "dados.txt"; // Nome do arquivo de texto
                            String dataInicio = "01/01/2021"; // Data de início do período desejado
                            String dataFim = "10/01/2021"; // Data de fim do período desejado

                            // Mapa para armazenar o faturamento de cada vendedor
                            Map<String, Double> faturamentoPorVendedor = new HashMap<>();

                            try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
                                String linha;
                                while ((linha = br.readLine()) != null) {
                                    // Separar os campos da linha pelo caractere ","
                                    String[] campos = linha.split(",");

                                    // Verificar se há pelo menos 5 campos na linha
                                    if (campos.length >= 5) {
                                        // Extrair os dados da linha
                                        String dataString = campos[0].trim();
                                        String nome1 = campos[1].trim();
                                        String nome2 = campos[2].trim();
                                        String transportadora = campos[3].trim();
                                        String artigo = campos[4].trim();
                                        double valor = Double.parseDouble(campos[5].trim());

                                        // Converter a data para o formato desejado
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                        Date data = sdf.parse(dataString);

                                        // Verificar se a data está dentro do período desejado
                                        Date dataInicioPeriodo = sdf.parse(dataInicio);
                                        Date dataFimPeriodo = sdf.parse(dataFim);
                                        if (data.after(dataInicioPeriodo) && data.before(dataFimPeriodo)) {
                                            // Calcular o faturamento do vendedor
                                            String nomeVendedor = nome1 + " " + nome2;
                                            if (faturamentoPorVendedor.containsKey(nomeVendedor)) {
                                                double faturamentoAtual = faturamentoPorVendedor.get(nomeVendedor);
                                                faturamentoPorVendedor.put(nomeVendedor, faturamentoAtual + valor);
                                            } else {
                                                faturamentoPorVendedor.put(nomeVendedor, valor);
                                            }
                                        }
                                    }
                                }

                                // Determinar o vendedor que mais faturou
                                String vendedorMaisFaturou = "";
                                double maiorFaturamento = 0.0;
                                for (String vendedor : faturamentoPorVendedor.keySet()) {
                                    double faturamento = faturamentoPorVendedor.get(vendedor);
                                    if (faturamento > maiorFaturamento) {
                                        maiorFaturamento = faturamento;
                                        vendedorMaisFaturou = vendedor;
                                    }
                                }
                                // Exibir o resultado
                                DecimalFormat df = new DecimalFormat("#.00");
                                if (!vendedorMaisFaturou.isEmpty()) {
                                    System.out.println("Vendedor que mais faturou no período de " + dataInicio + " a " + dataFim + ": " + vendedorMaisFaturou);
                                    System.out.println("Faturamento: " + df.format(maiorFaturamento));
                                } else {
                                    System.out.println("Não há dados de faturamento no período especificado.");
                                }
                            } catch (IOException | ParseException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }


                switch (getOp()) {
                    case 7:
                        String nomeArquivo = "dados.txt"; // Nome do arquivo de texto
                        String dataInicio = "01/01/2021"; // Data de início do período desejado
                        String dataFim = "10/01/2021"; // Data de fim do período desejado

                        // Mapa para armazenar o faturamento de cada transportador
                        Map<String, Double> faturamentoPorTransportador = new HashMap<>();

                        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
                            String linha;
                            while ((linha = br.readLine()) != null) {
                                // Separar os campos da linha pelo caractere ","
                                String[] campos = linha.split(",");

                                // Verificar se há pelo menos 5 campos na linha
                                if (campos.length >= 5) {
                                    // Extrair os dados da linha
                                    String dataString = campos[0].trim();
                                    String nome1 = campos[1].trim();
                                    String nome2 = campos[2].trim();
                                    String transportadora = campos[3].trim();
                                    String artigo = campos[4].trim();
                                    double valor = Double.parseDouble(campos[5].trim());

                                    // Converter a data para o formato desejado
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    Date data = sdf.parse(dataString);

                                    // Verificar se a data está dentro do período desejado
                                    Date dataInicioPeriodo = sdf.parse(dataInicio);
                                    Date dataFimPeriodo = sdf.parse(dataFim);
                                    if (data.after(dataInicioPeriodo) && data.before(dataFimPeriodo)) {
                                        // Calcular o faturamento do transportador
                                        if (faturamentoPorTransportador.containsKey(transportadora)) {
                                            double faturamentoAtual = faturamentoPorTransportador.get(transportadora);
                                            faturamentoPorTransportador.put(transportadora, faturamentoAtual + valor);
                                        } else {
                                            faturamentoPorTransportador.put(transportadora, valor);
                                        }
                                    }
                                }
                            }

                            // Determinar o transportador com maior faturamento
                            String transportadorMaisFaturou = "";
                            double maiorFaturamento = 0.0;
                            for (String transportador : faturamentoPorTransportador.keySet()) {
                                double faturamento = faturamentoPorTransportador.get(transportador);
                                if (faturamento > maiorFaturamento) {
                                    maiorFaturamento = faturamento;
                                    transportadorMaisFaturou = transportador;
                                }
                            }

                            System.out.println("Transportador com maior faturação: " + transportadorMaisFaturou);
                            break;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {


                        }
                        break;
                }


            }
        }


}

















