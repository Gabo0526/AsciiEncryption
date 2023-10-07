// Author: Gabriel Vasconez
package com.code.tests;

import com.code.asciiEncryption.*;

import java.util.Scanner;

public class StringTextAsciiEncryptionApp {

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opcion:\n[1] Encriptar texto\n[2] Desencriptar texto\n[0] Salir");
        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    public static String getText() {
        String stopConstant = "fin";
        Scanner scanner = new Scanner(System.in);
        String dataInput;
        String output;
        StringBuilder stringBuilder0 = new StringBuilder();

        System.out.printf("Ingrese el texto a cifrar. Para terminar, escriba la palabra: %s\n", stopConstant);

        do {
            dataInput = scanner.nextLine();
            stringBuilder0.append(dataInput);
            stringBuilder0.append(" ");
        } while (!dataInput.endsWith(stopConstant));

        char[] stringBuilderCharArray = stringBuilder0.toString().toCharArray();
        StringBuilder stringBuilder1 = new StringBuilder();

        for (int i = 0; i < stringBuilderCharArray.length - (stopConstant.length() + 1); i++) {
            stringBuilder1.append(stringBuilderCharArray[i]);
        }

        output = stringBuilder1.toString();

        return output;
    }

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
                        System.out.printf("El texto encriptado es: %s\n\n", asciiEncryption.getCiphertextString());
                        break;
                    case 2:
                        System.out.println("\nIngrese el texto a descifrar: ");
                        AsciiDecryption asciiDecryption = new AsciiDecryption(scanner.nextLine());
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
