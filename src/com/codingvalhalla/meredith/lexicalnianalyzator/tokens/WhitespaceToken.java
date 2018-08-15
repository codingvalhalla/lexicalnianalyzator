package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public class WhitespaceToken extends Tokens {

    public WhitespaceToken() {
        super("Whitespace");
    }

    @Override
    public String toString() {
        return super.toString()+"\n";
    }
}
