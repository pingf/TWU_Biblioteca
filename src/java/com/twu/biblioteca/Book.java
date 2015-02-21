package com.twu.biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fcmeng on 2/21/15.
 */
public class Book {
    private String title,author;
    private Date date;

    public Book(String title, String author, String date_str) {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public String[] getInfo(){
        return new String[]{this.title, this.author, this.date.toString()};
    }
}
