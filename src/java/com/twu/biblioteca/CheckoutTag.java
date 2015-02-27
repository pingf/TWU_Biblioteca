package com.twu.biblioteca;

/**
 * Created by fcmeng on 2/27/15.
 */
public class CheckoutTag {
    private String user, bookname;

    public CheckoutTag(String user, String bookname) {
        this.user = user;
        this.bookname = bookname;
    }

    public String[] getInfo() {
        return new String[]{this.user, this.bookname};
    }
}
