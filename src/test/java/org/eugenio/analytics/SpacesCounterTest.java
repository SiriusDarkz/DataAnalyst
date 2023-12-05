package org.eugenio.analytics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpacesCounterTest {

    @Test
    void shouldReturnFiveSpaces() {
         assertEquals(5,SpacesCounter.countSpaces("     "));
    }

    @Test
    void shouldReturnZeroSpace() {
        assertEquals(0,SpacesCounter.countSpaces(""));
    }

    @Test
    void shouldCountSpacesBetweenWords() {
        assertEquals(2,SpacesCounter.countSpaces("Hello World! "));
    }
}
