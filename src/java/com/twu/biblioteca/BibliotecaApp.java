package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private static FakeStore store = new FakeStore();
    public static void main(String[] args) {
        System.out.println("0 - List Books");

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if(i==0) {
            List<String[]> books_info = store.listBooks();
            for(String[] book_info:books_info){
                System.out.printf("%s %s %s\n",book_info[0],book_info[1],book_info[2]);
            }
        }
    }
}
