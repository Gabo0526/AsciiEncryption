package com.code.asciiEncryption;

/**
 * Class for decrypting text in ASCII format.
 * Allows the conversion of encrypted text in ASCII integers back to the original text.
 * Author: Gabriel Vasconez
 */
public class AsciiDecryption {
    private int[] ciphertextIntArray;
    private String ciphertextString;
    private String decipheredText;

    /**
     * Constructor that decrypts an array of ASCII integers.
     *
     * @param ciphertextIntArray The array of encrypted ASCII integers.
     */
    public AsciiDecryption(int[] ciphertextIntArray) {
        setNewCiphertextIntArray(ciphertextIntArray);
        this.ciphertextString = "";
    }

    /**
     * Constructor that decrypts a special string.
     *
     * @param ciphertextString The encrypted string.
     * @throws Exception If the string cannot be decrypted.
     */
    public AsciiDecryption(String ciphertextString) throws Exception {
        setNewCiphertextString(ciphertextString);
        this.ciphertextIntArray = new int[0];
    }

    /**
     * Sets a new array of encrypted integers and updates the object values.
     *
     * @param ciphertext The new array of encrypted integers.
     */
    public void setNewCiphertextIntArray(int[] ciphertext) {
        this.ciphertextIntArray = ciphertext;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : ciphertext) {
            stringBuilder.append((char) i);
        }

        this.decipheredText = stringBuilder.toString();
    }

    /**
     * Sets a new encrypted string and updates the object values.
     *
     * @param ciphertextString The new encrypted string.
     * @throws Exception If the string cannot be decrypted.
     */
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

    /**
     * Gets the array of encrypted integers.
     *
     * @return The array of encrypted integers.
     */
    public int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }

    /**
     * Gets the encrypted string.
     *
     * @return The encrypted string.
     */
    public String getCiphertextString() {
        return ciphertextString;
    }

    /**
     * Gets the decrypted text.
     *
     * @return The decrypted text.
     */
    public String getDecipheredText() {
        return decipheredText;
    }
}