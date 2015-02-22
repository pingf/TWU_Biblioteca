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
                Runnable[] actions = new Runnable[]{
                        BibliotecaApp::listBooks,
                        BibliotecaApp::checkoutBooks,
                        BibliotecaApp::returnBook
                };
                for (int i = 0; i < actions.length; i++) map.put(i, actions[i]);
            } while (!isOptionValid(map, option));

            if(isExitOption(option)) {
                System.out.println("Goodbye!");
                break;
            }
            map.get(option).run();
        }
    }

    private static void printMenu() {
        System.out.println("0 - List Books");
        System.out.println("1 - Checkout Book");
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

    private static void checkoutBooks() {
        List<String[]> books_info = store.listBooks();
        for(int i=0;i<books_info.size();i++){
            System.out.printf("%d %s (%s)\n",i, books_info.get(i)[0], books_info.get(i)[3]);
        }
        System.out.println("-1 - Back");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if(option==-1) return;
        store.checkoutBook(books_info.get(option)[0]);
    }

    private static void returnBook(){
        System.out.println("Input Bookname:");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if(name.equals("back")) return;
        store.returnBook(name);
    }
}
