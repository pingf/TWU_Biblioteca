package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static FakeStore store = new FakeStore();
    public static void main(String[] args) {
        System.out.println("0 - List Books");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        HashMap<Integer, Runnable> map = new HashMap<Integer, Runnable>();
        Runnable[] actions = new Runnable[]{
                new Runnable() {public void run() {listBooks();}}
        };
        for(int i=0;i<1;i++) map.put(i,actions[i]);
        map.get(option).run();
    }

    private static void listBooks() {
        List<String[]> books_info = store.listBooks();
        for(String[] book_info:books_info){
            System.out.printf("%s %s %s\n",book_info[0],book_info[1],book_info[2]);
        }
    }
}
