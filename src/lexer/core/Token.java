package lexer.core;

public class Token {

    public Tokentype type;
    public String value;

    public Token(Tokentype type, String value) {
        this.type = type;
        this.value = value;

    }

    public enum Tokentype {
        EOD,
        Keywords,
        Identifiers,
        Variables,
        Operators,
        Comments,

    }
}
