package com.siddharth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testExample() {
        int expected = 5;
        int actual = 3 + 2;
        assertEquals(expected, actual, "The sum should be 5");
    }
}
