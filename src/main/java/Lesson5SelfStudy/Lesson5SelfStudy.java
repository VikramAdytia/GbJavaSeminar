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
                //System.out.println(data);
                String[] splitData = data.split(" ");
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

    }

    public static void sortName(Map<String, Integer> map){
        Map<Integer, ArrayList<String>> sortMap = new HashMap<>();
        ArrayList<Integer> listCount = new ArrayList<>();
        for(var item: map.entrySet()) {
            if (listCount.contains(item.getValue()) == false) listCount.add(item.getValue());
        }
        listCount.sort(null);
        for (int i = listCount.size()-1; i > -1; i--){
            for (var item: map.entrySet()){
                if (listCount.get(i) == item.getValue()) System.out.printf("%s : %d \n", item.getKey(), item.getValue());
            }
        }
    }

    private static String numberGenerator() {

        Random generator = new Random();

        int num1, num2, num3;

        num1 = generator.nextInt (900) + 100;
        num2 = generator.nextInt (643) + 100;
        num3 = generator.nextInt (9000) + 1000;

        String number = (num1+"-"+num2+"-"+num3);
        //System.out.println(number);
        return number;
    }
}
