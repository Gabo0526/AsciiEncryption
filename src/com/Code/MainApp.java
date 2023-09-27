// Author: Gabriel Vasconez
package com.Code;

import java.util.Scanner;

public class MainApp {

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opcion:\n[1] Encriptar texto\n[2] Desencriptar texto\n[0] Salir");
        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
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
                        System.out.println("\nIngrese el texto a cifrar: ");
                        AsciiEncryption asciiEncryption = new AsciiEncryption(scanner.nextLine());
                        System.out.printf("El texto encriptado es: %s\n\n", asciiEncryption.getCipherString());
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
