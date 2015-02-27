package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcmeng on 2/21/15.
 */
public class FakeStore {
    private List<BookTag> book_tags = new ArrayList<BookTag>();
    private List<CheckoutTag> checkout_tags = new ArrayList<CheckoutTag>();
    private String current_user="123-4567";
    BookTag[] fake_tags ={
            new BookTag("Learning Python, 4th Edition","Mark Lutz","January 1, 2009",3),
            new BookTag("Python for Unix and Linux System Administration","Noah Gift, Jeremy M. Jones","January 1, 2008",2)
    };
    public FakeStore() {
        for(BookTag bookTag : fake_tags){
            book_tags.add(bookTag);
        }
    }

    public boolean checkoutBook(String bookname){
        BookTag bookTag = findBook(bookname);
        if(bookTag==null) return false;
        checkout_tags.add(new CheckoutTag(current_user,bookTag.getName()));
        return bookTag.checkoutBook();
    }

    public boolean returnBook(String bookname){
        BookTag bookTag = findBook(bookname);
        if(bookTag==null) return false;
        bookTag.returnBook();
        return true;
    }

    public BookTag findBook(String bookname){
        for(BookTag bookTag : book_tags){
            if(bookTag.getName().equals(bookname)){
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

    public List<String[]> checkoutStatus() {
        List<String[]> checkouts_info = new ArrayList<String[]>();
        for(CheckoutTag checkoutTag : checkout_tags){
            checkouts_info.add(checkoutTag.getInfo());
        }
        return checkouts_info;
    }
}
