package com.code.serializedEncryption;

import java.io.*;

/**
 * Class for deserializing and decrypt encrypted text by the SerializedEncryption class.
 * Author: Gabriel Vasconez
 */
public class SerializedDecryption {
    private String decipheredText;

    /**
     * Constructor that deserializes encrypted text and decrypts it.
     *
     * @param serializedCiphertext The serialized encrypted text.
     * @param key                  The key for decryption.
     */
    public SerializedDecryption(ByteArrayOutputStream serializedCiphertext, int key) {
        decipherNewText(serializedCiphertext, key);
    }

    /**
     * Deserializes encrypted text and decrypts it.
     *
     * @param serializedCiphertext The serialized encrypted text.
     * @param key                  The key for decryption.
     */
    public void decipherNewText(ByteArrayOutputStream serializedCiphertext, int key) {
        SerializedEncryption deserializedCiphertext = new SerializedEncryption();

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedCiphertext.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            deserializedCiphertext = (SerializedEncryption) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i : deserializedCiphertext.getCiphertextIntArray()) {
            stringBuilder.append((char) (i - key));
        }

        this.decipheredText = stringBuilder.toString();
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