import java.util.*;


// Пусть дан произвольный список целых чисел,
// удалить из него четные числа
// (в языке уже есть что-то готовое для этого)
//2. Задан целочисленный список ArrayList.
// Найти минимальное, максимальное и среднее
// арифметическое из этого списка.
//3. Пройти по списку из задания 2 с урока
// и удалить повторяющиеся элементы.
public class Main {
    public static void main(String[] args) {


        semi0202();


        ArrayList<Integer> randomIntsArrayList = CreateRandomIntsArrayList();

        DeleteEvensIntsFromArrayList(randomIntsArrayList);

        MinMaxAndArithmeticMeanFromIntArrayList(randomIntsArrayList);

    }

    private static void MinMaxAndArithmeticMeanFromIntArrayList(ArrayList<Integer> randomIntsArrayList) {


        int max = randomIntsArrayList.get(0);
        int min = randomIntsArrayList.get(0);

        for (Iterator<Integer> iterator = randomIntsArrayList.iterator(); iterator.hasNext(); ) {
            Integer number = iterator.next();
            if (number >= max) {
                max = number;
            } else if (number <= min) {
                min = number;
            }
        }


        //int mean = (min+max)/2;  // simple mean

        int sum = 0;
        for (int s : randomIntsArrayList) {
            sum += s;
        }

        //System.out.println(sum);

        int arMean = sum / randomIntsArrayList.size();

        System.out.println(min + " < " + arMean + " > " + max);

        Collections.sort(randomIntsArrayList);
        System.out.println("Sorted List: " + randomIntsArrayList);

    }

    private static void DeleteEvensIntsFromArrayList(ArrayList<Integer> randomIntsArrayList) {

        for (Iterator<Integer> iterator = randomIntsArrayList.iterator(); iterator.hasNext(); ) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                //System.out.println("This is Even Number: " + number);
                iterator.remove();
            }
        }

        System.out.println(randomIntsArrayList);

    }

    private static ArrayList CreateRandomIntsArrayList() {

        Random random = new Random();

        ArrayList<Integer> randomIntsArrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            randomIntsArrayList.add(random.nextInt(100));
        }

        //System.out.println(randomIntsArrayList);

        return randomIntsArrayList;

    }

    private static void semi0202() {

        String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

        List<String> planets = new ArrayList<>();

        HashMap<String, Integer> planetCount = new HashMap<>();

        Random random = new Random();

        ArrayList<String> manyPlanets = new ArrayList<>();


        for (int i = 0; i < 20; i++) {

            manyPlanets.add(solarSystemPlanets[random.nextInt(solarSystemPlanets.length)]);
            planets.add(solarSystemPlanets[random.nextInt(solarSystemPlanets.length)]);
        }

        //System.out.println(manyPlanets);

/*
        for (String planet : planets ){

            System.out.print("%s\t%s", planet , Collections.frequency(planets, planet));
        }*/


        for (String planet : planets) {

            if (planetCount.containsKey(planet)) {
                planetCount.put(planet, planetCount.get(planet) + 1);
            } else {
                planetCount.put(planet, 1);
            }
        }

        for (String planet : planetCount.keySet()) {
            System.out.printf("%s\t%s%n", planet, planetCount.get(planet));
        }

        planets.add("Pluto");

        planets.retainAll(Arrays.asList(solarSystemPlanets));
        System.out.println(planets);


   /*     Set<String> set = new LinkedHashSet<>();

        set.addAll(manyPlanets);

        manyPlanets.clear();

        manyPlanets.addAll(set);

        System.out.println(manyPlanets);
        */

        // в курсах других языков говорилось что чистка дупликатов через прогонку по классу -
        // который принимает только уникальные значения крайне нежелательны, по этому
        // тут ещё одим метод через перебор

        ArrayList<String> newList = new ArrayList<>();

        for (String element : manyPlanets) {

            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        System.out.println(newList);

    }
}
