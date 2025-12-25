package lexer;

import java.io.IOException;
import lexer.core.Lexer;
import util.StringtoArray;

public class Main {

    public static void main(String[] args) throws IOException {
        //main function
        String[] lines=StringtoArray.readfile("input/file.txt");
        Lexer lexer=new Lexer(lines);
    }

}
