package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fcmeng on 2/21/15.
 */
public class FakeStore {
    private List<BookTag> book_tags = new ArrayList<BookTag>();
    BookTag[] fake_tags ={
            new BookTag("Learning Python, 4th Edition","Mark Lutz","January 1, 2009",1),
            new BookTag("Python for Unix and Linux System Administration","Noah Gift, Jeremy M. Jones","January 1, 2008",1)
    };
    public FakeStore() {
        for(BookTag bookTag : fake_tags){
            book_tags.add(bookTag);
        }
    }

    public boolean checkout_book(String bookname){
        BookTag bookTag = find_book(bookname);
        if(bookTag==null) return false;
        return bookTag.checkout_book();
    }

    public boolean return_book(String bookname){
        BookTag bookTag = find_book(bookname);
        if(bookTag==null) return false;
        bookTag.return_book();
        return true;
    }

    public BookTag find_book(String bookname){
        for(BookTag bookTag : book_tags){
            if(bookTag.getName()==bookname){
                return bookTag;
            }
        }
        return null;
    }

    public List<String[]> listBooks() {
        List<String[]> books_info = new ArrayList<String[]>();
        for(BookTag bookTag : book_tags){
            if(bookTag.getCount()>0) books_info.add(bookTag.getInfo());
        }
        return books_info;
    }
}
