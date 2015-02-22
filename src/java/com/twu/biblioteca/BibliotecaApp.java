package com.twu.biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static FakeStore store = new FakeStore();
    public static void main(String[] args) {

        HashMap<Integer, Runnable> map = new HashMap<Integer, Runnable>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int option=0;
            do {
                option = sc.nextInt();
                System.out.println(option);
                System.out.println("=========");
                Runnable[] actions = new Runnable[]{
                        () -> listBooks()
                };
                for (int i = 0; i < 1; i++) map.put(i, actions[i]);

            } while (!isOptionValid(map, option));

            if(isExitOption(option)) {
                System.out.println("Goodbye!");
                break;
            }
            map.get(option).run();
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("0 - List Books");
        System.out.println("-1 - Quit");
    }

    private static boolean isExitOption(int option){
        return option==-1;
    }

    private static boolean isOptionValid(HashMap<Integer, Runnable> map, int option) {
        boolean valid = isExitOption(option) || map.containsKey(option);
        if(!valid) System.out.println("Select a valid option!");
        return valid;
    }

    private static void listBooks() {
        List<String[]> books_info = store.listBooks();
        for(String[] book_info:books_info){
            System.out.printf("%s %s %s\n",book_info[0],book_info[1],book_info[2]);
        }
    }
}
