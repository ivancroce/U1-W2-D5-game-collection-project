package ivancroce.entities;

import java.time.Year;
import java.util.Objects;

public abstract class Game {
    private final String id;
    private String title;
    private int year;
    private double price;

    // Constructor
    public Game(String id, String title, int year, double price) {
        this.id = id;
        this.setTitle(title);
        this.setYear(year);
        this.setPrice(price);
    }

    // Getters/Setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.isEmpty()) {
            throw new IllegalArgumentException("Title can't be empty.");
        }
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        // to check if year is between 1900 and currentYear (2025), thanks stackoverflow for the currentYear 💻
        int currentYear = Year.now().getValue();
        if (year < 1900 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1900 and " + currentYear + ".");
        }
        this.year = year;
       // System.out.println(currentYear);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be a positve number.");
        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
