package hiber.pojo;

import java.util.Random;

public class SerialCar {

    private static final String[] LETTERS = { "А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х" };//разрешенны буквы в номере
    private static final Random RANDOM = new Random();

    public static String serialNumber() {
        String firstLetter = LETTERS[RANDOM.nextInt(LETTERS.length)];
        String secondLetter = LETTERS[RANDOM.nextInt(LETTERS.length)];
        String thirdLetter = LETTERS[RANDOM.nextInt(LETTERS.length)];

        int number = RANDOM.nextInt(900) + 100; // число от 100 до 999

        int region = RANDOM.nextInt(100) + 1; // код региона от 1 до 100

        return firstLetter + number + secondLetter + thirdLetter + region;
    }
}