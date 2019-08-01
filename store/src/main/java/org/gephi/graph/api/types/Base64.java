package org.gephi.graph.api.types;

import javax.xml.bind.DatatypeConverter;

public class Base64 {

    public static final String NAME = Base64.class.getSimpleName();

    private final String decodedString;

    public static Base64 fromEncodedString(String encodedString) {
        return new Base64(encodedString);
    }

    public static Base64 fromDecodeString(String decodedString) {
        return new Base64(decodedString);
    }

    private Base64(String decodedString) {
        this.decodedString = decodedString;
    }

    @Override
    public String toString() {
        return decodedString;
    }

    public String toEncodedString() {
        return encode(decodedString);
    }

    public static String encode(String input) {
        return DatatypeConverter.printBase64Binary(input.getBytes());
    }

    public static String decode(String input) {
        return new String(DatatypeConverter.parseBase64Binary(input));
    }

}
