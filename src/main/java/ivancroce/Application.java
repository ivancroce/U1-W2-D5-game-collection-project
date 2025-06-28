package ivancroce;


import ivancroce.entities.BoardGame;
import ivancroce.entities.GameCollection;
import ivancroce.entities.VideoGame;
import ivancroce.enums.Genre;
import ivancroce.enums.Platform;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static GameCollection collection = new GameCollection();

    public static void main(String[] args) {

        loadGames();
        // collection.printGameCollection();

        boolean running = true;

        while(running) {
            showMenu();

            try {
            System.out.println("Select an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 1:
                    // addGame();
                    System.out.println("test case 1");
                    break;
                case 2:
                    // findById();
                    System.out.println("test case 2");
                    break;
                case 3:
                    // findById();
                    System.out.println("test case 3");
                    break;
                case 4:
                    // findById();
                    System.out.println("test case 4");
                    break;
                case 5:
                    // findById();
                    System.out.println("test case 5");
                    break;
                case 6:
                    // findById();
                    System.out.println("test case 6");
                    break;
                case 7:
                    // findById();
                    System.out.println("test case 7");
                    break;
                case 8:
                    // findById();
                    System.out.println("test case 8");
                    break;
                case 0:
                    // exit;
                    running = false;
                    break;
                default:
                    System.err.println("Invalid option. Please try again.");
            }
            } catch(InputMismatchException e) {
                System.out.println("Error: you must enter a number. Please try again.");
            } catch(Exception e) {
                // to catch all other Exceptions
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("switch test done arrivederci 👋");
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

    private static void showMenu() {
        System.out.println("--------------------");
        System.out.println("--- Game Collection Menu ---");
        System.out.println("1. Add a new game");
        System.out.println("2. Find a game by ID");
        System.out.println("3. Find games by price less than");
        System.out.println("4. Find games by number of players");
        System.out.println("5. Remove a game by ID");
        System.out.println("6. Update a game by ID");
        System.out.println("7. Show statistics");
        System.out.println("8. Show the entire games collection");
        System.out.println("0. Exit");
        System.out.println("--------------------");
    }
}
