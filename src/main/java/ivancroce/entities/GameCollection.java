package ivancroce.entities;


import ivancroce.exceptions.DuplicateGameException;
import ivancroce.exceptions.GameNotFoundException;

import java.util.*;

public class GameCollection {
    // implementing a Map, to avoid double keys (id).
    public static Map<String, Game> games = new HashMap<>();

    // Methods
    // 1. addGame(), if a game has the same ID, throw a DuplicateGameException.
    public void addGame(Game game) {
        if(games.containsKey(game.getId())) {
            throw new DuplicateGameException("Error: A game with ID '" + game.getId() + "' already exists.");
        }
        games.put(game.getId(), game);
    }

    // 2. findById(), returns the foundGame if present.
    public static Game findById(String id) {
        // get() returns the value from that key, or null if the key is not present.
    Game foundGame = games.get(id);

    if(foundGame == null) {
        throw new GameNotFoundException("Error: No game found with ID '" + id + "'.");
    }
    return foundGame;
    }

    // 3. findByPriceLessThan(), finds and returns a list of games with a price less than (maxPrice).
    public static List<Game> findByPriceLessThan(double maxPrice) {
        return games.values().stream().filter(g -> g.getPrice() < maxPrice).toList();
    }

    // 4. findBoardGamesByNumberOfPlayers(), finds and returns a list of board games that support a specific number of players.
    public static List<BoardGame> findBoardGamesByNumberOfPlayers(int players) {
        return games.values().stream().filter(game -> game instanceof BoardGame).map(game -> (BoardGame) game).filter(boardGame -> boardGame.getNumberOfPlayers() == players).toList();
    }

    // 5. removeById(), if a game has the same ID, throw a GameNotFoundException.
    public void removeById(String id) {

        Game removedGame = games.remove(id);

        if (removedGame == null) {
            throw new GameNotFoundException("Error: Cannot remove. No game found with ID '" + id + "'.");
        }
    }

    // 6. updateGameById()
    public void updateGameById(String id, Game updatedGame) {
        // findById method created before to verify if the game exist.
        findById(id);

        // the updated game ID must match the one we are updating.
        if(!id.equals(updatedGame.getId())) {
            throw new IllegalArgumentException("The updated game's ID doesn't match the ID to be updated.");
        }
        games.put(id, updatedGame);
        }

        // 7. printStats()
    public void printStats() {
        if(games.isEmpty()) {
            System.out.println("The Games Collection is empty. No statistics to show.");
            }

        System.out.println("--- Games Collection Statistics ---");

        long totVideoGames = games.values().stream().filter(game -> game instanceof VideoGame).count();
        long totBoardGames = games.values().stream().filter(game -> game instanceof BoardGame).count();

        System.out.println("Total number of Video Games: " + totVideoGames);
        System.out.println("Total number of Board Games: " + totBoardGames);

        Optional<Game> mostExpensiveGame = games.values().stream().max(Comparator.comparingDouble(game -> game.getPrice()));
        mostExpensiveGame.ifPresent(game ->
                System.out.println("Most expensive game: " + game.getTitle() + " (€" + game.getPrice() + ")")
        );

        OptionalDouble averagePriceOpt = games.values().stream()
                .mapToDouble(Game::getPrice)
                .average();

        double averagePrice = averagePriceOpt.orElse(0.0);

        System.out.println("Average price of all items: €" + averagePrice);
    }

    // printGameCollection()
    public void printGameCollection() {
        if (games.isEmpty()) {
            System.out.println("The collection is empty.");
            return;
        }
        games.values().forEach(System.out::println);
    }
    }

