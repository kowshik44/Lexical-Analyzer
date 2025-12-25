package lexer.core;

import java.io.IOException;

// import java.io.FileNotFoundException;
// import java.io.FileReader;


public class Lexer {
    private String[] lines;
    private int line;
    private int column;

    
    public Lexer(String[] lines) {
        this.lines = lines;
        this.line = 0;
        this.column = 0;
    }


    public Token nextToken() throws IOException{
        //tokenization
        
        
        return null;
    }
    private char currentChar(){
        if (line>=lines.length){
            return '\0';
        }
        if(column>=lines[line].length()){
            return '\n';
        }
        return lines[line].charAt(column);
    }
    private void MoveTOnextChar(){
        if (line>=lines.length){
            return;
        }
        if (column<lines[line].length()){
            column=column+1;
        }
        else{
            line++;
            column=0;
        }
    }
    private char LooknextChar(){
        if (line>=lines.length){
            return '\0';
        }
        if (column+1 < lines[line].length()){
            return lines[line].charAt(column+1);
        }
        if (line+1<lines.length){
            return '\n';
        }
        return '\0';
    }
    private boolean isEnd(){
        if(line==lines.length){
            return true;
        }
        return false;
        // return line >= lines.length;

    }
    private void skipWhiteSpace(){
        // if (lines[line]==" "){
        //     column++;
        // }
        while (!isEnd() && Character.isWhitespace(currentChar())){
            MoveTOnextChar();
        }
    }
    private Token readIdentifierOrKeyword(){
        // build identifier or keyword token
        StringBuilder keywords=new StringBuilder();
        StringBuilder identifier=new StringBuilder();

        while(!isEnd() && Character.isLetterOrDigit(currentChar()) ){
            // keywords.append(currentChar());
            // MoveTOnextChar();
            if(currentChar()=='l' && LooknextChar()=='e' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                if(currentChar()=='t'){
                    keywords.append(currentChar());
                    MoveTOnextChar();
                }
                return new Token(TokenType.TOKEN_KW_LET, keywords.toString());
            }
            if(currentChar()=='f' && LooknextChar()=='n' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_KW_FN, keywords.toString());
            }
            if(currentChar()=='r' && LooknextChar()=='e' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                if(currentChar()=='t' && LooknextChar()=='u' ){
                    keywords.append(currentChar());
                    MoveTOnextChar();
                    keywords.append(currentChar()); 
                    MoveTOnextChar();
                    if(currentChar()=='r' && LooknextChar()=='n' ){
                        keywords.append(currentChar());
                        MoveTOnextChar();
                        keywords.append(currentChar()); 
                        MoveTOnextChar();
                    }
                }
                return new Token(TokenType.TOKEN_KW_RETURN, keywords.toString());
            }
            if(currentChar()=='c' && LooknextChar()=='o' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                if(currentChar()=='n' && LooknextChar()=='s' ){
                    keywords.append(currentChar());
                    MoveTOnextChar();
                    keywords.append(currentChar()); 
                    MoveTOnextChar();
                    if(currentChar()=='t' ){
                        keywords.append(currentChar());
                        MoveTOnextChar();
                    }
                }
                return new Token(TokenType.TOKEN_KW_CONST, keywords.toString());
            }
            if(currentChar()=='f' && LooknextChar()=='o' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                if(currentChar()=='r' ){
                    keywords.append(currentChar());
                    MoveTOnextChar();
                }
                return new Token(TokenType.TOKEN_KW_FOR, keywords.toString());
            }
            if(currentChar()=='i' && LooknextChar()=='n' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_KW_IN, keywords.toString());
            }
            if(currentChar()=='i' && LooknextChar()=='f' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_KW_IF, keywords.toString());
            }
            if(currentChar()=='e' && LooknextChar()=='l' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                if(currentChar()=='s' && LooknextChar()=='e' ){
                    keywords.append(currentChar());
                    MoveTOnextChar();
                    keywords.append(currentChar()); 
                    MoveTOnextChar();
                }
                return new Token(TokenType.TOKEN_KW_ELSE, keywords.toString());
            }
            if(currentChar()=='m' && LooknextChar()=='a' ){
                keywords.append(currentChar());
                MoveTOnextChar();
                keywords.append(currentChar()); 
                MoveTOnextChar();
                if(currentChar()=='t' && LooknextChar()=='c' ){
                    keywords.append(currentChar());
                    MoveTOnextChar();
                    keywords.append(currentChar()); 
                    MoveTOnextChar();
                    if(currentChar()=='h' ){
                        keywords.append(currentChar());
                        MoveTOnextChar();
                    }
                }
                return new Token(TokenType.TOKEN_KW_MATCH, keywords.toString());
            }
            break;
        }
        if(!isEnd() && (Character.isLetter(currentChar()) || currentChar()=='_') ){
        while(!isEnd() && currentChar()=='_' || Character.isLetter(currentChar()) ){
            identifier.append(currentChar());
            MoveTOnextChar();
        }
        String lexeme=identifier.toString();
        return switch (lexeme) {
            case "true", "false" -> new Token(TokenType.TOKEN_ID_BOOL_LITERAL, lexeme);
            default -> new Token(TokenType.TOKEN_ID_IDENT, lexeme);
        };
    }
    return new Token(TokenType.TOKEN_INVALID, "");
    }
    private Token readStringLiteral() {
        // build string literal token
        StringBuilder strLiteral=new StringBuilder();

        while (!isEnd() && currentChar() != '"'){
            strLiteral.append(currentChar());
            MoveTOnextChar();
        }
        MoveTOnextChar();
        // String stringValue=strLiteral.toString();
        return new Token(TokenType.TOKEN_ID_STRING_LITERAL, strLiteral.toString());
    }
    private Token readNumber() {
        // build number token
        StringBuilder num=new StringBuilder();
        boolean isFloat=false;

        while (!isEnd() && Character.isDigit(currentChar())){
            num.append(currentChar());
            MoveTOnextChar();
        }
        if (!isEnd() && currentChar()=='.' && Character.isDigit(LooknextChar())){
            isFloat=true;
            num.append(currentChar());
            MoveTOnextChar();
            while(!isEnd() && Character.isDigit(currentChar())){
                num.append(currentChar());
                MoveTOnextChar();
            }

        }
        String numberValue=num.toString();
        if(isFloat==true){
            return new Token(TokenType.TOKEN_ID_FLOAT_LITERAL, numberValue);
        }
        else{
            return new Token(TokenType.TOKEN_ID_INT_LITERAL, numberValue);
        }
        
    }
    private Token readSymbol() {
        // build operator or separator token
        StringBuilder symbol=new StringBuilder();

        while (!isEnd() && !Character.isLetterOrDigit(currentChar()) && !Character.isWhitespace(currentChar())){
            if ( currentChar()=='+'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_PLUS, symbol.toString());
            }
            if(currentChar()=='-'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_MINUS, symbol.toString());
            }
            if(currentChar()=='*'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_STAR, symbol.toString());
            }
            if(currentChar()=='/'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_SLASH, symbol.toString());
            }
            if(currentChar()=='%'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_PERCENT, symbol.toString());
            }
            if(currentChar()=='='){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_EQ, symbol.toString());
            }
            if(currentChar()== '!' && LooknextChar()=='='){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_NOT_EQ, symbol.toString());
            }
            if(currentChar()=='>'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_GT, symbol.toString());
            }
            if(currentChar()=='<'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_LT, symbol.toString());
            }
            if(currentChar()=='>' && LooknextChar()=='='){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOEKN_OP_EQ_EQ, symbol.toString());
            }
            if(currentChar()=='<' && LooknextChar()=='='){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_LT_EQ, symbol.toString());
            }
            if(currentChar()=='=' && LooknextChar()=='='){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOEKN_OP_EQ_EQ, symbol.toString());
            }
            if(currentChar()=='|' && LooknextChar()=='|'){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_OR, symbol.toString());
            }
            if(currentChar()=='&' && LooknextChar()=='&'){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_AND, symbol.toString());
            }
            if(currentChar()=='!'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_NOT, symbol.toString());
            }
            if(currentChar()=='-' && LooknextChar()=='>'){
                symbol.append(currentChar());
                MoveTOnextChar();
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_ARROW, symbol.toString());
            }
            if(currentChar()=='|'){
                symbol.append(currentChar());
                MoveTOnextChar();
                return new Token(TokenType.TOKEN_OP_PIPE, symbol.toString());
            }
            break;

        }
        String symbolValue=symbol.toString();
        // return null;
        return new Token(TokenType.TOKEN_INVALID, symbolValue);
    }

}
