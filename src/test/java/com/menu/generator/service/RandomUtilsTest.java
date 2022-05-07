package com.menu.generator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @Test
    void randomElement_whenArrayContainsOnlyOneElement_sameElementReturned() {
        String[] elements = {"singleTestElement"};

        String result = RandomUtils.randomElement(elements);

        assertEquals("singleTestElement", result, "Returned element not in input.");
    }

    @Test
    void randomElement_whenArrayIsNull_ThrowsException() {
        String[] elements = null;

        assertThrows(NullPointerException.class, ()-> RandomUtils.randomElement(elements));
    }

    @Test
    public void  plusFive_when5_return10(){
        int input = 5;

        int result = plusFive(input);

        assertEquals(10, result, "When the input is 5, plusFive should return 10!");
    }


    private int plusFive(int x){
        return x+5;
    }
}