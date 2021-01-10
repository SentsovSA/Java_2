package Lesson3.HW;

import java.sql.SQLOutput;
import java.text.MessageFormat;
import java.util.*;

public class HW3 {
    public static void main(String[] args) {
        ex1();
        ex2();
    }

    private static void ex1() {
        String[] colors = {"red", "yellow", "white", "black", "pink", "purple", "red", "orange", "blue", "brown", "grey", "green",
                "green", "black", "red"};
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : colors) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
    }

    private static void ex2() {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Водочкин", "88005553535");
        phonebook.add("Коньяков", "89997777777");
        phonebook.add("Пивоваров", "87779999999");
        phonebook.add("Самбукин", "86663636363");
        phonebook.add("Закускин", "87772332323");
        phonebook.add("Водочкин", "89995656565");
        phonebook.add("Закускин", "83633734895");
        phonebook.add("Водочкин", "88003551298");
        phonebook.add("Пивоваров", "89008887643");

        System.out.println("Номера по запросу <<Водочкин>> : " + phonebook.get("Водочкин"));
        System.out.println("Номера по запросу <<Коньяков>> : " + phonebook.get("Коньяков"));
        System.out.println("Номера по запросу <<Пивоваров>> : " + phonebook.get("Пивоваров"));
        System.out.println("Номера по запросу <<Самбукин>> : " + phonebook.get("Самбукин"));
        System.out.println("Номера по запросу <<Закускин>> : " + phonebook.get("Закускин"));


    }
}
    class Phonebook{
        private Map<String, List<String>> pb = new HashMap<>();
        private List<String> numberList;

        public void add(String surname, String phone_number) {
            if (pb.containsKey(surname)) {
                numberList = pb.get(surname);
                numberList.add(phone_number);
                pb.put(surname, numberList);
            } else {
                numberList = new ArrayList<>();
                numberList.add(phone_number);
                pb.put(surname, numberList);
            }
        }

        public List<String> get(String surname) {
            return pb.get(surname);
        }

    }
