package day2;

public class Game {

    private final int gameID;
    private final int mostRedCubesShown;
    private final int mostGreenCubesShown;
    private final int mostBlueCubesShown;

    public Game(int ID, int mostRedCubesShown, int mostGreenCubesShown, int mostBlueCubesShown) {
        this.gameID = ID;
        this.mostRedCubesShown = mostRedCubesShown;
        this.mostGreenCubesShown = mostGreenCubesShown;
        this.mostBlueCubesShown = mostBlueCubesShown;
    }

    public int getPower() {
        return mostBlueCubesShown * mostGreenCubesShown * mostRedCubesShown;
    }

    public static Game parseGame(String input) {
        System.out.println("Parsing game from string: " + input);
        //String manipulation magic
        int colonIndex = input.indexOf(":");
        int gameID = Integer.parseInt(input.substring(5, colonIndex));
        String[] cubeSets = input.substring(colonIndex + 1).split(";");
        int maxRedCubes = 0;
        int maxBlueCubes = 0;
        int maxGreenCubes = 0;
        for (String cubeSet : cubeSets) {
            System.out.println(cubeSet);
            maxRedCubes = getMaxCubes(maxRedCubes, cubeSet, "red");
            maxBlueCubes = getMaxCubes(maxBlueCubes, cubeSet, "blue");
            maxGreenCubes = getMaxCubes(maxGreenCubes, cubeSet, "green");
        }
        System.out.println("min blue " + maxBlueCubes);
        System.out.println("min green " + maxGreenCubes);
        System.out.println("min red " + maxRedCubes);
        return new Game(gameID, maxRedCubes, maxGreenCubes, maxBlueCubes);
    }

    private static int getMaxCubes(int currentMax, String cubeSet, String color) {
        int index = cubeSet.indexOf(color);
        int maxCubes = currentMax;
        if (index > 2) {
            String subString = cubeSet.substring(index - 3, index);
            String cleanedSubString = subString.replaceAll("\\D", "");
            int amount = Integer.parseInt(cleanedSubString);
            if (amount > currentMax) {

               maxCubes = amount;
            }
        }
        return maxCubes;
    }

    public int getMostRedCubesShown() {
        return mostRedCubesShown;
    }

    public int getMostGreenCubesShown() {
        return mostGreenCubesShown;
    }

    public int getMostBlueCubesShown() {
        return mostBlueCubesShown;
    }

    public int getGameID() {
        return gameID;
    }


}
