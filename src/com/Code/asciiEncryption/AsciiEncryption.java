// Author: Gabriel Vasconez
package com.Code.asciiEncryption;

import java.util.Arrays;
import java.util.StringTokenizer;

public class AsciiEncryption {

    private String text;
    private int[] cipherTextIntArray;

    public AsciiEncryption(String text) {
        setNewText(text);
    }

    public String getText() {
        return text;
    }

    public int[] getCipherTextIntArray() {
        return cipherTextIntArray;
    }

    public void setNewText(String text) {
        this.text = text;
        this.cipherTextIntArray = new int[text.length()];
        char[] textArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            cipherTextIntArray[i] = (int) textArray[i];
        }
    }

    public String getCipherString() {
        StringTokenizer tokenizer = new StringTokenizer(Arrays.toString(this.cipherTextIntArray), ", ");
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

    public static String cipherText(String text) {
        int[] cipherTextIntArray = new int[text.length()];
        char[] textArray = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            cipherTextIntArray[i] = (int) textArray[i];
        }

        StringTokenizer tokenizer = new StringTokenizer(Arrays.toString(cipherTextIntArray), ", ");
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

    //    public String getCipherTextString00() {
//        StringTokenizer tokenizer = new StringTokenizer(Arrays.toString(this.cipherTextIntArray), ", ");
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while (tokenizer.hasMoreTokens()) {
//            String token = tokenizer.nextToken();
//            int intToken;
//
//            try {
//                intToken = Integer.parseInt(token);
//            } catch (Exception e) {
//                char[] tokenCharArray = token.toCharArray();
//
//                if (tokenizer.hasMoreTokens()) {
//                    if (token.length() == 3) {
//                        intToken = Integer.parseInt(String.format("%c%c", tokenCharArray[1], tokenCharArray[2]));
//                    } else {
//                        intToken = Integer.parseInt(String.format("%c%c%c", tokenCharArray[1], tokenCharArray[2], tokenCharArray[3]));
//                    }
//                } else {
//                    if (token.length() == 3) {
//                        intToken = Integer.parseInt(String.format("%c%c", tokenCharArray[0], tokenCharArray[1]));
//                    } else {
//                        intToken = Integer.parseInt(String.format("%c%c%c", tokenCharArray[0], tokenCharArray[1], tokenCharArray[2]));
//                    }
//                }
//            }
//
//            stringBuilder.append(intToken);
//        }
//
//        return stringBuilder.toString();
//    }
}