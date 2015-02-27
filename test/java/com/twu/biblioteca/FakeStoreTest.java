package com.twu.biblioteca;

/**
 * Created by fcmeng on 2/21/15.
 */

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;

public class FakeStoreTest {

    private FakeStore fakeStore = null;
    @Before
    public void setUpStreams() {
        fakeStore = new FakeStore();
    }
    @Test
    public void itShouldListAllBooksToMe() {
        String[][] expected_array = {
                {"Learning Python, 4th Edition",
                        "Mark Lutz",
                        "Thu Jan 01 00:00:00 CST 2009","3"},
                {"Python for Unix and Linux System Administration",
                        "Noah Gift, Jeremy M. Jones",
                        "Tue Jan 01 00:00:00 CST 2008","2"}};
        assertArrayEquals(expected_array, fakeStore.listBooks().toArray());
    }

    @Test
    public void whenCheckoutItShouldReturnSuccessfulIfBookExisted() {
        fakeStore.checkoutBook("Python for Unix and Linux System Administration");
        String[][] expected_array = {
                {"Learning Python, 4th Edition",
                        "Mark Lutz",
                        "Thu Jan 01 00:00:00 CST 2009","3"},
                {"Python for Unix and Linux System Administration",
                        "Noah Gift, Jeremy M. Jones",
                        "Tue Jan 01 00:00:00 CST 2008","1"}};
        assertArrayEquals(expected_array, fakeStore.listBooks().toArray());
    }

    @Test
    public void itShouldBeAbleToTellTheOneWhoCheckOutBooks() {
        fakeStore.checkoutBook("Python for Unix and Linux System Administration");

        String[][] expected_array = {
                {"123-4567", "Python for Unix and Linux System Administration"}
        };
        assertArrayEquals(expected_array, fakeStore.checkoutStatus().toArray());
    }
}
