package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public class NumberToken extends Tokens {

    private final int NUMBER;

    public NumberToken(int number) {
        super("NumberToken");
        this.NUMBER = number;
    }

    @Override
    public String toString() {
        return super.toString() + "value = {" + NUMBER + "}\n";
    }
}
