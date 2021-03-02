package com.trainings;

import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.logging.*;

public class Main {

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public static final List<Integer> intInput = Arrays.asList(1, 1, 3, 3, 3, 4, 4);

    public static final String phrase = "How can mirrors be real if our eyes aren't real";

    public static final int incomeNum = new Random().nextInt(50000);

    public static void main(String[] args) {
        LOGGER.info("MAIN");


        System.out.println(isPalindrome("Do geese see God?"));

    }


    public static boolean isPalindrome(String s) {
/// need memory O(1)
/// memory O(n)       return s.equals(new StringBuilder(s.replaceAll("\\s", "").toLowerCase()).reverse().toString());
        if (s == null || s.isEmpty()) return false;

        int startIndex = 0, endIndex = s.length() - 1;

        while (endIndex > startIndex) {

            Character charLetterEnd = Character.toLowerCase(s.charAt(endIndex));
            char charLetterStart = Character.toLowerCase(s.charAt(startIndex));

            if (!Character.isLetter(charLetterEnd) && !Character.isLetter(charLetterStart) || charLetterEnd.equals(charLetterStart)) {
                startIndex++;
                endIndex--;
            }
            else if (!Character.isLetter(charLetterEnd)) {
                endIndex--;
            }
            else if (!Character.isLetter(charLetterStart)) {
                startIndex++;
            }
            else return false;
        }

        return true;
 }

    public static boolean checkValidBrackets(String inputString) {
        if (inputString == null || inputString.isEmpty()) return false;

        int figureBracketOpen = 0, figureBracketClose = 0, roundBracketOpen = 0, roundBacketClose = 0;

        ArrayList<String> listString = new ArrayList<>(Arrays.asList(inputString.split("")));

        for (String string : listString) {
            switch (string) {
                case "{" -> figureBracketOpen++;
                case "}" -> figureBracketClose++;
                case "(" -> roundBracketOpen++;
                case ")" -> roundBacketClose++;
            }
        }
        return figureBracketOpen == figureBracketClose && roundBracketOpen == roundBacketClose;
    }


    public static void trySetsAndLists() {


        String[] arrayString = new String[]{"keke", "kok", "kokos", "axaxaxaxa"};

        List<String> list = new ArrayList<>(Arrays.asList(arrayString));
        Set<String> set = new HashSet<>(Set.of(arrayString));


        System.out.format("\nlist %s", list.toString());
        System.out.format("\nset %s", set.toString());

        //.set. set.

        list.sort(Comparator.comparing(String::length));


        System.out.format("\nlist after sort %s", list.toString());


    }


    public static void calculateSqrt(int input) {

        int sqrt = (int) Math.sqrt(input);

        System.out.println(sqrt);


    }

    public static void longestPrefix() {
        final String[] strings = new String[]{"abc", "abcegeg", "abcde", "abcg"};
        /**/

        String prefix = "";
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        String firstWord = strings[0];

        letters:
        for (int i = 0; i < firstWord.length(); i++) {
            String checkLetter = String.valueOf(firstWord.charAt(i));

            for (int j = 1; j < strings.length; j++) {
                String checkingWord = strings[j];
                if (!String.valueOf(checkingWord.charAt(i)).equals(checkLetter)) {
                    break letters;
                }
            }
            prefix = prefix.concat(checkLetter);
        }
        System.out.println(prefix);
    }


    public static int sumDigitsFromString(String digit) {
        try {
            return Arrays.stream(digit.split(""))
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
        } catch (NumberFormatException e) {
            return 0;
        }

        /*
        AtomicInteger sum = new AtomicInteger(0);
        Arrays.asList(digit.split("")).forEach(s -> {
            sum.getAndAdd(Integer.parseInt(s));
        });
        return sum.get();
        */
    }

    public static Map<Integer, Integer> calculateRepeatNumbers(List<Integer> input) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        input.forEach(intInput -> {
            if (!map.containsKey(intInput)) {
                map.put(intInput, 1);
            } else {
                map.put(intInput, map.get(intInput) + 1);
            }
        });
        return map;
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
            } else {
                for (int currentInt : intArr) {
                    if (currentInt > 0) {
                        currentCount++;
                    } else {
                        currentCount = 0;
                    }
                    maxCount = Math.max(maxCount, currentCount);
                }
                System.out.println(maxCount);
            }
        }
    }

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
