package ivancroce;


import ivancroce.entities.BoardGame;
import ivancroce.entities.Game;
import ivancroce.entities.GameCollection;
import ivancroce.entities.VideoGame;
import ivancroce.enums.Genre;
import ivancroce.enums.Platform;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GameCollection collection = new GameCollection();

    public static void main(String[] args) {

        loadGames();
        collection.printGameCollection();

        boolean running = true;

        while (running) {
            showMenu();

            try {
                System.out.println("Select an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addNewGame();
                        break;
                    case 2:
                        System.out.println("Enter the ID of the game to find:");
                        String id = scanner.nextLine();

                        Game game = collection.findById(id);
                        System.out.println("Game found: " + game);
                        break;
                    case 3:
                        findGamesByPrice();
                        break;
                    case 4:
                        findBoardGamesByPlayers();
                        break;
                    case 5:
                        removeGameById();
                        break;
                    case 6:
                        updateGame();
                        break;
                    case 7:
                        collection.printStats();
                        break;
                    case 8:
                        collection.printGameCollection();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: you must enter a number. Please try again.");
            } catch (Exception e) {
                // to catch all other Exceptions
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Go touch some grass...arrivederci! 😁👋");
    }

    // Methods
    private static void loadGames() {
        System.out.println("*****************************************");
        System.out.println("--- Loading Games... ---");
        try {
            collection.addGame(new VideoGame("VG01", "The Witcher 3", 2015, 29.99, Platform.PC, Genre.RPG, 150));
            collection.addGame(new VideoGame("VG02", "Cyberpunk 2077", 2020, 59.99, Platform.PC, Genre.ACTION, 80));
            collection.addGame(new VideoGame("VG03", "Call of Duty: Black Ops 6", 2025, 69.99, Platform.PC, Genre.FPS, 250));
            collection.addGame(new VideoGame("VG04", "The Last of Us Part II", 2020, 49.99, Platform.PS5, Genre.ACTION, 25));
            collection.addGame(new VideoGame("VG05", "Fifa 25", 2025, 69.99, Platform.PS5, Genre.SPORTS, 300));
            collection.addGame(new VideoGame("VG06", "Halo Infinite", 2021, 39.99, Platform.XBOX, Genre.FPS, 100));
            collection.addGame(new BoardGame("BG01", "Monopoly", 1935, 25.00, 5, 45));
            collection.addGame(new BoardGame("BG02", "Battleship", 1967, 19.99, 2, 30));
            collection.addGame(new BoardGame("BG03", "Risiko", 1957, 34.99, 3, 120));
        } catch (Exception e) {
            System.err.println("Error loading sample data: " + e.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("*****************************************");
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
        System.out.println("*****************************************");
    }

    private static void addNewGame() {
        System.out.println("--- Add a new game ---");
        System.out.println("Select the type of game to add: (1.Video game, 2.Board game): ");

        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Unique ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Publication Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (type == 1) {
            System.out.println("Available Platforms: " + Arrays.toString(Platform.values()));
            System.out.println("Enter Platform: ");

            // Type value = Type.valueOf(scanner.nextLine().toUpperCase()); thanks stackoverflow 💻
            Platform platform = Platform.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Available genres: " + Arrays.toString(Genre.values()));
            System.out.println("Enter Genre: ");
            Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Enter Playtime (in hours): ");
            int playtime = Integer.parseInt(scanner.nextLine());

            // creating new obj vg
            VideoGame vg = new VideoGame(id, title, year, price, platform, genre, playtime);

            collection.addGame(vg); // / using addGame from GameCollection's methods
        } else if (type == 2) {
            System.out.println("Enter number of players (e.g., 2-10): ");

            int players = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Average Playtime (in minutes): ");
            int duration = Integer.parseInt(scanner.nextLine());

            // creating new obj bg
            BoardGame bg = new BoardGame(id, title, year, price, players, duration);

            collection.addGame(bg); // using addGame from GameCollection's methods
        } else {
            System.out.println("Invalid type selected.");
            return;
        }

        System.out.println("Game added successfully to the collection!");
    }

    private static void findGamesByPrice() {
        System.out.println("Enter the maximum price (to find games with a price less than this value): ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Game> results = collection.findByPriceLessThan(maxPrice);

        if(results.isEmpty()){
            System.out.println("No games found with a price less than " + maxPrice);
        } else {
           System.out.println("Games with a price less than " + maxPrice + ":");
            results.forEach(System.out::println);
     }
}

    private static void findBoardGamesByPlayers() {
    System.out.println("Enter a number of players: ");
    int num = Integer.parseInt(scanner.nextLine());

    List<BoardGame> results = collection.findBoardGamesByNumberOfPlayers(num);

    if (results.isEmpty()) {
        System.out.println("No board games found for " + num + " players.");
    } else {
        System.out.println("Board games found for " + num + " players: ");
        results.forEach(System.out::println);
    }
}

    private static void removeGameById() {
    System.out.println("Enter the ID of the game you want to remove: ");

    String idToRemove = scanner.nextLine();

    collection.removeById(idToRemove);
    System.out.println("Game with ID '" + idToRemove + "' has been successfully removed.");
}

    private static void updateGame() {
        System.out.println("Enter the ID of the game to update: ");
        String idToUpdate = scanner.nextLine();

        // if the ID doesn't exist, findById will throw the exception.
        Game oldGame = collection.findById(idToUpdate);
        System.out.println("Found game to update: " + oldGame.getTitle());

        System.out.println("Enter new Title: ");
        String newTitle = scanner.nextLine();

        System.out.println("Enter new Publication Year: ");
        int newYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter new Price: ");
        double newPrice = Double.parseDouble(scanner.nextLine());

        Game updatedGame;

        // check if VideoGame or BoardGame
        if(oldGame instanceof VideoGame) {
            System.out.println("Updating a Video Game...");

            System.out.println("Enter new Platform (Available: " + Arrays.toString(Platform.values()) + ": ");
            Platform newPlatform = Platform.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Enter new Genre (Available: " + Arrays.toString(Genre.values()) + ": ");
            Genre newGenre = Genre.valueOf(scanner.nextLine().toUpperCase());

            System.out.println("Enter new Playtime (hours): ");
            int newPlaytimeHours = Integer.parseInt(scanner.nextLine());

            updatedGame = new VideoGame(idToUpdate, newTitle, newYear, newPrice, newPlatform, newGenre, newPlaytimeHours);
        } else {
            System.out.println("Updating a Game Board...");

            System.out.println("Enter new Number of players (2-10): ");
            int newPlayers = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter new Average playtime (minutes): ");
            int newAveragePlayTime = Integer.parseInt(scanner.nextLine());

            updatedGame = new BoardGame(idToUpdate, newTitle, newYear, newPrice, newPlayers, newAveragePlayTime);
        }

        collection.updateGameById(idToUpdate, updatedGame);
        System.out.println("Game with ID '" + idToUpdate + "' has been successfully updated.");
    }
    }
