package com.twu.biblioteca;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by fcmeng on 2/21/15.
 */
public class AccountTest {
    @Test
    public void itShouldReturnAccountInfo() throws ParseException {

        Account account = new Account("Ingress","123456","hello@world.com","11122223333");

        String[] expected_array={"123-4567","Ingress","hello@world.com","11122223333"};

        assertArrayEquals(expected_array, account.getInfo());
    }
}
