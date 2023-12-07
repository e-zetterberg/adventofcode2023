package day3;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import common.SantasLittleHelper;

public class GearRatios {
    /*Ideas
     * parse input, identify symbols
     * for each symbol, recursively search for adjacent numbers and add these to sum
     * OR
     * find numbers, sum them
     * for each number, check if it is isolated
     * subtract isolated numbers from the total*/

    /*Parse data to two-dimensional char array
     * OR
     * evaluate during parsing*/
    public static void main(String[] args) {
        String example = ".479........155..............944.....622..............31.........264.......................532..........................254.........528.....";

        try {
            List<String> inputlist = SantasLittleHelper.getFileAsList("src/main/java/day3/input.txt");
            List<char[]> lines = inputlist.stream()
                    .map(string -> string.replace(".", "a"))
                    .map(String::toCharArray)
                    .toList();
            List<Integer> numbers = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int y = 0; y < lines.size(); y++) {
                char[] line = lines.get(y);

                for (int x = 0; x < line.length; x++) {
                    List<Point> adjacentCoordinates = getAdjacentCoordinates(x, y, line.length - 1, lines.size() - 1);
                    System.out.println(adjacentCoordinates);
                    char charAtCurrentIndex = line[x];
                    if (Character.isDigit(charAtCurrentIndex)) {

                        stringBuilder.append(charAtCurrentIndex);
                        continue;
                    }
                    if (!stringBuilder.isEmpty()) {
                        numbers.add(Integer.parseInt(stringBuilder.toString()));
                        System.out.println(stringBuilder);
                        stringBuilder = new StringBuilder();
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

/*    private boolean hasAdjacentSymbol() {

    }*/

    private static boolean isValidCoordinate(int x, int y, int xMax, int yMax) {
        if (x < 0 || x > xMax) {
            return false;
        }
        if (y < 0 || y > yMax) {
            return false;
        }
        return true;
    }

    private static List<Point> getAdjacentCoordinates(int x, int y, int xMax, int yMax) {
        List<Point> coordinates = new ArrayList<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (isValidCoordinate(i, j, xMax, yMax)) {
                    coordinates.add(new Point(i, j));
                }
            }
        }
        return coordinates;
    }

}
