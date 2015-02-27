package com.twu.biblioteca;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by fcmeng on 2/21/15.
 */
public class CheckoutTagTest {
    @Test
    public void itShouldReturnCheckoutInfo() throws ParseException {

        CheckoutTag checkoutTag = new CheckoutTag("Jesse","Learning Python, 4th Edition");

        String[] expected_array={"Jesse", "Learning Python, 4th Edition"};

        assertArrayEquals(expected_array, checkoutTag.getInfo());
    }
}
