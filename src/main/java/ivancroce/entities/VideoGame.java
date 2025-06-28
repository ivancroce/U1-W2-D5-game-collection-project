package ivancroce.entities;

import ivancroce.enums.Genre;
import ivancroce.enums.Platform;

public class VideoGame extends Game {
    private Platform platform;
    private Genre genre;
    private int playtimeHours;

    // Constructor
    public VideoGame(String id, String title, int year, double price, Platform platform, Genre genre, int playtimeHours) {
        super(id,title, year, price);
        this.platform = platform;
        this.genre = genre;
        this.setPlaytimeHours(playtimeHours);
    }

    // Getters/Setters
    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPlaytimeHours() {
        return playtimeHours;
    }

    public void setPlaytimeHours(int playtimeHours) {
        if (playtimeHours < 0) {
            throw new IllegalArgumentException("Playtime must be a positive number of hours.");
        }
        this.playtimeHours = playtimeHours;
    }

    @Override
    public String toString() {
        return "VideoGame{" + super.toString() +
                "platform=" + platform +
                ", genre=" + genre +
                ", playtimeHours=" + playtimeHours +
                '}';
    }
}
