package com.code.serializedEncryption;

import java.io.*;

public class SerializedDecryption {
    private int key;
    private SerializedEncryption deserializedCiphertext;
    private String decipheredText;

    public SerializedDecryption(ByteArrayOutputStream serializedCiphertext, int key) {
        decipherNewText(serializedCiphertext, key);
    }

    public void decipherNewText(ByteArrayOutputStream serializedCiphertext, int key) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedCiphertext.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            this.deserializedCiphertext = (SerializedEncryption) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i : this.deserializedCiphertext.getCiphertextIntArray()) {
            stringBuilder.append((char) (i + key));
        }

        this.decipheredText = stringBuilder.toString();
    }

    public String getDecipheredText() {
        return decipheredText;
    }
}