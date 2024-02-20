package tasks;

import java.util.ArrayList;
import java.util.Random;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

public class TaskThree {
    public static void main(String[] args) {
        ArrayList<Book> list1 = new ArrayList<>();

        // list1 ni 10 ta kitob objectlari bilan to'ldirish
        for (int i = 1; i <= 10; i++) {
            list1.add(new Book("Book " + i, "Author " + i));
        }

        // list2 ni list1 dan tanlab olish
        ArrayList<Book> list2 = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(list1.size());
            list2.add(list1.get(index));
        }

        // list1 ni ekranga chiqarish
        System.out.println("list1:");
        for (Book book : list1) {
            System.out.println(book);
        }

        // list2 ni ekranga chiqarish
        System.out.println("\nlist2:");
        for (Book book : list2) {
            System.out.println(book);
        }

        // list1 dan list2 da bor elementlarni ochirib tashlash
        list1.removeAll(list2);
        System.out.println("\nlist1 after removing common elements:");
        for (Book book : list1) {
            System.out.println(book);
        }

        list2.clear(); // list2 ni tozalash
        System.out.println("\nlist2 after clearing:");
        for (Book book : list2) {
            System.out.println(book);
        }
    }
}

