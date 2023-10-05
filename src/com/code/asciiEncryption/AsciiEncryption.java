// Author: Gabriel Vasconez
package com.code.asciiEncryption;

import java.util.Arrays;
import java.util.StringTokenizer;

public class AsciiEncryption {

    private String text;
    private int[] ciphertextIntArray;

    public AsciiEncryption(String text) {
        setNewText(text);
    }

    public String getText() {
        return text;
    }

    public int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }

    public void setNewText(String text) {
        this.text = text;
        this.ciphertextIntArray = new int[text.length()];
        char[] textArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            ciphertextIntArray[i] = (int) textArray[i];
        }
    }

    public String getCipherString() {
        StringTokenizer tokenizer = new StringTokenizer(Arrays.toString(this.ciphertextIntArray), ", ");
        StringBuilder stringBuilder = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            stringBuilder.append(token);
        }

        char[] cipherCharArray = stringBuilder.toString().toCharArray();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i = 1; i < cipherCharArray.length - 1; i++) {
            stringBuilder1.append(cipherCharArray[i]);
        }

        return stringBuilder1.toString();
    }

    public static String ciphertext(String text) {
        int[] ciphertextIntArray = new int[text.length()];
        char[] textArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            ciphertextIntArray[i] = (int) textArray[i];
        }

        StringTokenizer tokenizer = new StringTokenizer(Arrays.toString(ciphertextIntArray), ", ");
        StringBuilder stringBuilder0 = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            stringBuilder0.append(token);
        }

        char[] cipherCharArray = stringBuilder0.toString().toCharArray();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i = 1; i < cipherCharArray.length - 1; i++) {
            stringBuilder1.append(cipherCharArray[i]);
        }

        return stringBuilder1.toString();
    }
}