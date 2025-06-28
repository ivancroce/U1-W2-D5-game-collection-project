package ivancroce.entities;

public class BoardGame extends Game{
    private int numberOfPlayers;
    private int averagePlaytimeMins;

    // Constructor
    public BoardGame(String id, String title, int year, double price, int numberOfPlayers, int averagePlaytimeMins) {
        super(id, title, year, price);
        this.setNumberOfPlayers(numberOfPlayers);
        this.setAveragePlaytimeMins(averagePlaytimeMins);
    }

    // Getters/Setters
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        if(numberOfPlayers <= 0) {
            throw new IllegalArgumentException("Number of Players, must be a positive number.");
        }
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getAveragePlaytimeMins() {
        return averagePlaytimeMins;
    }

    public void setAveragePlaytimeMins(int averagePlaytimeMins) {
        if(averagePlaytimeMins < 0){
            throw new IllegalArgumentException("Average Playtime must be a positive number.");
        }
        this.averagePlaytimeMins = averagePlaytimeMins;
    }

    @Override
    public String toString() {
        return "BoardGame{" + super.toString() +
                "numberOfPlayers=" + numberOfPlayers +
                ", averagePlaytimeMins=" + averagePlaytimeMins +
                '}';
    }
}
