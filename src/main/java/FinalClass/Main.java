package FinalClass;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Laptop hp_pavilion_g6 = new Laptop("vn_gazebo_d20", 16, "4k",
                500, "16", "LLIindows", "black");
        Laptop hp_galaxy_x64 = new Laptop("vn_cosmos_<x>", 14, "FullHD",
                500, "8", "LLIindows", "white");

        Laptop samsung_a52 = new Laptop("three_stars_52", 18, "FullHD",
                300, "8", "LLIindows", "black");

        Laptop samsung_m31s = new Laptop("three_stars_31", 16, "4k",
                1000, "16", "Linux", "black");

        Laptop lenovo_gtx76 = new Laptop("lenin_gtx911", 16, "FullHD",
                700, "8", "LLIindows", "white");

        Laptop macbook_14pro = new Laptop("dastext_19ora", 17, "4k",
                1000, "8", "nos", "white");

        Laptop asus_x515 = new Laptop("sus_x515", 17, "FullHD",
                300, "4", "LLIindows", "black");


        Laptop acer_air5 = new Laptop("cera_ar15", 19, "FullHD",
                600, "8", "LLIindows", "black");


        Laptop acer_air6 = new Laptop("cera_ar10" ,18, "4k",
                500, "16", "LLIindows", "black");

        Laptop acer_a313 = new Laptop("cera_i717", 16, "FullHD",
                500, "8", "LLIindows", "black");


        List<Laptop> laptopList = List.of(hp_galaxy_x64, hp_pavilion_g6, samsung_m31s, samsung_a52, lenovo_gtx76, macbook_14pro, acer_a313, acer_air5, acer_air6, asus_x515);

        //Set <Laptop> laptop = new HashSet<>();
        Set<Laptop> laptop = Set.of(hp_galaxy_x64, hp_pavilion_g6, samsung_m31s, samsung_a52, lenovo_gtx76, macbook_14pro, acer_a313, acer_air5, acer_air6, asus_x515);
//        laptop.add(hp_pavilion_g6);
//        laptop.add(hp_galaxy_x64);
//        laptop.add(samsung_a52);
//        laptop.add(samsung_m31s);
//        laptop.add(lenovo_gtx76);
//        laptop.add(macbook_14pro);
//        laptop.add(asus_x515);
//        laptop.add(acer_air5);
//        laptop.add(acer_air6);
//        laptop.add(acer_a313);


        Laptop FilterLaptop = new Laptop();
        // System.out.println("по вашему запросу найдено: " + FilterLaptop.filter(laptop, laptopList));



        // наверное стоило отобразить уменьшение выбора можно было через выдачу промежуточных результатов фильтрации,
        // иначе сложно подобрать вариант если больше двух критериев
        System.out.println(FilterLaptop.newFilter(laptop, laptopList));

    }

}
