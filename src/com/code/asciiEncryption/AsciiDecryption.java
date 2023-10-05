// Author: Gabriel Vasconez
package com.code.asciiEncryption;

public class AsciiDecryption {
    private int[] ciphertextIntArray;
    private String ciphertextString;
    private String decipheredText;

    public AsciiDecryption(int[] ciphertextIntArray) {
        setNewCiphertextIntArray(ciphertextIntArray);
        this.ciphertextString = "";
    }

    public AsciiDecryption(String ciphertextString) throws Exception {
        setNewCiphertextString(ciphertextString);
        this.ciphertextIntArray = new int[0];
    }

    public int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }

    public String getCiphertextString() {
        return ciphertextString;
    }

    public String getDecipheredText() {
        return decipheredText;
    }

    public void setNewCiphertextIntArray(int[] ciphertext) {
        this.ciphertextIntArray = ciphertext;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : ciphertext) {
            stringBuilder.append((char) i);
        }

        this.decipheredText = stringBuilder.toString();
    }

    public void setNewCiphertextString(String ciphertextString) throws Exception {
        this.ciphertextString = ciphertextString;
        int i = 0;
        char[] ciphertextCharArray = ciphertextString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        while (i < ciphertextString.length()) {
            int a = 0;
            int b = 0;
            boolean c = false;

            String A = String.format("%c%c", ciphertextCharArray[i], ciphertextCharArray[i + 1]);

            try {
                String B = String.format("%c%c%c", ciphertextCharArray[i], ciphertextCharArray[i + 1], ciphertextCharArray[i + 2]);
                a = Integer.parseInt(A);
                b = Integer.parseInt(B);
            } catch (ArrayIndexOutOfBoundsException e) {
                a = Integer.parseInt(A);
            }

            if (a >= 32) {
                c = true;
                stringBuilder.append((char) a);
            } else {
                stringBuilder.append((char) b);
            }

            if (c) {
                i = i + 2;
            } else {
                i = i + 3;
            }
        }

        this.decipheredText = stringBuilder.toString();
    }

    public static String decipherText(String ciphertextString) throws Exception{
        int i = 0;
        char[] ciphertextCharArray = ciphertextString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        while (i < ciphertextString.length()) {
            int a = 0;
            int b = 0;
            boolean c = false;

            String A = String.format("%c%c", ciphertextCharArray[i], ciphertextCharArray[i + 1]);

            try {
                String B = String.format("%c%c%c", ciphertextCharArray[i], ciphertextCharArray[i + 1], ciphertextCharArray[i + 2]);
                a = Integer.parseInt(A);
                b = Integer.parseInt(B);
            } catch (ArrayIndexOutOfBoundsException e) {
                a = Integer.parseInt(A);
            }

            if (a >= 32) {
                c = true;
                stringBuilder.append((char) a);
            } else {
                stringBuilder.append((char) b);
            }

            if (c) {
                i = i + 2;
            } else {
                i = i + 3;
            }
        }

        return stringBuilder.toString();
    }
}