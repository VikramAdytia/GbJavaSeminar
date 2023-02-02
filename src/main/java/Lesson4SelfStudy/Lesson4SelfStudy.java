package Lesson4SelfStudy;

import java.util.LinkedList;
import java.util.Scanner;


//1. Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так,
// чтобы последняя введенная была первой в списке,
// а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.

//2. Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.

public class Lesson4SelfStudy {

    public static LinkedList<String> InitList(){
        LinkedList<String> list = new LinkedList<>();
        list.add("Start");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("End");
        return list;
    }

    public static LinkedList<String> reverseLinkList (LinkedList<String> list){

        LinkedList<String> reverseList = new LinkedList<>();

        for (String s : list) {
            reverseList.addFirst(s);
        }

        return reverseList;

    }
    public static void main(String[] args) {
        LinkedList<String> listFirst = InitList();
        System.out.println(listFirst);
        System.out.println(reverseLinkList(listFirst));

        Menu(listFirst);

    }

    private static void Menu(LinkedList<String> list){

        System.out.println("Введиет операци: Принимает от пользователя и “запоминает” строки." +
                " Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.\n;" +
                " Если введено revert, удаляет предыдущую введенную строку из памяти. " +
                " Если введено end - завершение работы");

        Scanner sc = new Scanner(System.in);
        String cmd = sc.nextLine();

        switch (cmd) {
            case "":
                System.out.println("Строка не должна быть пустой");
                Menu(list);
            case "print":
                System.out.println("command print");
                System.out.println(reverseLinkList(list));
                Menu(list);
            case "revert":
                System.out.println("command revert");
                list.removeLast();
                Menu(list);
            case "end":
                System.out.println("command end");
            default:
                System.out.println("command add");
                list.addLast(cmd);
                Menu(list);
        }

    }
}
