package Lesson5SelfStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Lesson5SelfStudy {

    public static void main(String[] args) {

        try {

            Map<String, String[]> phoneBook = new HashMap<>();
            File myObj = new File("namesAndSurnames.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tempPhones = {numberGenerator(), numberGenerator()};
                phoneBook.put(data,tempPhones);
            }

            myReader.close();

            printEntirePhoneBook(phoneBook);

            nameRepeat(phoneBook);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void printEntirePhoneBook(Map<String,String[]> phoneBook) {

        for (String names :  phoneBook.keySet () ) {

            System.out.println(names);
            System.out.println(Arrays.stream(phoneBook.get(names)).toList());
        }

    }

    public static void nameRepeat(Map<String, String[]> map){

        List<String> frequency = new ArrayList<>();



        for(String fullName: map.keySet()){
            String name = fullName.split(" ")[0];
            //System.out.println(name);
            frequency.add(name);
        }

        Map<String,Integer> repeat = frequency.stream().collect(Collectors.toMap(e -> e, e -> 1,Integer::sum));

        repeat.forEach((k,v) -> System.out.println(k + ": " + v));

        System.out.println("____________");


        sortName(repeat);

        heapSort(repeat);


    }

    private static void heapSort(Map<String, Integer> repeat) {
        /*for (String character : repeat.keySet()) {
            System.out.println(character);
            System.out.println(repeat.get(character));

        }*/

        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> (repeat.get(b) - repeat.get(a)));
        heap.addAll(repeat.keySet());

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            String c = heap.poll();
            for (int i = 0; i < repeat.get(c); i++) {
                sb.append(c);
            }
        }

        System.out.println("heapsort");

        System.out.println(sb);
    }

    public static void sortName(Map<String, Integer> map){
        ArrayList<Integer> listCount = new ArrayList<>();
        for(var item: map.entrySet()) {
            if (!listCount.contains(item.getValue())) listCount.add(item.getValue());
        }
        listCount.sort(null);
        for (int i = listCount.size()-1; i > -1; i--){
            for (var item: map.entrySet()){
                if (Objects.equals(listCount.get(i), item.getValue())) System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }

    private static String numberGenerator() {

        Random generator = new Random();

        int num1, num2, num3;

        num1 = generator.nextInt (900) + 100;
        num2 = generator.nextInt (643) + 100;
        num3 = generator.nextInt (9000) + 1000;

        return (num1+"-"+num2+"-"+num3);
    }
}
