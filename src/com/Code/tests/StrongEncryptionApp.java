package com.Code.tests;

import com.Code.myEncryption.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StrongEncryptionApp {
    public static void main(String[] args) throws IOException {
        MyEncryption encryption = new MyEncryption();
        ByteArrayOutputStream ciphertext = encryption.encryptText("Hola, mundo!", 13);

        System.out.printf("El texto cifrado es: %s\n", ciphertext);

        MyDecryption decryption = new MyDecryption(ciphertext, 13);
        System.out.printf("El texto descifrado es: %s\n\n", decryption.getDecipheredText());

        ciphertext = encryption.encryptText("Hey! Este es un nuevo texto", 12435);
        System.out.printf("El texto cifrado es: %s\n", ciphertext);

        decryption.decipherNewText(ciphertext, 12435);
        System.out.printf("El texto descifrado es: %s\n", decryption.getDecipheredText());
    }
}
