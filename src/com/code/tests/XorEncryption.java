package com.code.tests;

public class XorEncryption {
    // Método para encriptar o desencriptar texto usando una clave secreta
    public static String xorCipher(String text, String key) {
        // Convertir el texto y la clave en arreglos de bytes
        byte[] textBytes = text.getBytes();
        byte[] keyBytes = key.getBytes();

        // Repetir la clave hasta que tenga la misma longitud que el texto
        int keyLen = keyBytes.length;
        int textLen = textBytes.length;
        byte[] newKeyBytes = new byte[textLen];
        for (int i = 0; i < textLen; i++) {
            newKeyBytes[i] = keyBytes[i % keyLen];
        }

        // Realizar la operación de cifrado XOR sobre cada par de bytes
        byte[] cipherBytes = new byte[textLen];
        for (int i = 0; i < textLen; i++) {
            cipherBytes[i] = (byte) (textBytes[i] ^ newKeyBytes[i]); // Aquí se utiliza el operador XOR "^"
        }

        // Convertir el arreglo de bytes en una cadena de texto
        String cipherText = new String(cipherBytes);

        // Devolver el texto cifrado o descifrado
        return cipherText;
    }

    // Ejemplo de uso del programa
    public static void main(String[] args) {
        String text = "Hola, este es un nuevo texto";
        String key = "secret";
        String cipherText = xorCipher(text, key);
        System.out.println("Texto original: " + text);
        System.out.println("Texto cifrado: " + cipherText);
        System.out.println("Texto descifrado: " + xorCipher(cipherText, key));
    }
}