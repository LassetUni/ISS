package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.IntStream;

public class scene12Controller {

    @FXML
    private ComboBox<Kinosaal> kinosaalComboBox;
    @FXML
    private ComboBox<Film> filmComboBox;
    @FXML
    private DatePicker datumPicker;
    @FXML
    private ComboBox<Integer> stundenComboBox;
    @FXML
    private ComboBox<Integer> minutenComboBox;

    @FXML
    private Button speichernButton;

    private scene11Controller hauptController;

    @FXML
    private void initialize() {
        // Initialisiere ComboBoxen, etc.
    	// Laden der Kinosaal-Daten
        kinosaalComboBox.setItems(FXCollections.observableArrayList(KinosaalVerwaltung.getKinosaalListe()));

        // Laden der Film-Daten
        filmComboBox.setItems(FilmListSingleton.getInstance().getFilmList());
    	IntStream.range(0, 24).forEach(stundenComboBox.getItems()::add);
        IntStream.range(0, 60).forEach(minutenComboBox.getItems()::add);

        speichernButton.setOnAction(event -> speichereFilmauffuehrung());
    }

    public void setHauptController(scene11Controller controller) {
        this.hauptController = controller;
    }

    private void speichereFilmauffuehrung() {
        Kinosaal kinosaal = kinosaalComboBox.getValue();
        Film film = filmComboBox.getValue();
        Integer stunde = stundenComboBox.getValue();
        Integer minute = minutenComboBox.getValue();

        if (stunde != null && minute != null && datumPicker.getValue() != null) {
            LocalDateTime startzeit = LocalDateTime.of(datumPicker.getValue(), LocalTime.of(stunde, minute));
            Filmauffuehrung neueFilmauffuehrung = new Filmauffuehrung(kinosaal, film, startzeit);
            hauptController.aktualisiereTabelle(neueFilmauffuehrung);
            // Schließe das Anlegen-Fenster, falls notwendig
        } else {
            // Fehlerbehandlung, falls Datum, Stunde oder Minute nicht ausgewählt wurden
        
        }
    }
       
}
