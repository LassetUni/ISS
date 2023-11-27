package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilmListSingleton {
    private static final FilmListSingleton instance = new FilmListSingleton();
    private ObservableList<Film> filmList = FXCollections.observableArrayList();

    private FilmListSingleton() {
        // Private Konstruktor, um sicherzustellen, dass nur eine Instanz existiert
    }

    public static FilmListSingleton getInstance() {
        return instance;
    }

    public ObservableList<Film> getFilmList() {
        return filmList;
    }
}
