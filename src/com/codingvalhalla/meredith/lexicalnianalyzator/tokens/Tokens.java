package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public abstract class Tokens {

    private final String TYPE;

    public Tokens(String type) {
        this.TYPE = type;
    }

    @Override
    public String toString() {
        return "Token: " + TYPE + " ";
    }

}
