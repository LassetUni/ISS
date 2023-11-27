package application;

public class Film {
    private String titel;
    private String genre;
    private double laufzeit;

    public Film(String titel, String genre, double laufzeit) {
        this.titel = titel;
        this.genre = genre;
        this.laufzeit = laufzeit;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(double laufzeit) {
        this.laufzeit = laufzeit;
    }
    public String toString() {
        return this.titel; // Der Titel des Films wird angezeigt
    }
}
