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
            int option = 0;
            do {
                option = sc.nextInt();
                Runnable[] actions = new Runnable[]{
                        BibliotecaApp::listBooks,
                        BibliotecaApp::checkoutBooks,
                        BibliotecaApp::returnBook,
                        BibliotecaApp::listMovies,
                        BibliotecaApp::checkoutMovies,
                        BibliotecaApp::returnMovie,
                        BibliotecaApp::userInfo
                };
                for (int i = 0; i < actions.length; i++) map.put(i, actions[i]);
            } while (!isOptionValid(map, option));

            if (isExitOption(option)) {
                System.out.println("Goodbye!");
                break;
            }
            System.out.println(option);
            map.get(option).run();
        }
    }

    private static void printMenu() {
        System.out.println("0 - List Books");
        System.out.println("1 - Checkout Book");
        System.out.println("2 - Return Book");
        System.out.println("3 - List Movies");
        System.out.println("4 - Checkout Movies");
        System.out.println("5 - Return Movie");
        System.out.println("6 - User Info");
        System.out.println("-1 - Quit");
    }

    private static boolean isExitOption(int option) {
        return option == -1;
    }

    private static boolean isOptionValid(HashMap<Integer, Runnable> map, int option) {
        boolean valid = isExitOption(option) || map.containsKey(option);
        if (!valid) System.out.println("Select a valid option!");
        return valid;
    }

    private static void listBooks() {
        List<String[]> books_info = store.listBooks();
        for (String[] book_info : books_info) {
            System.out.printf("%s %s %s\n", book_info[0], book_info[1], book_info[2]);
        }
    }

    private static void checkoutBooks() {
        List<String[]> books_info = store.listBooks();
        for (int i = 0; i < books_info.size(); i++) {
            System.out.printf("%d %s (%s)\n", i, books_info.get(i)[0], books_info.get(i)[3]);
        }
        System.out.println("-1 - Back");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == -1) return;
        store.checkoutBook(books_info.get(option)[0]);
    }

    private static void returnBook() {
        System.out.println("Input Bookname:");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.equals("back")) return;
        store.returnBook(name);
    }

    private static void listMovies() {
        List<String[]> movies_info = store.listMovies();
        for (String[] movie_info : movies_info) {
            System.out.printf("%s %s %s %s\n", movie_info[0], movie_info[1], movie_info[2], movie_info[3]);
        }
    }

    private static void checkoutMovies() {
        List<String[]> movies_info = store.listMovies();
        for (int i = 0; i < movies_info.size(); i++) {
            System.out.printf("%d %s (%s)\n", i, movies_info.get(i)[0], movies_info.get(i)[4]);
        }
        System.out.println("-1 - Back");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == -1) return;
        store.checkoutMovie(movies_info.get(option)[0]);
    }

    private static void returnMovie() {
        System.out.println("Input Moviename:");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        if (name.equals("back")) return;
        store.returnMovie(name);
    }

    private static void userInfo() {
        String[] user_info = store.current_user_info();
        System.out.printf("id: %s name: %s email: %s phone: %s\n", user_info[0], user_info[1], user_info[2], user_info[3]);
    }
}
