package lexer;

import java.io.IOException;
import lexer.core.Lexer;
import lexer.core.Token;
import lexer.core.TokenType;
import util.StringtoArray;

public class Main {

    public static void main(String[] args) throws IOException {
        //main function
        // String[] lines=StringtoArray.readfile("../input/file.txt");
        // Lexer lexer=new Lexer(lines);
        // // lexer.start();
        String[] lines = StringtoArray.readfile("../input/file.txt");
        Lexer lexer = new Lexer(lines);
        Token token;
        do {
            token = lexer.nextToken();
            System.out.println(token);
        } while (token.type != TokenType.TOKEN_EOF);
    }

}
