package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public class IdentificatorToken extends Tokens {

    private final String ID;
    private final int MAX_LENGTH_STRING = 32;

    public IdentificatorToken(String id) {
        super("IdentificatorToken");
        this.ID = id;

    }

    @Override
    public String toString() {
        return super.toString() + "\"" + this.getID(MAX_LENGTH_STRING) + "\"\n";
    }

    private String getID(int MAX) {
        if (ID.length() > MAX) {
            return ID.substring(0, MAX);
        } else {
            return ID;

        }
    }

}
