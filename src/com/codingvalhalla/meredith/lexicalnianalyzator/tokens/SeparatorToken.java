package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public class SeparatorToken extends Tokens {

    private final String TYPE;

    public SeparatorToken(char charakter) {
        super("SeparatorToken");
        TYPE = "" + charakter;
    }

    @Override
    public String toString() {
        return super.toString() + "type = \"" + this.getType(TYPE) + "\"\n";
    }

    private String getType(String type) {
        switch (type) {
            case ",":
                return "carka";
            case ";":
                return "strednik";
            case "=":
                return "rovna se";
            default:
                return "";
        }
    }

}
