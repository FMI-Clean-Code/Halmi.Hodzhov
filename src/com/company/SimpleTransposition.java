package com.company;

import java.util.Scanner;

/**
 * Created by Halmi on 3/27/2018.
 */
public class SimpleTransposition {

    public static char[][] createEncryptionMatrix(String plainText, String cipher) {

        char[] charsOfPlainText = plainText.toCharArray();

        int columns = cipher.length();
        int rows = (int) Math.ceil((double) charsOfPlainText.length / columns);

        char[][] matrix = new char[rows][columns];

        int currentChar = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (currentChar < charsOfPlainText.length) {
                    matrix[i][j] = charsOfPlainText[currentChar++];
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }
        return matrix;
    }

    public static String encrypt(String plainText, String cipherKey) {

        char[][] matrix = createEncryptionMatrix(plainText, cipherKey);
        char[] charsOfPlainText = plainText.toCharArray();

        int columns = cipherKey.length();
        int rows = (int) Math.ceil((double) charsOfPlainText.length / columns);

        char[] encryptedText = new char[rows * columns];

        int index = 0;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                encryptedText[index++] = matrix[j][i];
            }

        }

        return new String(encryptedText);
    }

    public static char[][] createDecryptionMatrix(String cipherText, String cipher) {
        char[] charsOfCipherText = cipherText.toCharArray();

        int columns = cipher.length();
        int rows = (int) Math.ceil((double) charsOfCipherText.length / columns);

        char[][] matrix = new char[rows][columns];
        int currentChar = 0;

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (currentChar < charsOfCipherText.length) {
                    matrix[j][i] = charsOfCipherText[currentChar++];
                } else {
                    matrix[j][i] = 'X';
                }
            }
        }

        return matrix;
    }

    public static String decrypt(String cipherText, String cipherKey) {

        char[] charsOfCipherText = cipherText.toCharArray();

        int columns = cipherKey.length();
        int rows = (int) Math.ceil((double) charsOfCipherText.length / columns);

        char[][] matrix = createDecryptionMatrix(cipherText, cipherKey);

        char[] decryptedText = new char[rows * columns];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                decryptedText[index++] = matrix[i][j];
            }
        }

        return new String(decryptedText);
    }

    public static void main(String[] args) {

        System.out.println("Enter a string to cipher");

        Scanner scanner = new Scanner(System.in);

        String toCipher = scanner.nextLine();

        System.out.println("Enter cipher key : For example  'beauty' : ");

        String cipherKey = scanner.nextLine();
        String encrypted = encrypt(toCipher, cipherKey);

        System.out.println("Encrypted string is: " + encrypted);
    }
}
