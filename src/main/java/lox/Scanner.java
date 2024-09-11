package lox;

import java.util.ArrayList;
import java.util.List;

import static lox.TokenType.*;

public class Scanner {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    public Scanner(java.lang.String source) {
        this.source = source;
    }
    List<Token> scanTokens(){
        while(!isAtEnd()){
            start = current;
        }
        return null;
    }
    private boolean isAtEnd(){
        return current > source.length();
    }

    private void scanToken() {
        char c = advance();
        switch (c){
            case '(': addToken(LEFT_PAREN);break;
            case ')': addToken(RIGHT_PAREN);break;
            case '{': addToken(LEFT_BRACE);break;
            case '}': addToken(RIGHT_BRACE);break;
            case ',': addToken(COMMA);break;
            case '.': addToken(DOT);break;
            case '-': addToken(MINUS);break;
            case '+': addToken(PLUS);break;
            case ';': addToken(SEMICOLON);break;
            case '=': addToken(EQUAL);break;
        }
    }

    private char advance() {
        return 0;
    }

    private void addToken(TokenType tokenType) {

    }

}
