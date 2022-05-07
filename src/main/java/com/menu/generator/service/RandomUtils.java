package com.menu.generator.service;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String randomElement(String[] elements) {
        int randIdx = ThreadLocalRandom.current().nextInt(elements.length);
        return elements[randIdx];
    }
}
