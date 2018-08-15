package com.codingvalhalla.meredith.lexicalnianalyzator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Meredith
 */
public class MainClass {

    private static String file;
    private static BufferedReader reader;
    private static Scanner sc;
    private static boolean isConnencted = false;

    public static void main(String[] args) {
        ListHandler list = new ListHandler();
        LexAnal proxy = new LexAnal(list);
        String outputString = new String();

        do {
            try {
                sc = new Scanner(System.in);
                if (args.length == 0) {
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    file = args[0];
                }
                reader = new BufferedReader(new FileReader(file));
                isConnencted = true;
            } catch (ArrayIndexOutOfBoundsException ex1) {
                System.out.println("Error: File name is missing.");
                System.exit(0);
            } catch (FileNotFoundException ex2) {
                System.out.printf("Error with file: %s\nEnter valid name: ", ex2.getMessage());
                args[0] = sc.nextLine();
            } catch (Exception ex) {
                System.out.printf("Something went wrong: [%s]\n", ex.toString());
                System.exit(0);
            }
        } while (!isConnencted);
        try {
            int p = 0;
            while (reader.ready()) {
                char character = (char) reader.read();
                outputString += character;
                proxy.increaseChars();
                proxy.analyze(character);
            }
        } catch (Exception e) {
            System.out.printf("EX - %s\n", e.toString());
        }

        System.out.printf("Lexikalni analyza probehla.\nZdrojovy soubor: \"%s\" obsahoval:\n\n%s\n\n", file, outputString);
        System.out.println(list.toString());

    }

}
