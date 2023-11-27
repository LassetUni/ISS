package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Filmauffuehrung {
    private Kinosaal kinosaal;
    private Film film;
    private LocalDateTime startzeit;

    public Filmauffuehrung(Kinosaal kinosaal, Film film, LocalDateTime startzeit) {
        this.setKinosaal(kinosaal);
        this.setFilm(film);
        this.setStartzeit(startzeit);
    }

	public Kinosaal getKinosaal() {
		return kinosaal;
	}

	public void setKinosaal(Kinosaal kinosaal) {
		this.kinosaal = kinosaal;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public LocalDateTime getStartzeit() {
		return startzeit;
	}

	public void setStartzeit(LocalDateTime startzeit) {
		this.startzeit = startzeit;
	}
	public String getStartzeitAlsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return startzeit.format(formatter);
    }
	public String getFilmTitel() {
        return film.getTitel(); // Angenommen, Film hat eine Methode getTitel
    }

    public String getKinosaalName() {
        return kinosaal.getName(); // Angenommen, Kinosaal hat eine Methode getName
    }
    public String getStartzeitFormatiert() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return startzeit.format(formatter);
    }
    // Getter und Setter Methoden
}