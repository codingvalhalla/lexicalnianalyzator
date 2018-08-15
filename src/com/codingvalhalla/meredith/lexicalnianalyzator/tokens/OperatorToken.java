package com.codingvalhalla.meredith.lexicalnianalyzator.tokens;

/**
 *
 * @author Meredith
 */
public class OperatorToken extends Tokens {

    private final String TYPE;

    public OperatorToken(char charakter) {
        super("OperatorToken");
        TYPE = "" + charakter;
    }

    @Override
    public String toString() {
        return super.toString() + "type = \"" + this.getType(TYPE) + "\"\n";
    }

    private String getType(String type) {
        switch (type) {
            case "+":
                return "scitani";
            case "-":
                return "odcitani";
            case "/":
                return "deleni";
            case "÷":
                return "deleni";
            case "*":
                return "nasobeni";
            case "×":
                return "nasobeni";
            case "%":
                return "modulo";
            default:
                return "";
        }
    }
}
