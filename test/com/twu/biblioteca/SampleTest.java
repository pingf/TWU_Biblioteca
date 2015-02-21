package com.twu.biblioteca;


/**
 * Created by fcmeng on 2/20/15.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {
    @Test
    public void canConstructASampleWithAData() {
        Sample sample = new Sample("hello");
        assertEquals("hello", sample.getData());
    }
}
