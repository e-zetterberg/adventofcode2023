package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import common.SantasLittleHelper;

public class CubeConundrum {

    private static final String filePath = "src/main/java/day2/input.txt";

    private static final int RED_LIMIT = 12;
    private static final int GREEN_LIMIT = 13;
    private static final int BLUE_LIMIT = 14;

    public static void main(String[] args) {
        int sumOfIDs;
        try (BufferedReader fileReader = SantasLittleHelper.getFileAsBufferedReader(filePath)) {
            sumOfIDs = fileReader.lines()
                    .map(Game::parseGame)
                    .filter(CubeConundrum::isPossible)
                    .mapToInt(Game::getGameID)
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long sumPowerOfCubes;
        try (BufferedReader fileReader = SantasLittleHelper.getFileAsBufferedReader(filePath)) {
            sumPowerOfCubes = fileReader.lines()
                    .map(Game::parseGame)
                    .mapToInt(Game::getPower)
                    .sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("sum of possible game IDs: " + sumOfIDs);
        System.out.println("Sum power of cubes: " + sumPowerOfCubes);
    }

    private static boolean isPossible(Game game) {
        if (game.getMostRedCubesShown() <= RED_LIMIT
                && game.getMostGreenCubesShown() <= GREEN_LIMIT
                && game.getMostBlueCubesShown() <= BLUE_LIMIT
        ) {
            System.out.println("Game is possible: " + game.getGameID());
            return true;
        } else {
            return false;
        }

    }

}
