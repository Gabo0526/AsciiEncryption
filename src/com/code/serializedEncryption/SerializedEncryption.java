package com.code.serializedEncryption;

import java.io.*;

/**
 * Class for encrypting and serializing text.
 * Author: Gabriel Vasconez
 */
public class SerializedEncryption implements Serializable {
    private int[] ciphertextIntArray;

    /**
     * Constructor that creates an instance of SerializedEncryption with a predefined integer array.
     */
    public SerializedEncryption() {
        this.ciphertextIntArray = new int[100];
    }

    /**
     * Encrypts text using a key and serializes it into a byte array.
     *
     * @param text The text to encrypt.
     * @param key  The key for encryption.
     * @return A ByteArrayOutputStream containing the encrypted and serialized text.
     * @throws IOException If an I/O error occurs during serialization.
     */
    public ByteArrayOutputStream encryptNewText(String text, int key) throws IOException {
        this.ciphertextIntArray = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            ciphertextIntArray[i] = ((int) text.toCharArray()[i]) - key;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(this);

        return byteArrayOutputStream;
    }

    /**
     * Gets the array of encrypted integers.
     *
     * @return The array of encrypted integers.
     */
    protected int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }
}