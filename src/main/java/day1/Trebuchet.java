package day1;

import java.io.BufferedReader;
import java.io.IOException;
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

        //Part 1
        try (BufferedReader reader = SantasLittleHelper.getFileAsBufferedReader(path)) {
            firstSum = reader.lines()
                    .map(Trebuchet::wipeOffNonDigits)
                    .mapToInt(Trebuchet::firstAndLastDigit)
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Part 2
        try (BufferedReader reader = SantasLittleHelper.getFileAsBufferedReader(path)) {
            secondSum = reader.lines()
                    .map(Trebuchet::prepareString)
                    .map(Trebuchet::wipeOffNonDigits)
                    .mapToInt(Trebuchet::firstAndLastDigit)
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%n The first sum is %s", firstSum);
        System.out.printf("%n The second sum is %s", secondSum);

    }

    private static String wipeOffNonDigits(String input) {
        System.out.println("Trebuchet.wipeOffNonDigits");
        System.out.print("input = " + input);
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
