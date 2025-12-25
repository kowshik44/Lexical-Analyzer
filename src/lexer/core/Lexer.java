package lexer.core;

import java.io.IOException;

// import java.io.FileNotFoundException;
// import java.io.FileReader;


public class Lexer {
    private String input;
    private int position;
    
    public Lexer(String input){
        this.input=input;
        this.position=position;

    }

    public Token nextToken() throws IOException{
        //tokenization
        
        
        return null;
    }
    private char currenChar(){
        
        return 0;
    }
    private void MoveTOnextChar(){

    }
    private char LooknextChar(){

        return 0;
    }
    private boolean isEnd(){

        return false;
    }
    private void skipWhiteSpace(){

    }
    private Token readIdentifierOrKeyword(){

        return null;
    }
     private Token readNumber() {

        return null;
    }
    private Token readSymbol() {
        // build operator or separator token
        return null;
    }

}
