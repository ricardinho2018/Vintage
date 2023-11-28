package App;

import Controler.Controler;
import Model.Model;
import View.LineAlreadyExists;
import View.View;
import Model.Encomenda;

import java.io.IOException;
import java.text.ParseException;


public class App {

    public static void main(String[] args) throws LineAlreadyExists {


        Model model = new Model();
        Controler controler = new Controler(model);
        View view = new View(model,controler);
        try{
            view.run();
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }

}
