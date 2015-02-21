package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fcmeng on 2/21/15.
 */
public class FakeStore {
    private List<Book> fake_books_list = new ArrayList<Book>();

    Book[] fake_books={
            new Book("Learning Python, 4th Edition","Mark Lutz","January 1, 2009"),
            new Book("Python for Unix and Linux System Administration","Noah Gift, Jeremy M. Jones","January 1, 2008")
    };
    public FakeStore() {
        for(Book book:fake_books){
            fake_books_list.add(book);
        }
    }

    public List<String[]> listBooks() {
        List<String[]> books_info = fake_books_list.stream().map(Book::getInfo).collect(Collectors.toList());
        return books_info;
    }
}
