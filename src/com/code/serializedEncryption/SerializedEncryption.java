package com.code.serializedEncryption;

import java.io.*;

public class SerializedEncryption implements Serializable {
    private int[] ciphertextIntArray;
    public SerializedEncryption() {
    }

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

    protected int[] getCiphertextIntArray() {
        return ciphertextIntArray;
    }
}