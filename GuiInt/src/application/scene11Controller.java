package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class scene11Controller {

    @FXML
    private TableView<Filmauffuehrung> tableView;
    @FXML
    private Button anlegenButton;

    @FXML
    private void initialize() {
    	// Spalte für den Filmtitel
        TableColumn<Filmauffuehrung, String> filmTitelColumn = new TableColumn<>("Film");
        filmTitelColumn.setCellValueFactory(new PropertyValueFactory<>("filmTitel"));

        // Spalte für den Kinosaal
        TableColumn<Filmauffuehrung, String> kinosaalColumn = new TableColumn<>("Kinosaal");
        kinosaalColumn.setCellValueFactory(new PropertyValueFactory<>("kinosaalName"));

        // Spalte für die Startzeit
        TableColumn<Filmauffuehrung, String> datumZeitColumn = new TableColumn<>("Datum und Uhrzeit");
        datumZeitColumn.setCellValueFactory(new PropertyValueFactory<>("startzeitFormatiert"));
        datumZeitColumn.setPrefWidth(120);
        filmTitelColumn.setPrefWidth(120);// Setzen Sie die Breite auf einen geeigneten Wert


        // Hinzufügen der Spalten zur Tabelle
        tableView.getColumns().addAll(filmTitelColumn, kinosaalColumn, datumZeitColumn);
        
     // Laden der Daten in die Tabelle
        tableView.setItems(FilmauffuehrungenSingleton.getInstance().getFilmauffuehrungen());

        // Event-Handler für den Anlegen-Button
        anlegenButton.setOnAction(event -> oeffneAnlegenDialog());
    }
    

    private void oeffneAnlegenDialog() {
        try {
            // Laden der FXML-Datei
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene12.fxml"));
            Parent root = loader.load();

            // Holen des Controllers für die neue Szene
            scene12Controller anlegenController = loader.getController();
            anlegenController.setHauptController(this);

            // Erstellen eines neuen Fensters (Stage)
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); // Modal, blockiert andere Fenster
            stage.setTitle("Filmaufführung anlegen");
            stage.setScene(new Scene(root));
            stage.showAndWait(); // Zeigt das Fenster und wartet, bis es geschlossen wird
        } catch (Exception e) {
            e.printStackTrace();
            // Behandlung von Fehlern, z.B. FXML-Datei nicht gefunden
        }
    }

    public void aktualisiereTabelle(Filmauffuehrung filmauffuehrung) {
    	FilmauffuehrungenSingleton.getInstance().getFilmauffuehrungen().add(filmauffuehrung);
        tableView.setItems(FilmauffuehrungenSingleton.getInstance().getFilmauffuehrungen());
    }
    public void switchToScene2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }
}
