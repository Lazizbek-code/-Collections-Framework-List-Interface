package tasks;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TaskTwo {
    public static void main(String[] args) {
        // Ismlar listini yaratish
        ArrayList<String> ismlar = new ArrayList<>();

        // 20 tacha ismlar qo'shish
        ismlar.add("Ali");
        ismlar.add("Vali");
        ismlar.add("John");
        ismlar.add("Bob");
        ismlar.add("Alice");
        ismlar.add("Ali");
        ismlar.add("David");
        ismlar.add("Eva");
        ismlar.add("John");
        ismlar.add("Mary");
        ismlar.add("Ali");
        ismlar.add("Tom");
        ismlar.add("Alice");
        ismlar.add("John");
        ismlar.add("Vali");
        ismlar.add("Bob");
        ismlar.add("Alice");
        ismlar.add("Mary");
        ismlar.add("Tom");
        ismlar.add("Eva");

        System.out.println("Barcha ismlar:");
        // Elementlarni ekranga chiqarish
        for (String ism : ismlar) {
            System.out.println(ism);
        }

        // Dublikat ismlarni o'chirish
        HashSet<String> set = new HashSet<>(ismlar);
        ismlar.clear();
        ismlar.addAll(set);

        System.out.println("\nDublikat ismlar o'chirildi:");
        // Elementlarni ekranga chiqarish
        Iterator<String> iterator = ismlar.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
