package org.eugenio.analytics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DotsCounterTest {

    @Test
    void shouldReturnThreeDots() {
        assertEquals(3,DotsCounter.countDots("..."));
    }

    @Test
    void shouldReturnZeroDots() {
        assertEquals(0,DotsCounter.countDots(""));
    }

    @Test
    void shouldCountDotsBetweenWords() {
        assertEquals(5,DotsCounter.countDots("H.e.l.l.o."));

    }
}
