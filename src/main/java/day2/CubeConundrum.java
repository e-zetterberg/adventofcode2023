package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import common.SantasLittleHelper;

public class CubeConundrum {

    private static final int RED_LIMIT = 12;
    private static final int GREEN_LIMIT = 13;
    private static final int BLUE_LIMIT = 14;

    public static void main(String[] args) {
        try (BufferedReader fileReader = SantasLittleHelper.getFileAsBufferedReader("src/main/java/day2/input.txt")) {
            List<String> games = fileReader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
