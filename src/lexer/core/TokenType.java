package lexer.core;

public enum TokenType {
    /* Keywords */

    TOKEN_KW_LET    ,
    TOKEN_KW_FN     ,
    TOKEN_KW_RETURN ,
    TOKEN_KW_CONST  ,
    TOKEN_KW_FOR    ,
    TOKEN_KW_IN     ,
    TOKEN_KW_IF     ,
    TOKEN_KW_ELSE   ,
    TOKEN_KW_MATCH  ,

    /* Identifers */

    TOKEN_ID_IDENT          ,
    TOKEN_ID_INT_LITERAL    ,
    TOKEN_ID_BOOL_LITERAL   ,
    TOKEN_ID_STRING_LITERAL ,
    TOKEN_ID_FLOAT_LITERAL  ,

    /*  Operators */

    TOKEN_OP_PLUS       ,
    TOKEN_OP_MINUS      ,
    TOKEN_OP_STAR       ,
    TOKEN_OP_SLASH      ,
    TOKEN_OP_PERCENT    ,
    TOKEN_OP_EQ         ,
    TOKEN_OP_NOT_EQ     ,
    TOKEN_OP_GT         ,
    TOKEN_OP_LT         ,
    TOKEN_OP_GT_EQ      ,
    TOKEN_OP_LT_EQ      ,
    TOKEN_OP_EQ_EQ      ,
    TOKEN_OP_OR         ,
    TOKEN_OP_AND        ,
    TOKEN_OP_NOT        ,
    TOKEN_OP_ARROW      ,
    TOKEN_OP_PIPE       ,

    /* Delimiters */

    TOKEN_DLM_COMMA     ,
    TOKEN_DLM_LPAREN    ,
    TOKEN_DLM_RPAREN    ,
    TOKEN_DLM_LBRACT    ,
    TOKEN_DLM_RBRACT    ,
    TOKEN_DLM_LBRACE    ,
    TOKEN_DLM_RBRACE    ,
    TOKEN_DLM_COLON     ,
    TOKEN_DLM_SEMICLN   ,

    /* Special Tokens */

    TOKEN_EOF,
    TOKEN_INVALID,
}