package com.code.tests;

import com.code.asciiEncryption.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Command-line application for encrypting and decrypting text in ASCII format.
 * Author: Gabriel Vasconez
 */
public class IntArrayTextAsciiEncryptionApp {

    /**
     * Displays a menu and prompts the user for an option.
     *
     * @return The selected option.
     */
    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opcion:\n[1] Encriptar texto\n[2] Desencriptar texto\n[0] Salir");
        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    /**
     * Reads text input from the user, terminates when a specified stop suffix is entered.
     *
     * @return The entered text without the stop suffix.
     */
    public static String getText() {
        String stopSuffix = "fin";
        Scanner scanner = new Scanner(System.in);
        String dataInput;
        String output;
        StringBuilder stringBuilder0 = new StringBuilder();

        System.out.printf("Ingrese el texto a cifrar. Para terminar, escriba la palabra: %s\n", stopSuffix);

        do {
            dataInput = scanner.nextLine();
            stringBuilder0.append(dataInput);
            stringBuilder0.append(" ");
        } while (!dataInput.endsWith(stopSuffix));

        char[] stringBuilderCharArray = stringBuilder0.toString().toCharArray();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i = 0; i < stringBuilderCharArray.length - (stopSuffix.length() + 1); i++) {
            stringBuilder1.append(stringBuilderCharArray[i]);
        }

        output = stringBuilder1.toString();

        return output;
    }

    /**
     * Main method to run the application.
     *
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ASCII ENCRYPTOR AND DECRYPTOR\n");

        int option = '0';
        do {
            try {
                option = menu();
                switch (option) {
                    case 1:
                        AsciiEncryption asciiEncryption = new AsciiEncryption(getText());
                        System.out.printf("El texto encriptado es: %s\n\n", Arrays.toString(asciiEncryption.getCiphertextIntArray()));
                        break;
                    case 2:
                        System.out.println("\nIngrese el texto a descifrar: ");
                        String rawCiphertext = scanner.nextLine();
                        StringBuilder stringBuilder = new StringBuilder();

                        for (int i = 1; i < rawCiphertext.length() - 1; i++) {
                            stringBuilder.append(rawCiphertext.toCharArray()[i]);
                        }

                        String ciphertext = stringBuilder.toString();

                        StringTokenizer stringTokenizer = new StringTokenizer(ciphertext, ", ");
                        String token;

                        int[] ciphertextIntArray = new int[stringTokenizer.countTokens()];

                        for (int i = 0; i < ciphertextIntArray.length; i++) {
                            token = stringTokenizer.nextToken();
                            ciphertextIntArray[i] = Integer.parseInt(token);
                        }

                        AsciiDecryption asciiDecryption = new AsciiDecryption(ciphertextIntArray);
                        System.out.printf("El texto desencriptado es: %s\n\n", asciiDecryption.getDecipheredText());
                        break;
                    default:
                        if (option != 0) {
                            System.out.println("Ingrese una opcion correcta!\n");
                        }
                        break;
                }

            } catch (Exception e) {
                System.out.println("Ingrese solo numeros!\n");
            }
        } while (option != 0);
        scanner.close();
    }
}
