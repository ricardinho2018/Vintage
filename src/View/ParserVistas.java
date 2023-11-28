package View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserVistas {

    public static Map<String,Vista> parser() throws  LineAlreadyExists {
        Map<String,Vista> vistas = new HashMap<>();
        List<String> linhas = readFile();
        String[] parsedlines;
        int menus = 0;

        for (String linha : linhas) {
            //Separar em dois, o tipo de entidade a ser lido e os seus parametros a preencher
            parsedlines = linha.split(":", 2);

            if (parsedlines[0].equals("MAIN MENU")) {
                Vista v = new Vista();
                v.addLinha(" ************ Menu ************ \n");
                parsedlines = parsedlines[1].split(",");
                for (String l : parsedlines)
                    v.addLinha(l);
                v.addLinha("0 - Sair");
                vistas.put("MAIN MENU", v);
                menus++;
            } else if (parsedlines[0].equals("MENU1")) {
                Vista v = new Vista();
                parsedlines = parsedlines[1].split(",");
                for (String l : parsedlines)
                    v.addLinha(l);
                v.addLinha("0 - Sair");
                StringBuilder sb = new StringBuilder();
                sb.append("MENU").append(menus);
                vistas.put(sb.toString(), v);
                menus++;
            }
        }
        return vistas;
    }

    public static List<String> readFile() {
        List<String> linhas = new ArrayList<>();
        try {
            String filepath = "C:/Users/rmsp_/OneDrive/Área de Trabalho/App_Poo_2/src/View/vistas.txt" ;
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String read;
            while ((read = reader.readLine()) != null) {
                linhas.add(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }
}
