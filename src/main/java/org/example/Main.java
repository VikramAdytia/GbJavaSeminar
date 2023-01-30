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
        //ex2();
        //ex3();
        ex4_1(ex4());
        ex5();
    }

    private static void ex5() {

        try(PrintWriter pw = new PrintWriter("OneHundredTimesTest.txt")) {
            pw.print("Test".repeat(100));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean ex4_1(String word) {

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

        return  paly ;

    }

    private static String ex4() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("check for a palindrome \n");
        String word = scanner.nextLine();
        scanner.close();

        return word;

    }

    private static void ex3() {
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();

        // int year = 1988 ;

        Scanner scanner = new Scanner(System.in);
        System.out.println("guess a year \n");
        int year = Integer.parseInt(scanner.next());
        scanner.close();

        // втроеный метод для кросс-проверки

        boolean isLR = ((year%4) == 0) ^ (((year%100) == 0) ^ ((year%400) == 0)) ;
        System.out.println(isLR);
        boolean isLeapYear = cal.isLeapYear(year);
        System.out.println(year +" is "+  isLeapYear + " leap year");

    }

    private static void ex2() {
        int[] binaryArray = new int[15];
        Random random = new Random();
        for (int i = 0; i < binaryArray.length; i++) {
            binaryArray[i] = random.nextInt(4);
        }

        System.out.println(Arrays.toString(binaryArray));

        int max = binaryArray[0];
        int min = binaryArray[0];
        int val = 3;


        for (int num : binaryArray) {
            if (num >= max) {
                max= num;
            }
            else if (num <= min) {
                min = num;
            }
        }

        System.out.println(min + " <> " + max);

        int r = 1;
        for (int l = 0; l <= (binaryArray.length - r); l++) {
        // здесь можно увидеть питониста который привык обращатся к множеству по обратному индексу,есть ли способы которые более подходят для Java
            if (binaryArray[l] == val){
                if (binaryArray[binaryArray.length - r] == val) {
                    while (binaryArray[binaryArray.length - r] == val) {
                        if (l >= (binaryArray.length - r)) {
                            break;
                            // это было нужно чтобы устранить редкие случаи когда левые значения при проверке сдвигали правых левее себя вынуждая переставлять элементы на границе сортировки
                            // что более загружает код: while вместо for или if-break после while вызываемый после двух if ов?
                        }
                        r++;
                    }
                }
                binaryArray[l] = binaryArray[binaryArray.length - r];
                binaryArray[binaryArray.length - r] = val;
                r++ ;
            }
            }

        System.out.println(Arrays.toString(binaryArray));

    }

}