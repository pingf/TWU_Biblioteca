/**
 * Created by fcmeng on 2/21/15.
 */
package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FakeStore.class, BibliotecaApp.class})
public class BibliotecaAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setIn(null);
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void whenType0ItShouldShowMeBookList() throws Exception {

        String[][] expected_array = {
                {"Hello World",
                        "Jesse MENG",
                        "Thu Jan 01 00:00:00 CST 2015"}};
        FakeStore mock = PowerMockito.mock(FakeStore.class);
        PowerMockito.when(mock.listBooks()).thenReturn(Arrays.asList(expected_array));
        PowerMockito.whenNew(FakeStore.class).withAnyArguments().thenReturn(mock);

        ByteArrayInputStream in = new ByteArrayInputStream(("0\n-1").getBytes());
        System.setIn(in);

        BibliotecaApp.main(null);

        assertThat(outContent.toString(), containsString("List Books"));
        assertThat(outContent.toString(), containsString("Quit"));
        assertThat(outContent.toString(), containsString(expected_array[0][0]));
        assertThat(outContent.toString(), containsString(expected_array[0][1]));
        assertThat(outContent.toString(), containsString(expected_array[0][2]));
        assertThat(outContent.toString(), containsString("Goodbye"));
    }
}
