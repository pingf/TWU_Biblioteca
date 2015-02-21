package com.twu.biblioteca;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by fcmeng on 2/21/15.
 */
public class BookTest {
    @Test
    public void itShouldReturnBooksInfo() throws ParseException {

        Book book = new Book("Learning Python, 4th Edition", "Mark Lutz", "January 1, 2009");

        String[] expected_array={"Learning Python, 4th Edition","Mark Lutz","Thu Jan 01 00:00:00 CST 2009"};

        assertArrayEquals(expected_array,book.getInfo());
    }
}
