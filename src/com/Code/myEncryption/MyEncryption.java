package com.Code.myEncryption;

import java.io.*;

public class MyEncryption implements Serializable {
    private int[] cipherTextIntArray;
    public MyEncryption() {
    }

    public ByteArrayOutputStream encryptText(String text, int key) throws IOException {
        this.cipherTextIntArray = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            cipherTextIntArray[i] = ((int) text.toCharArray()[i]) - key;
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        objectOutputStream.writeObject(this);

        return byteArrayOutputStream;
    }

    protected int[] getCipherTextIntArray() {
        return cipherTextIntArray;
    }
}