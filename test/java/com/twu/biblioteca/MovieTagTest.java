package com.twu.biblioteca;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by fcmeng on 2/21/15.
 */
public class MovieTagTest {
    @Test
    public void itShouldReturnMoviesInfo() throws ParseException {

        MovieTag movieTag = new MovieTag("Big Hero 6", "2014", "Don Hall","8.7", 1);

        String[] expected_array={"Big Hero 6", "2014", "Don Hall","8.7", "1"};

        assertArrayEquals(expected_array, movieTag.getInfo());
    }
}
