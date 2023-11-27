package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class scene52Controller {
	
	private List<Stage> zusatzStages = new ArrayList<>();	
	private Kinosaal kinosaal;	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
    @FXML
    private Spinner<Integer> parkettSpinner;
    @FXML
    private Spinner<Integer> logeSpinner;
    @FXML
    private Spinner<Integer> logeMitServiceSpinner;
    @FXML
    private Button anlegenButton;

    public void initialize() {
    	parkettSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
        logeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
        logeMitServiceSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
        anlegenButton.setOnAction(event -> erstelleSitzplaetze());
    }
    public void setKinosaal(Kinosaal kinosaal) {
        this.kinosaal = kinosaal;
    }

    private void erstelleSitzplaetze() {
        if (this.kinosaal == null) {
            this.kinosaal = new Kinosaal("Kino 2", false);
        }

        erstelleReihenFürKategorie(this.kinosaal, Kategorie.PARKETT, parkettSpinner.getValue());
        erstelleReihenFürKategorie(this.kinosaal, Kategorie.LOGE, logeSpinner.getValue());
        erstelleReihenFürKategorie(this.kinosaal, Kategorie.LOGE_MIT_SERVICE, logeMitServiceSpinner.getValue());

        zeigeSitzplatzeinstellungen(this.kinosaal);
    }

    private void erstelleReihenFürKategorie(Kinosaal kinosaal, Kategorie parkett, int anzahlReihen) {
        for (int i = 0; i < anzahlReihen; i++) {
            Reihe reihe = new Reihe(parkett);
            // Hier können Sie die Logik hinzufügen, um die Sitzplätze für jede Reihe zu bestimmen
            kinosaal.addReihe(reihe);
        }
    }

    private void zeigeSitzplatzeinstellungen(Kinosaal kinosaal) {
        VBox vBox = new VBox(10);
        vBox.getChildren().add(new Label("Sitzplatzeinstellungen für " + kinosaal.getName()));

        Kategorie aktuelleKategorie = null;
        int reihenNummer = 1; // Starten der Nummerierung bei 1

        for (Reihe reihe : kinosaal.getSitzreihen()) {
            if (reihe.getKategorie() != aktuelleKategorie) {
                // Kategorienamen anzeigen, wenn sich die Kategorie ändert
                Label kategorieLabel = new Label(reihe.getKategorie().getName() + " Kategorie");
                vBox.getChildren().add(kategorieLabel);
                aktuelleKategorie = reihe.getKategorie();
            }

            HBox hBox = new HBox(5);
            Label reihenLabel = new Label("Reihe " + reihenNummer + ": ");
            Spinner<Integer> sitzSpinner = new Spinner<>(1, 20, 10); // Beispielwerte
            reihe.setSitzplaetzeSpinner(sitzSpinner); // Speichern des Spinners in der Reihe
            hBox.getChildren().addAll(reihenLabel, sitzSpinner);
            vBox.getChildren().add(hBox);

            reihenNummer++; // Reihennummer für jede Reihe erhöhen
        }

        Button anlegenButton = new Button("Kinosaal Anlegen");
        anlegenButton.setOnAction(event -> zeigeKinosaalUebersicht(kinosaal));
        vBox.getChildren().add(anlegenButton);
        System.out.println("Kino geklickt");
        Stage stage = new Stage();
        stage.setScene(new Scene(vBox, 400, 600));
        stage.show();
        zusatzStages.add(stage);
    }

        private void zeigeKinosaalUebersicht(Kinosaal kinosaal) {
        	System.out.println("Übersicht geklickt");
        	// Prüfen, ob der Kinosaal bereits in der Verwaltung existiert
        	 KinosaalVerwaltung.updateOrAddKinosaal(kinosaal);
            
            GridPane gridPane = new GridPane();

            int reihenNummer = 0;
            for (Reihe reihe : kinosaal.getSitzreihen()) {
                reihe.erstelleSitzplaetze(); // Sitzplätze basierend auf dem Spinner-Wert erstellen
                int sitzNummer = 0;
                for (Sitzplatz sitzplatz : reihe.getSitzplaetze()) {
                    Label sitzLabel = new Label(reihe.getKategorie().getName() + " " + (sitzNummer + 1));
                    gridPane.add(sitzLabel, sitzNummer, reihenNummer);
                    sitzNummer++;
                }
                reihenNummer++;
            }
            Button zurueckButton = new Button("Zurück zu Szene 4");
            zurueckButton.setOnAction(event -> zurueckZuScene4());
            gridPane.add(zurueckButton, 0, reihenNummer);

            Stage stage = new Stage();
            stage.setScene(new Scene(gridPane, 600, 400));
            stage.show();
            zusatzStages.add(stage);
        }
        private void zurueckZuScene4() {
            // Schließen Sie alle geöffneten zusätzlichen Stages
            for (Stage s : zusatzStages) {
                if (s != null) {
                    s.close();
                }
            }
            zusatzStages.clear();

            try {
                root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
                scene = new Scene(root);
                // Verwenden Sie die 'stage', die von scene4Controller übergeben wurde
                if (stage != null) {
                    stage.setScene(scene);
                    stage.show();
                } else {
                    // Fehlerbehandlung, falls 'stage' null ist
                    System.err.println("Fehler: 'stage' ist null!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Fehlerbehandlung
            }
        }
        public void switchToScene4(ActionEvent event) throws IOException {
        	  Parent root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        	  scene = new Scene(root);
        	  stage.setScene(scene);
        	  stage.show();
        	 }
        public void setStage(Stage stage) {
            this.stage = stage;
        }
}

