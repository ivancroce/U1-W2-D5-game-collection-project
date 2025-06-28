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
            collection.addGame(new VideoGame("VG02", "Cyberpunk 2077", 2020, 59.99, Platform.PC, Genre.ACTION, 80));
            collection.addGame(new VideoGame("VG03", "Call of Duty: Black Ops 6", 2025, 69.99, Platform.PC, Genre.FPS, 250));
            collection.addGame(new VideoGame("VG04", "The Last of Us Part II", 2020, 49.99, Platform.PS5, Genre.ACTION, 25));
            collection.addGame(new VideoGame("VG05", "Fifa 25", 2025, 69.99, Platform.PS5, Genre.SPORTS, 300));
            collection.addGame(new VideoGame("VG06", "Halo Infinite", 2021, 39.99, Platform.XBOX, Genre.FPS, 100));
            collection.addGame(new BoardGame("BG01", "Monopoly", 1935, 25.00, 5, 45));
            collection.addGame(new BoardGame("BG02", "Battleship", 1967, 19.99,2, 30));
            collection.addGame(new BoardGame("BG03", "Risiko", 1957, 34.99, 3, 120));
        } catch (Exception e) {
            System.err.println("Error loading sample data: " + e.getMessage());
        }
    }
}
