package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import common.SantasLittleHelper;

public class Trebuchet {

    private static final Map<String, String> digitMap = initDigitTranslationMap();

    public static void main(String[] args) {
        String path = "src/main/java/day1/input.txt";
        int firstSum;
        int secondSum;

        long performancePart1;
        long performancePart2;

        //Part 1
        long startTime = Instant.now().toEpochMilli();
        try (BufferedReader reader = SantasLittleHelper.getFileAsBufferedReader(path)) {
            firstSum = reader.lines()
                    .map(Trebuchet::wipeOffNonDigits)
                    .mapToInt(Trebuchet::firstAndLastDigit)
                    .sum();
            performancePart1 = Instant.now().toEpochMilli() - startTime;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Part 2
        startTime = Instant.now().toEpochMilli();
        try (BufferedReader reader = SantasLittleHelper.getFileAsBufferedReader(path)) {
            secondSum = reader.lines()
                    .map(Trebuchet::prepareString)
                    .map(Trebuchet::wipeOffNonDigits)
                    .mapToInt(Trebuchet::firstAndLastDigit)
                    .sum();
            performancePart2 = Instant.now().toEpochMilli() - startTime;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Calculated first sum in " + performancePart1 + " ms");
        System.out.printf("The first sum is %s %n", firstSum);
        System.out.println("Calculated second sum in " + performancePart2 + " ms");
        System.out.printf("The second sum is %s %n", secondSum);

    }

    private static String wipeOffNonDigits(String input) {
        System.out.println("Trebuchet.wipeOffNonDigits");
        System.out.println("input = " + input);
        return input.replaceAll("\\D", "");
    }

    private static int firstAndLastDigit(String digits) {
        System.out.println("digits = " + digits);
        if (digits.isEmpty()) {
            return 0;
        }

        System.out.println(digits);
        char firstDigit = digits.charAt(0);
        char lastDigit = digits.charAt(digits.length() - 1);
        int number = Integer.parseInt("" + firstDigit + lastDigit);
        System.out.println(number);
        System.out.println("*****");
        return number;

    }

    @Deprecated
    private static String cleanString(String stringToBeCleaned) {
        System.out.println(stringToBeCleaned);

        StringBuilder cleanedStringBuilder = new StringBuilder();
        for (int i = 0; i < stringToBeCleaned.length(); i++) {
            cleanedStringBuilder.append(stringToBeCleaned.charAt(i));

            for (Entry<String, String> entry : digitMap.entrySet()) {
                String currentString = cleanedStringBuilder.toString();
                if (currentString.contains(entry.getKey())) {
                    int startIndex = cleanedStringBuilder.indexOf(entry.getKey());
                    int stopIndex = startIndex + entry.getKey().length();
                    cleanedStringBuilder.replace(startIndex, stopIndex, entry.getValue());
                    break;
                }
            }
        }

        return cleanedStringBuilder.toString();
    }

    private static String prepareString(String input) {
        System.out.println("prepareString input = " + input);
        StringBuilder preparedStringBuilder = new StringBuilder(input);
        for (Entry<String, String> entry : digitMap.entrySet()) {
            int firstIndex = preparedStringBuilder.indexOf(entry.getKey());
            if (firstIndex != -1) {
                preparedStringBuilder.insert(firstIndex + 1, entry.getValue());
            }
            int lastIndex = preparedStringBuilder.lastIndexOf(entry.getKey());
            if (lastIndex != -1 && lastIndex != firstIndex) {
                preparedStringBuilder.insert(lastIndex + 1, entry.getValue());
            }
        }
        return preparedStringBuilder.toString();
    }

    private static Map<String, String> initDigitTranslationMap() {
        Map<String, String> digitMap = new LinkedHashMap<>();
        digitMap.put("one", "1");
        digitMap.put("two", "2");
        digitMap.put("three", "3");
        digitMap.put("four", "4");
        digitMap.put("five", "5");
        digitMap.put("six", "6");
        digitMap.put("seven", "7");
        digitMap.put("eight", "8");
        digitMap.put("nine", "9");
        return digitMap;
    }

}
