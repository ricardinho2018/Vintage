package View;

public class LineAlreadyExists extends Exception{
    public LineAlreadyExists(){
        super();
    }

    public LineAlreadyExists(String msg){
        super(msg);
    }
}

