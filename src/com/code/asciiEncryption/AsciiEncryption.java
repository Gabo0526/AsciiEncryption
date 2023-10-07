package com.code.asciiEncryption;

/**
 * Class for encrypting text in ASCII format.
 * Allows conversion of text into a series of ASCII integer values.
 * Also provides methods to access the original text and the encrypted text.
 * Author: Gabriel Vasconez
 */
public class AsciiEncryption {

    private String text;
    private int[] ciphertextIntArray;
    private String ciphertextString;

    /**
     * Constructor that creates an instance of AsciiEncryption with the provided text.
     *
     * @param text The text to be encrypted.
     */
    public AsciiEncryption(String text) {
        setNewText(text);
    }

    /**
     * Sets a new text to encrypt and updates the object values.
     *
     * @param text The new text to encrypt.
     */
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

    /**
     * Gets the original text.
     *
     * @return The original text.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the encrypted text as an array of integers.
     *
     * @return The encrypted text as an array of integers.
     */
    public int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }

    /**
     * Gets the encrypted text as a string.
     *
     * @return The encrypted text as a string.
     */
    public String getCiphertextString() {
        return ciphertextString;
    }
}