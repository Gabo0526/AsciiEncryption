package com.code.tests;

import com.code.serializedEncryption.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SerializedEncryptionApp {
    public static void main(String[] args) throws IOException {
        SerializedEncryption encryption = new SerializedEncryption();
        ByteArrayOutputStream ciphertext = encryption.encryptNewText("Hola, mundo!", 13);

        System.out.printf("El texto cifrado y serializado es: %s\n", ciphertext);

        SerializedDecryption decryption = new SerializedDecryption(ciphertext, 13);
        System.out.printf("El texto descifrado y deserializado es: %s\n\n", decryption.getDecipheredText());

        ciphertext = encryption.encryptNewText("Hey! Este es un nuevo texto", 12435);
        System.out.printf("El texto cifrado y serializado es: %s\n", ciphertext);

        decryption.decipherNewText(ciphertext, 12435);
        System.out.printf("El texto descifrado y deserializado es: %s\n", decryption.getDecipheredText());
    }
}