package day2;

public class Game {

    private int gameID;
    private int mostRedCubesShown;
    private int mostGreenCubesShown;
    private int mostBlueCubesShown;

    public Game(int ID, int mostRedCubesShown, int mostGreenCubesShown, int mostBlueCubesShown) {
        this.gameID = ID;
        this.mostRedCubesShown = mostRedCubesShown;
        this.mostGreenCubesShown = mostGreenCubesShown;
        this.mostBlueCubesShown = mostBlueCubesShown;
    }

    public Game parseGame(String input) {
        System.out.println("Parsing game from string: " + input);
        //String manipulation magic
        int colonIndex = input.indexOf(":");
        int gameID = Integer.parseInt(input.substring(6, colonIndex));
        String[] cubeSets = input.substring(colonIndex + 1).split(";");
        for (String cubeSet : cubeSets) {

        }
        return new Game(gameID, );
    }

    public boolean isPossible(int redLimit, int greenLimit, int blueLimit) {
        return mostRedCubesShown > redLimit || mostGreenCubesShown > greenLimit || mostBlueCubesShown > blueLimit;
    }


    public int getGameID() {
        return gameID;
    }


}
