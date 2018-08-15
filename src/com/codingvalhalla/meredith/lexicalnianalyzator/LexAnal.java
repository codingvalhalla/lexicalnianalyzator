package com.codingvalhalla.meredith.lexicalnianalyzator;

import com.codingvalhalla.meredith.lexicalnianalyzator.tokens.*;
import java.util.EnumSet;

/**
 *
 * @author Meredith
 */
public class LexAnal {

    private int numberOfChars;
    private int nubmerOfWhiteSpaces;
    private String status;
    private String typeOfNumber;
    private int number;
    private String id;
    private ListHandler list;

    public LexAnal(ListHandler list) {
        id = new String();
        status = "NONE";
        typeOfNumber = "DEC";
        number = 0;
        nubmerOfWhiteSpaces = 0;
        numberOfChars = 0;
        this.list = list;
    }

    public void increaseChars() {
        this.numberOfChars++;
    }

    public void analyze(char charakterIn) {
        char charakter = Character.toLowerCase(charakterIn);
        if (charakter == ' ' || charakter == '\t' || charakter == '\r' || charakter == '\n' || charakter == '\f') {
            if (nubmerOfWhiteSpaces == 0) {
                this.getIdNum();
                list.add(new WhitespaceToken());

            }
            nubmerOfWhiteSpaces++;
        } else if (charakter == '=' || charakter == ',' || charakter == ';') {
            this.getIdNum();
            list.add(new SeparatorToken(charakter));

        } else if (charakter == '+' || charakter == '-' || charakter == '/' || charakter == '*' || charakter == '%' || charakter == '÷' || charakter == '×') {
            this.getIdNum();
            list.add(new OperatorToken(charakter));

        } else if (('0' <= charakter && charakter <= '9') || charakter == 'x' && numberOfChars == 2 && status.equals("NUM") || status.equals("NUM") && typeOfNumber.equals("HEX") && ('a' <= charakter && charakter <= 'f')) {
            if (status.equals("ID")) {
                id += charakter;
            } else {
                if (status.equals("NONE")) {
                    status = "NUM";
                    typeOfNumber = "DEC";
                    number = 0;
                }
                if (charakter == 'x') {
                    typeOfNumber = "HEX";
                } else {
                    if (typeOfNumber.equals("DEC")) {
                        number = (number * 10) + (charakter - '0');
                    } else {
                        number = 16 * number;
                        if ('0' <= charakter && charakter <= '9') {
                            number = number + (charakter - '0');
                        } else {
                            number = number + charakter - 'a' + 10;
                        }
                    }

                }
            }

        } else if ('a' <= charakter && charakter <= 'z' || charakter
                == '_') {
            status = "ID";
            id += charakter;
        } else {
            System.out.println("It is unknown");
        }
    }

    private void getIdNum() {
        if (status.equals("ID")) {
            if (LexAnal.contains(KeyWordsEnum.class, id)) {
                list.add(new KeyToken(id));
            } else {
                list.add(new IdentificatorToken(id));
            }

        } else if (status.equals("NUM")) {
            list.add(new NumberToken(number));
        }
        id = "";
        status = "NONE";
        number = 0;
        nubmerOfWhiteSpaces = 0;
        numberOfChars = 0;

    }

    private static <E extends Enum<E>> boolean contains(Class<E> _enumClass,
            String value) {
        try {
            return EnumSet.allOf(_enumClass)
                    .contains(Enum.valueOf(_enumClass, value));
        } catch (Exception e) {
            return false;
        }
    }

}
