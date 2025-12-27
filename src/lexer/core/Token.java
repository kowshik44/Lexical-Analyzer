package lexer.core;

public class Token {

    public TokenType type;
    public String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }
    public Token() {
        this(TokenType.TOKEN_INVALID, "");
    }

    @Override
    public String toString() {
        return "Token{" + "type=" + type + ", value='" + value + '\'' + '}';
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
