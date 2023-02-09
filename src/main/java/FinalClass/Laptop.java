package FinalClass;

import java.util.*;

public class Laptop {
    private String model;
    private float diagonal;
    private String screenResolution;
    private int hardDiskD;
    private String operativeMemory;
    private String operatingSystem;
    private String color;
    public Laptop() {
    }
    public Laptop(String model, float diagonal, String screenResolution, int hardDisk,
                  String operativeMemory, String operatingSystem, String color) {
        this.model = model;
        this.diagonal = diagonal;
        this.screenResolution = screenResolution;

        this.hardDiskD = hardDisk;
        this.operativeMemory = operativeMemory;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
    public String getModel() {return model;}
    public float getDiagonal() {return diagonal;}
    public String getScreenResolution() {return screenResolution;}
    public int getHardDiskD() {return hardDiskD;}
    public String getOperativeMemory() {return operativeMemory;}
    public String getOperatingSystem() {return operatingSystem;}
    public String getColor() {return color;}

    public List<Laptop> filter(Set<Laptop> laptop, List<Laptop> laptopList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Здрасвуйте, Укажите каие параметры для ноут бука вы бы хотели иметь." +
                "\nУкажите размер жёсткого диска в гб\nВналичии : ");

        Set<Integer> sortedAndDistinctHD = new TreeSet<>();
        for (Laptop laptopStat : laptopList){
            sortedAndDistinctHD.add(laptopStat.getHardDiskD());
        }
        System.out.println(sortedAndDistinctHD);

        String enterHardDisk = scan.nextLine();
        int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
        System.out.println("Укажите количество оперативной памяти в Гб\nВналичии : ");

        Set<String> sortedAndDistinctRAM = new TreeSet<>();
        for (Laptop laptopStat : laptopList){
            sortedAndDistinctRAM.add(laptopStat.getOperativeMemory());
        }
        System.out.println(sortedAndDistinctRAM);

        String enterOperativeMemory = scan.nextLine();
        System.out.println("Укажите операционную систему\nВналичии : ");

        Set<String> sortedAndDistinctSYS = new TreeSet<>();
        for (Laptop laptopStat : laptopList){
            sortedAndDistinctSYS.add(laptopStat.getOperatingSystem());
        }
        System.out.println(sortedAndDistinctSYS);

        String enterOperatingSystem = scan.nextLine();
        System.out.println("Укажите цвет ноутбука\nВналичии : ");

        Set<String> sortedAndDistinctColor = new TreeSet<>();
        for (Laptop laptopStat : laptopList){
            sortedAndDistinctColor.add(laptopStat.getColor());
        }
        System.out.println(sortedAndDistinctColor);

        String enterColor = scan.nextLine();

        List<Laptop> listLaptop = new ArrayList<>();
        for (Laptop tempLaptop : laptop) {
            if (intParseEnterHardDisk == tempLaptop.hardDiskD) {
                if (enterOperativeMemory.equals(tempLaptop.operativeMemory)) {
                    if (enterOperatingSystem.equals(tempLaptop.operatingSystem)) {
                        if (enterColor.equals(tempLaptop.color)) {
                            listLaptop.add(tempLaptop);
                        }
                    }
                }
            }
        }
        return listLaptop;
    }

    public Set<Laptop> newFilter(Set<Laptop> laptop, List<Laptop> laptopList) {
        Scanner scan = new Scanner(System.in);
        Set<Laptop> listLaptop = new HashSet<>(laptop);

        System.out.println("Здрасвуйте, Укажите номер или номера критериев фильрации ноутбуков," +
                "\n1. Size hard disk\n2. Size HDD \n3. Operating system\n4. Color");
        String userRequest = scan.nextLine();

        for (int i = 0; i < userRequest.length(); i++) {
            if(1 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.println("Укажите размер жёсткого диска в гб\nВналичии : ");

                // Отдельный метод для создания сета доступных вариантов не делал так как,
                // всё равно пришлось бы проверять какой критерий и на каждый делать копию с иным .get***
                // , а переделывать на .get(критерий) уже слишком далеко.

                Set<Integer> sortedAndDistinctHD = new TreeSet<>();
                for (Laptop laptopStat : laptopList){
                    sortedAndDistinctHD.add(laptopStat.getHardDiskD());
                }
                System.out.println(sortedAndDistinctHD);


                String enterHardDisk = scan.nextLine();
                int intParseEnterHardDisk = Integer.parseInt(enterHardDisk);
                for (Laptop tempLaptop : laptop) {
                    if (intParseEnterHardDisk != tempLaptop.hardDiskD){
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(2 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите количество оперативной памяти в Гб\nВналичии : ");

                Set<String> sortedAndDistinctRAM = new TreeSet<>();
                for (Laptop laptopStat : laptopList){
                    sortedAndDistinctRAM.add(laptopStat.getOperativeMemory());
                }
                System.out.println(sortedAndDistinctRAM);

                String enterOperativeMemory = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperativeMemory.equals(tempLaptop.operativeMemory)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(3 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите операционную систему\nВналичии : ");

                Set<String> sortedAndDistinctSYS = new TreeSet<>();
                for (Laptop laptopStat : laptopList){
                    sortedAndDistinctSYS.add(laptopStat.getOperatingSystem());
                }
                System.out.println(sortedAndDistinctSYS);

                String enterOperatingSystem = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterOperatingSystem.equals(tempLaptop.operatingSystem) == false)) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }

            if(4 == Character.getNumericValue(userRequest.charAt(i))){
                System.out.println("Укажите цвет ноутбука\nВналичии : black, white");

                Set<String> sortedAndDistinctColor = new TreeSet<>();
                for (Laptop laptopStat : laptopList){
                    sortedAndDistinctColor.add(laptopStat.getColor());
                }
                System.out.println(sortedAndDistinctColor);

                String enterColor = scan.nextLine();
                for (Laptop tempLaptop : laptop) {
                    if ((enterColor.equals(tempLaptop.color)) == false) {
                        listLaptop.remove(tempLaptop);
                    }
                }
            }
        }
        return listLaptop;
    }


    @Override
    public String toString() {
        return "\nLaptop  ->  " + model + ",\ndiagonal = " + diagonal + ",\nscreenResolution = "
                + screenResolution
                + ",\nhardDisk = " + hardDiskD + ",\noperativeMemory = " + operativeMemory
                + ",\noperatingSystem = " + operatingSystem + ",\ncolor = " + color + "\n";
    }
}
