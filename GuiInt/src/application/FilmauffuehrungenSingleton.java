package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FilmauffuehrungenSingleton {
    private static final FilmauffuehrungenSingleton instance = new FilmauffuehrungenSingleton();
    private ObservableList<Filmauffuehrung> filmauffuehrungen = FXCollections.observableArrayList();

    private FilmauffuehrungenSingleton() {}

    public static FilmauffuehrungenSingleton getInstance() {
        return instance;
    }

    public ObservableList<Filmauffuehrung> getFilmauffuehrungen() {
        return filmauffuehrungen;
    }
}
