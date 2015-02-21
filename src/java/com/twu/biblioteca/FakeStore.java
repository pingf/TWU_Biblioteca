package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcmeng on 2/21/15.
 */
public class FakeStore {
    private List<String> fake_books = new ArrayList<String>();

    public FakeStore() {
        String[] fake_book_titles={
                "Learning Python, 4th Edition",
                "Python for Unix and Linux System Administration",
                "Python Pocket Reference, 4th Edition"
        };
        for(String book:fake_book_titles){
            fake_books.add(book);
        }

    }

    public List<String> listBooks() {
        return fake_books;
    }
}
