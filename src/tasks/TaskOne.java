package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskOne {
    public static void main(String[] args) {
        // Uzunligi 30 bo'lgan ArrayList yaratish
        ArrayList<Integer> list = new ArrayList<>();

        // 1 dan 100 gacha bo'lgan random sonlar bilan listni to'ldirish
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(rand.nextInt(100) + 1);
        }

        // Listni qiymatlari chiqarish
        System.out.println("Birinchi marta chiqarish:");
        System.out.println(list);

        // Indexdan foydalanib o'zgartirish
        for (int i = 0; i < list.size(); i++) {
            // Indexdan foydalanib random son olish
            int randomIndex = rand.nextInt(list.size());
            int temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }

        // Listni qiymatlari chiqarish
        System.out.println("\nKeyingi chiqarish:");
        System.out.println(list);
    }
}
