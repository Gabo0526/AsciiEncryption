package com.Code.myEncryption;

import java.io.*;

public class MyDecryption {
    private int key;
    private MyEncryption deserializedCiphertext;
    private String decipheredText;

    public MyDecryption(ByteArrayOutputStream serializedCiphertext, int key) {
        decipherNewText(serializedCiphertext, key);
    }

    public void decipherNewText(ByteArrayOutputStream serializedCiphertext, int key) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedCiphertext.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            this.deserializedCiphertext = (MyEncryption) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i : this.deserializedCiphertext.getCipherTextIntArray()) {
            stringBuilder.append((char) (i + key));
        }

        this.decipheredText = stringBuilder.toString();
    }

    public String getDecipheredText() {
        return decipheredText;
    }
}
