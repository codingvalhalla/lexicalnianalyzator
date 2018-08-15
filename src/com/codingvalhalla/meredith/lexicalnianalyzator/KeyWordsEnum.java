package com.codingvalhalla.meredith.lexicalnianalyzator;

/**
 *
 * @author Meredith
 */
public enum KeyWordsEnum {
    auto("auto"),
    begin("begin"),
    end("end"),
    struct("struct"),
    register("register"),
    typedef("typedef"),
    extern("extern"),
    union("union"),
    signed("signed"),
    sizeof("sizeof"),
    unsigned("unsigned");

    private final String name;

    private KeyWordsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
