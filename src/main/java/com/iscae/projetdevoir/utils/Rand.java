package com.iscae.projetdevoir.utils;

import java.util.Random;

public class Rand {

    private static final int RANDOM_NUMBER_LENGTH = 3;

    public static String generateRandomNumber(String prefix) {
        Random rand = new Random();
        int randomNumber = rand.nextInt((int) Math.pow(10, RANDOM_NUMBER_LENGTH));
        return prefix + String.format("%03d", randomNumber);
    }
}
