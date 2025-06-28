package ivancroce;


import ivancroce.entities.BoardGame;
import ivancroce.entities.GameCollection;
import ivancroce.entities.VideoGame;
import ivancroce.enums.Genre;
import ivancroce.enums.Platform;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static GameCollection collection = new GameCollection();

    public static void main(String[] args) {

        loadGames();
        collection.printGameCollection();
    }

    private static void loadGames() {
        System.out.println("--- Loading Games... ---");
        try {
            collection.addGame(new VideoGame("VG01", "The Witcher 3", 2015, 29.99, Platform.PC, Genre.RPG, 150));
            collection.addGame(new BoardGame("BG01", "Monopoly", 1935, 25.00, 5, 45));
        } catch (Exception e) {
            System.err.println("Error loading sample data: " + e.getMessage());
        }
    }
}
