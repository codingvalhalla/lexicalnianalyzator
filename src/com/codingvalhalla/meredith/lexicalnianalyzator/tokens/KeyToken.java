package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public class KeyToken extends Tokens {

    private final String KEY;

    public KeyToken(String id) {
        super("Keytoken");
        this.KEY = id;
    }

    @Override
    public String toString() {
        return super.toString() + "KeyWorld = \"" + KEY + "\"\n";
    }

}
