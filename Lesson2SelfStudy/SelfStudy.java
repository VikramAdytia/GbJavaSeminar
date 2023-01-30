package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.GregorianCalendar ;
import java.time.temporal.ValueRange;


public class Main {
    public static void main(String[] args) {
        PalindromeCheck(WordReciver());
        OneHundredTimesTest();
    }

    private static void OneHundredTimesTest() {

        try(PrintWriter pw = new PrintWriter("OneHundredTimesTest.txt")) {
            pw.print("Test".repeat(100));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static String WordReciver() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("check for a palindrome \n");
        String word = scanner.nextLine();
        scanner.close();

        return word;

    }
    private static void PalindromeCheck(String word) {

        word = word.toLowerCase();
        int i = 0;
        int j = word.length() - 1;
        boolean paly = false ;
        while (i < j) {
            paly = (word.charAt(i) == word.charAt(j));
            i++;
            j--;
        }
        // это следует оставить так или всё простое следуте сводить в одну строку по возможности?
        System.out.println(word +" is "+  paly + " palindrome");

    }

}