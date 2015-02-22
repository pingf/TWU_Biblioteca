package com.twu.biblioteca;

/**
 * Created by fcmeng on 2/21/15.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class FakeStoreTest {

    @Test
    public void itShouldListAllBooksToMe() {
        FakeStore fakeStore = new FakeStore();

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
        FakeStore fakeStore = new FakeStore();

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


}
