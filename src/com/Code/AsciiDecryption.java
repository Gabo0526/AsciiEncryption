// Author: Gabriel Vasconez
package com.Code;

public class AsciiDecryption {
    private int[] cipherTextIntArray;
    private String cipherTextString;
    private String decipheredText;

    public AsciiDecryption(int[] cipherTextIntArray) {
        setNewCipherTextIntArray(cipherTextIntArray);
        this.cipherTextString = "";
    }

    public AsciiDecryption(String cipherTextString) {
        setNewCipherTextString(cipherTextString);
        this.cipherTextIntArray = new int[0];
    }

    public int[] getCipherTextIntArray() {
        return cipherTextIntArray;
    }

    public String getCipherTextString() {
        return cipherTextString;
    }

    public String getDecipheredText() {
        return decipheredText;
    }

    public void setNewCipherTextIntArray(int[] cipherText) {
        this.cipherTextIntArray = cipherText;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : cipherText) {
            stringBuilder.append((char) i);
        }

        this.decipheredText = stringBuilder.toString();
    }

    public void setNewCipherTextString(String cipherTextString) {
        this.cipherTextString = cipherTextString;
        int i = 0;
        char[] cipherTextCharArray = cipherTextString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        while (i < cipherTextString.length()) {
            int a = 0;
            int b = 0;
            boolean c = false;

            String A = String.format("%c%c", cipherTextCharArray[i], cipherTextCharArray[i + 1]);

            try {
                String B = String.format("%c%c%c", cipherTextCharArray[i], cipherTextCharArray[i + 1], cipherTextCharArray[i + 2]);
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

    public static String decipherText(String cipherTextString) {
        int i = 0;
        char[] cipherTextCharArray = cipherTextString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        while (i < cipherTextString.length()) {
            int a = 0;
            int b = 0;
            boolean c = false;

            String A = String.format("%c%c", cipherTextCharArray[i], cipherTextCharArray[i + 1]);

            try {
                String B = String.format("%c%c%c", cipherTextCharArray[i], cipherTextCharArray[i + 1], cipherTextCharArray[i + 2]);
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