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
public class BookTag {
    private String name,author;
    private Date date;
    private Integer count;

    public BookTag(String name, String author, String date_str, Integer count) {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.author = author;
        this.date = date;
        this.count = count;
    }

    public boolean checkoutBook(){
        if(this.count>0) {
            this.count--;
            return true;
        }
        return false;
}

    public void returnBook(){
        this.count++;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCount() {
        return this.count;
    }
    public String[] getInfo(){
        return new String[]{getName(), this.author, this.date.toString(), this.count.toString()};
    }
}
