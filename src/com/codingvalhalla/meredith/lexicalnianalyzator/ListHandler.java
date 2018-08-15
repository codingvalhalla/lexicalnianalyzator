package com.codingvalhalla.meredith.lexicalnianalyzator;

import com.codingvalhalla.meredith.lexicalnianalyzator.tokens.Tokens;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meredith
 */
public class ListHandler extends ArrayList {

    public List<Tokens> list;

    public ListHandler() {
        this.list = new ArrayList<>();

    }

    @Override
    public String toString() {
        String output = "Vypis tokenu:\n\n";
        for (Object x : this) {
            output += x.toString();
        }
        return output;
    }

}
