package lexer.core;

public class Token {

    public TokenType type;
    public String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;

    }
    public void Token(){
        TokenType type=TokenType.TOKEN_INVALID;
        String value="";    
    }
    //Tokentype type=TokenType.TOKEN_INVALID;
    // public enum Tokentype {
    //     EOD,
    //     Keywords,
    //     Identifiers,
    //     Variables,
    //     Operators,
    //     Comments,

    // }
}
