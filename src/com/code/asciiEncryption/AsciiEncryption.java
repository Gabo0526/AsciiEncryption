// Author: Gabriel Vasconez
package com.code.asciiEncryption;

public class AsciiEncryption {

    private String text;
    private int[] ciphertextIntArray;
    private String ciphertextString;

    public AsciiEncryption(String text) {
        setNewText(text);
    }

    public void setNewText(String text) {
        this.text = text;
        this.ciphertextIntArray = new int[text.length()];
        char[] textArray = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            ciphertextIntArray[i] = (int) textArray[i];
            stringBuilder.append((int) textArray[i]);
        }

        this.ciphertextString = stringBuilder.toString();
    }

    public String getText() {
        return text;
    }

    public int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }

    public String getCiphertextString() {
        return ciphertextString;
    }
}