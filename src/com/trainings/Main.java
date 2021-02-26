package com.trainings;

import java.util.*;

public class Main {

    public static void main(String[] args) {

       countOnes();

    }


    public static void countOnes() {
        List<int[]> ints = new ArrayList<>() {{
            add(new int[]{0, 0, 1, 0, 1, 1, 1, 0});
            add(new int[]{0, 0, 1, 0, 1, 1, 1, 0});
            add(new int[]{0, 0, 1, 0, 1, 1, 1, 0});
            add(new int[]{0, 0, 1, 0, 1, 1, 1, 0});
            add(new int[]{0, 0, 1, 0, 1, 1, 1, 0});
            add(new int[]{0, 0, 1, 0, 1, 1, 1, 0});
        }};

        int[] ints3 = new int[]{0, 0, 1, 0, 1, 1, 1, 0};
        int[] ints1 = new int[]{0, 0, 1, 0, 1, 0, 1, 0};
        int[] ints4 = new int[]{0, 0, 1, 0, 1, 1, 1, 1};
        int[] ints0 = new int[]{0, 0};
        int[] ints2 = new int[]{0, 0, 1, 0, 1, 1, 0, 0, 0};
        List<int[]> ints2List = new ArrayList<>(Arrays.asList(ints3, ints1, ints4, ints0, ints2));

        for (int[] intArr : ints2List) {
            int maxCount = 0, currentCount = 0, intsLength = intArr.length;

            if (intsLength == 0) {
                System.out.println("ARRAY IS EMPTY");
            }
            else {
                for (int currentInt : intArr) {
                    if (currentInt > 0) {
                        currentCount++;
                    }
                    else {
                        currentCount = 0;
                    }
                    maxCount = Math.max(maxCount, currentCount);
                }
                System.out.println(maxCount);
            }
        }
    }

    static final String phrase = "How can mirrors be real if our eyes aren't real";

    static final int incomeNum = new Random().nextInt(50000);

    public static String expandedForm(int num) {
        System.out.println(num);

        List<String> digitsStrings = new ArrayList<>();
        final String zero = "0";
        String stringInt = String.valueOf(num);
        int length = stringInt.length();

        for (int i = 0; i < length; i++) {
            int limit = length - 1;
            String digitNum = Character.toString(stringInt.charAt(i));

            if (!digitNum.equals(zero)) {
                String digitWithZero = digitNum.concat(zero.repeat(limit - i));
                digitsStrings.add(digitWithZero);
            }
        }
        return String.join(" + ", digitsStrings);
    }


    public void kek1() {
        String[] wordArray = phrase.split(" ");
        List<String> words = Arrays.asList(wordArray);

        StringBuilder sb = new StringBuilder();
        words.forEach(word -> {
            String newWord = word.substring(0, 1).toUpperCase().concat(word.substring(1)).concat(" ");
            sb.append(newWord);

        });
        System.out.println(sb.toString());
    }
}
