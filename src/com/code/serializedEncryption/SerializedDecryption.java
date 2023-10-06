// Author: Gabriel Vasconez
package com.code.serializedEncryption;

import java.io.*;

public class SerializedDecryption {
    private String decipheredText;

    public SerializedDecryption(ByteArrayOutputStream serializedCiphertext, int key) {
        decipherNewText(serializedCiphertext, key);
    }

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
            stringBuilder.append((char) (i + key));
        }

        this.decipheredText = stringBuilder.toString();
    }

    public String getDecipheredText() {
        return decipheredText;
    }
}