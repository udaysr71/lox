package lox;

public class Token {
    final TokenType tokenType;
    final String lexeme;
    final String literal;
    final int line;
    // Let's implement this later
    // final int offset;

    public Token(TokenType tokenType, String lexeme, String literal, int line) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Token{");
        sb.append("tokenType=").append(tokenType);
        sb.append(", lexeme='").append(lexeme).append('\'');
        sb.append(", literal='").append(literal).append('\'');
        sb.append(", line=").append(line);
        sb.append('}');
        return sb.toString();
    }
}
